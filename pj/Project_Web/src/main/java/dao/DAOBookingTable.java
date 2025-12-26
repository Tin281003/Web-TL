package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import context.DBContext;
import entity.BookingTable;

public class DAOBookingTable implements DAOInterface<BookingTable> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DAOBookingTable() {
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BookingTable> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingTable getById(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(BookingTable t) {
		String query = "insert into BOOKINGTABLE (bt_email, bt_phone, bt_date, bt_quantity, bt_time)"
				+ "values (?, ?, ?, ?, ?);";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getDate());
			ps.setString(4, t.getQuantity());
			ps.setString(5, t.getTime());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(BookingTable t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BookingTable t) {
		// TODO Auto-generated method stub
		return false;
	}

}
