package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.Food;
import entity.Type;

public class DAOFood implements DAOInterface<Food> {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DAOFood() {
		try {
			conn = new DBContext().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Food> getAll() {
		List<Food> ls = new ArrayList<Food>();
		String query = "select * from Food";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	public List<Food> getAll(int costFilter1, int costFilter2) {
		List<Food> ls = new ArrayList<Food>();
		String query = "select * from Food";
		if (costFilter1 != 0 || costFilter2 != 0) {
			query += " WHERE (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
		}
		try {
			ps = conn.prepareStatement(query);
			if (costFilter1 != 0 || costFilter2 != 0) {
				ps.setInt(1, costFilter1);
				ps.setInt(2, costFilter2);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	public List<Food> getAll(int start, int count, int costFilter1, int costFilter2) {
		List<Food> ls = new ArrayList<Food>();
		String query = "select * from Food";
		if (costFilter1 != 0 || costFilter2 != 0) {
			query += " WHERE (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
		}
		try {
			ps = conn.prepareStatement(query);
			if (costFilter1 != 0 || costFilter2 != 0) {
				ps.setInt(1, costFilter1);
				ps.setInt(2, costFilter2);
			}
			rs = ps.executeQuery();
			for (int i = 0; i < start; i++) {
				rs.next();
			}
			for (int i = 0; i < count; i++) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				rs.next();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	@Override
	public Food getById(String s) {
		String query = "select * from food" + " where f_id = ?;";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, s);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Food> getByName(String name) {
		List<Food> ls = new ArrayList<Food>();
		String query = "SELECT * " + "FROM Food " + " WHERE dbo.ufn_removeMark(f_name) LIKE ? OR f_name LIKE ?";
		String s = "%" + name + "%";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, s);
			ps.setString(2, s);
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	public List<Food> getByName(String name, int start, int count) {
		List<Food> ls = new ArrayList<Food>();
		String query = "SELECT * " + "FROM Food " + " WHERE dbo.ufn_removeMark(f_name) LIKE ? OR f_name LIKE ?";
		String s = "%" + name + "%";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, s);
			ps.setString(2, s);
			rs = ps.executeQuery();
			for (int i = 0; i < start; i++) {
				rs.next();
			}
			for (int i = 0; i < count; i++) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				rs.next();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	public List<Food> getByType(String name, int costFilter1, int costFilter2) {
		List<Food> ls = new ArrayList<Food>();
		String query = "SELECT FOOD.* FROM TYPE " + " JOIN CATEGORY ON TYPE.t_type = CATEGORY.c_type "
				+ " JOIN FOOD ON CATEGORY.c_category = FOOD.f_category " + "Where t_type = ?";
		if (costFilter1 != 0 || costFilter2 != 0) {
			query += " AND (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
		}
		try {
			ps = conn.prepareStatement(query);
			if (costFilter1 != 0 || costFilter2 != 0) {
				ps.setInt(1, costFilter1);
				ps.setInt(2, costFilter2);
			}
			ps.setNString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls;
	}

	public List<Food> getByType(String name, int start, int count, int costFilter1, int costFilter2) {
		List<Food> ls = new ArrayList<Food>();
		String query = "SELECT FOOD.* FROM TYPE " + " JOIN CATEGORY ON TYPE.t_type = CATEGORY.c_type "
				+ " JOIN FOOD ON CATEGORY.c_category = FOOD.f_category " + "Where t_type = ?";
		if (costFilter1 != 0 || costFilter2 != 0) {
			query += " AND (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
		}
		try {
			ps = conn.prepareStatement(query);
			ps.setNString(1, name);
			if (costFilter1 != 0 || costFilter2 != 0) {
				ps.setInt(2, costFilter1);
				ps.setInt(3, costFilter2);
			}
			rs = ps.executeQuery();
			for (int i = 0; i < start; i++) {
				rs.next();
			}
			for (int i = 0; i < count; i++) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls;
	}

	public List<Food> getByCategory(String name, int costFilter1, int costFilter2) {
		List<Food> ls = new ArrayList<Food>();
		String query = "select * from Food where f_category = ? ";
		if (costFilter1 != 0 || costFilter2 != 0) {
			query += " AND (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
		}
		try {
			ps = conn.prepareStatement(query);
			ps.setNString(1, name);
			if (costFilter1 != 0 || costFilter2 != 0) {
				ps.setInt(2, costFilter1);
				ps.setInt(3, costFilter2);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls;
	}

	public List<Food> getByCategory(String name, int start, int count, int costFilter1, int costFilter2) {
		List<Food> ls = new ArrayList<Food>();
		String query = "select * from Food where f_category = ? ";
		if (costFilter1 != 0 || costFilter2 != 0) {
			query += " AND (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
		}
		try {
			ps = conn.prepareStatement(query);
			ps.setNString(1, name);
			if (costFilter1 != 0 || costFilter2 != 0) {
				ps.setInt(2, costFilter1);
				ps.setInt(3, costFilter2);
			}
			rs = ps.executeQuery();
			for (int i = 0; i < start; i++) {
				rs.next();
			}
			for (int i = 0; i < count; i++) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls;
	}

	public List<Food> sortByPrice(boolean ASC) {
		List<Food> ls = new ArrayList<Food>();
		String query = "SELECT * FROM FOOD ORDER BY f_price - (f_price * f_discount / 100) ";
		if (!ASC) {
			query += " desc";
		}
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	public List<Food> sortByPrice(boolean ASC, int start, int count, String type, String category, int costFilter1,
			int costFilter2) {
		List<Food> ls = new ArrayList<Food>();
		String query = "SELECT * FROM FOOD";
		boolean hasCondition = false;

		if (type != null) {
			query += " JOIN CATEGORY ON FOOD.f_category = CATEGORY.c_category  "
					+ "JOIN [TYPE] ON CATEGORY.c_type = TYPE.t_type " + "WHERE TYPE.t_type = ?";
			hasCondition = true;
		}

		if (category != null) {
			if (!hasCondition) {
				query += " WHERE FOOD.f_category = ?";
				hasCondition = true;
			} else {
				query += " AND FOOD.f_category = ?";
			}
		}

		if (costFilter1 != 0 || costFilter2 != 0) {
			if (!hasCondition) {
				query += " WHERE (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
				hasCondition = true;
			} else {
				query += " AND (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
			}
		}

		query += " ORDER BY (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 )";

		if (!ASC) {
			query += " DESC";
		}

		try {
			int countSet = 0;
			ps = conn.prepareStatement(query);
			if (category != null) {
				ps.setNString(1, category);
				countSet++;
			} else if (type != null) {
				ps.setNString(1, type);
				countSet++;
			}
			if (costFilter1 != 0 || costFilter2 != 0) {
				ps.setInt(1 + countSet, costFilter1);
				ps.setInt(2 + countSet, costFilter2);
			}
			rs = ps.executeQuery();
			for (int i = 0; i < start; i++) {
				rs.next();
			}
			for (int i = 0; i < count; i++) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				rs.next();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	public List<Food> sortByName(boolean ASC) {
		List<Food> ls = new ArrayList<Food>();
		String query = "select * from FOOD order by f_name";
		if (!ASC) {
			query += " desc";
		}
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	public List<Food> sortByName(boolean ASC, int start, int count, String type, String category, int costFilter1,
			int costFilter2) {
		List<Food> ls = new ArrayList<Food>();
		String query = "SELECT * FROM FOOD";
		boolean hasCondition = false;

		if (type != null) {
			query += " JOIN CATEGORY ON FOOD.f_category = CATEGORY.c_category  "
					+ "JOIN [TYPE] ON CATEGORY.c_type = TYPE.t_type " + "WHERE TYPE.t_type = ?";
			hasCondition = true;
		}

		if (category != null) {
			if (!hasCondition) {
				query += " WHERE FOOD.f_category = ?";
				hasCondition = true;
			} else {
				query += " AND FOOD.f_category = ?";
			}
		}

		if (costFilter1 != 0 || costFilter2 != 0) {
			if (!hasCondition) {
				query += " WHERE (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
				hasCondition = true;
			} else {
				query += " AND (FOOD.f_price - (FOOD.f_price * FOOD.f_discount) /100 ) BETWEEN ? AND ?";
			}
		}

		query += " ORDER BY FOOD.f_name";

		if (!ASC) {
			query += " DESC";
		}

		try {
			int countSet = 0;
			ps = conn.prepareStatement(query);
			if (category != null) {
				ps.setNString(1, category);
				countSet++;
			} else if (type != null) {
				ps.setNString(1, type);
				countSet++;
			}
			if (costFilter1 != 0 || costFilter2 != 0) {
				ps.setInt(1 + countSet, costFilter1);
				ps.setInt(2 + countSet, costFilter2);
			}
			rs = ps.executeQuery();
			for (int i = 0; i < start; i++) {
				rs.next();
			}
			for (int i = 0; i < count; i++) {
				ls.add(new Food(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8)));
				rs.next();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return ls;
	}

	@Override
	public boolean add(Food t) {
		String query = "insert into FOOD (f_name, f_price, f_discount, f_urlImg, f_describe, f_category, f_ingredient)"
				+ "values (?,?,?,?,?,?,?);";
		try {
			ps = conn.prepareStatement(query);
			ps.setNString(1, t.getName());
			ps.setDouble(2, t.getPrice());
			ps.setInt(3, t.getDiscount());
			ps.setNString(4, t.getUrlImg());
			ps.setNString(5, t.getDescribe());
			ps.setNString(6, t.getCategory());
			ps.setNString(7, t.getIngredient());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Food t) {
		String query = "update FOOD SET f_name = ? , f_price = ?, f_describe = ?, f_ingredient = ?,f_discount = ? where f_id = ?;";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, t.getName());
			ps.setDouble(2, t.getPrice());
			ps.setNString(3, t.getDescribe());
			ps.setNString(4, t.getIngredient());
			ps.setInt(5, t.getDiscount());
			ps.setInt(6, t.getId());
			ps.executeUpdate();
			return true;
		} catch (

		Exception e) {
			System.out.println(e);
		}

		return false;
	}

	@Override
	public boolean delete(Food t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteById(int id) {
		String query = "DELETE FROM FOOD WHERE f_id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static void main(String[] args) {
		DAOFood dao = new DAOFood();

		for (Food f : dao.sortByPrice(false, 1, 10, null, null, 0, 0)) {
			System.out.println(f.getPrice());
		}
	}

}
