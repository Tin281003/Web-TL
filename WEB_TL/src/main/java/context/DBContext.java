package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	private final String serverName = "DESKTOP-TA4B579\\SQLEXPRESS";
	private final String dbName = "Web";
	private final String portNumber = "1433";
	private final String instance = "";// LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String userID = "sa";
	private final String password = "sa";
	protected Connection connection;

	public Connection getConnection() throws Exception {
		try {
			// Edit URL , username, password to authenticate with your MS SQL Server
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";"
					+ "encrypt=true;trustServerCertificate=true";
			String username = "sa";
			String password = "sa";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}
		return connection;
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
