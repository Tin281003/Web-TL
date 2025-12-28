package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.Cart;

public class DAOBill implements DAOInterface<Cart> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DAOBill() {
		// TODO Auto-generated constructor stub
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean add(Cart b) {
		String query = "insert into BILL (b_name, b_address, b_email, b_phone, b_note)\r\n" + "values (?, ?, ?, ?,?);";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, b.getNameCustomer());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getPhone());
			ps.setString(5, b.getNote());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean add(Cart b, int id) {
		String query = "insert into BILL ( b_name, b_address, b_email, b_phone, b_note,b_aid)\r\n"
				+ "values (?, ?, ?, ?,?,?);";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, b.getNameCustomer());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getPhone());
			ps.setString(5, b.getNote());
			ps.setInt(6, id);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> getAll() {
		List<Cart> result = new ArrayList<Cart>();
		String query = "select * from bill order by b_id DESC";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Cart getById(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Cart t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cart t) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getIdNewest() {
		String query = "SELECT MAX(b_id) FROM BILL";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {

		DAOBill d = new DAOBill();
		for (Cart c : d.getAll()) {
			System.out.println(c.toString());
		}
	}

}
