package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	// Chỉ để tên máy hoặc localhost, KHÔNG để dấu gạch chéo ở đây
	private final String serverName = "localhost";
	private final String dbName = "Web";
	// Đưa SQLEXPRESS vào biến instance riêng
	private final String instance = "SQLEXPRESS";
	private final String userID = "sa";
	private final String password = "sa";
	protected Connection connection;

	public Connection getConnection() throws Exception {
		try {
			// SỬA LẠI URL: Bỏ portNumber, dùng instanceName tham số
			String url = "jdbc:sqlserver://" + serverName + ";instanceName=" + instance + ";databaseName=" + dbName
					+ ";" + "encrypt=true;trustServerCertificate=true";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userID, password);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Lỗi rồi: " + ex.getMessage());
		}
		return connection;
	}
	public static void main(String[] args) {
		DBContext db = new DBContext();
		try {
			System.out.println("Đang thử kết nối đến SQL Server...");
			Connection conn = db.getConnection();
			
			if (conn != null && !conn.isClosed()) {
				System.out.println("==========================================");
				System.out.println("KẾT NỐI THÀNH CÔNG!");
				System.out.println("Database đang dùng: " + conn.getCatalog());
				System.out.println("Trạng thái: Sẵn sàng làm việc.");
				System.out.println("==========================================");
				
				// Đóng kết nối sau khi test xong
				conn.close();
			} else {
				System.err.println("==========================================");
				System.err.println("KẾT NỐI THẤT BẠI!");
				System.err.println("Nguyên nhân: Đối tượng Connection bị null hoặc đã đóng.");
				System.err.println("Hãy kiểm tra lại: SQL Browser, TCP/IP và Port 1433.");
				System.err.println("==========================================");
			}
		} catch (Exception e) {
			System.err.println("Xảy ra lỗi nghiêm trọng khi chạy chương trình:");
			e.printStackTrace();
		}
	}
}
