package dao;

import java.lang.ProcessHandle.Info;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import context.DBContext;
import entity.Account;
import entity.Cart;
import entity.Food;
import entity.InfoBill;

public class DAOInfoBill implements DAOInterface<InfoBill> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DAOInfoBill() {
		// TODO Auto-generated constructor stub
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<InfoBill> getAll() {
		return null;
	}

	@Override
	public InfoBill getById(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public int price(int BillID) {
		String query = "SELECT SUM(bi_price) FROM BILLINFO WHERE bi_bid = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, BillID);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean add(InfoBill b, int bi_bid) {
		String query = "insert into BILLINFO (bi_bid, bi_fid, bi_count, bi_price)\r\n" + "values (?, ?, ?, ?);";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, bi_bid);
			ps.setInt(2, b.getFood().getId());
			ps.setInt(3, b.getQuantity());
			ps.setInt(4, b.totalPrice());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(InfoBill t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(InfoBill t) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> top3CategorySeller() {
		List<String> result = new ArrayList<String>();
		String query = "SELECT TOP 3 c.c_category, SUM(bi.bi_count) as TotalCount\r\n" + "FROM BILLINFO bi\r\n"
				+ "JOIN FOOD f ON bi.bi_fid = f.f_id\r\n" + "JOIN CATEGORY c ON f.f_category = c.c_category\r\n"
				+ "GROUP BY c.c_category\r\n" + "ORDER BY TotalCount DESC;\r\n";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Map<String, Integer> categorySeller() {
		Map<String, Integer> result = new HashMap<String, Integer>();
//		
		String query = "SELECT c.c_category, SUM(bi.bi_count) as TotalCount\r\n" + "FROM BILLINFO bi\r\n"
				+ "JOIN FOOD f ON bi.bi_fid = f.f_id\r\n" + "JOIN CATEGORY c ON f.f_category = c.c_category\r\n"
				+ "GROUP BY c.c_category;\r\n";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				result.put(rs.getString(1), rs.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int countAll() {
		String query = "select Count(b_id) from BILL ";
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

	public int turnover() {
		String query = "SELECT SUM(bi_price) FROM BILLINFO;";
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

	@Override
	public boolean add(InfoBill t) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		DAOFood dF = new DAOFood();
		Food f = dF.getById("1012");
		InfoBill bi = new InfoBill(f, 3);
		System.out.println(new DAOInfoBill().add(bi, 6));
	}
}
