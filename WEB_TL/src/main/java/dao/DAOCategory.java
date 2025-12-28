package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;

public class DAOCategory implements DAOInterface<String> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DAOCategory() {
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAll(String s) {
		List<String> ls = new ArrayList<String>();
		String query = "select c_category from CATEGORY where c_type = ?;";
		try {
			ps = conn.prepareStatement(query);
			ps.setNString(1, s);
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ls;
	}

	@Override
	public boolean add(String t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getById(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		DAOCategory dao = new DAOCategory();
		System.out.println(dao.getAll("Món chính"));
	}

}
