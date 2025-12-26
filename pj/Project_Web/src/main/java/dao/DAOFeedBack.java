package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.FeedBack;
import entity.Food;

public class DAOFeedBack implements DAOInterface<FeedBack> {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DAOFeedBack() {
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FeedBack> getAll() {
		List<FeedBack> ls = new ArrayList<FeedBack>();
		String query = "select * from FEEDBACK";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new FeedBack(rs.getNString(1), rs.getString(2), rs.getString(3), rs.getNString(4)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	@Override
	public FeedBack getById(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(FeedBack t) {
		String query = "INSERT INTO FEEDBACK VALUES (?,?,?,?);";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, t.getName());
			ps.setString(2, t.getEmail());
			ps.setString(3, t.getPhone());
			ps.setString(4, t.getContent());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(FeedBack t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(FeedBack t) {
		// TODO Auto-generated method stub
		return false;
	}

	public int countAll() {
		String query = "select Count(*) from FEEDBACK ";
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
		DAOFeedBack dao = new DAOFeedBack();
		dao.add(new FeedBack("b", "b", "b", "b"));
	}

}
