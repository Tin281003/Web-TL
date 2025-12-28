package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import context.DBContext;
import entity.Type;

public class DAOType implements DAOInterface<Type> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DAOType() {
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Type> getAll() {
		DAOCategory daoC = new DAOCategory();
		List<Type> ls = new ArrayList<Type>();
		String query = "select * from type";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Type(rs.getString(1), daoC.getAll(rs.getString(1))));
			}
		} catch (Exception e) {
		}

		return ls;
	}

	

	@Override
	public Type getById(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		DAOType dao = new DAOType();
		for (Type s : dao.getAll()) {
			System.out.println(s);
		}
	}
}
