package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnUtils {
	
	public static Connection getMySQLConnection() {
		
		String hostName = "localhost";
		String dbName = "automationfc";
		String userName = "root";
		String passWord = "";
		
		return getMySQLConnection(hostName, dbName, userName, passWord);
		
		
	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String passWord) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		try {
			
			// Khai báo class Driver cho MySQL
			// Việc này cần thiết với Java 5
			// Java 6 tự động tìm kiếm Driver thích hợp - ko bắt buộc cần dòng này 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Cấu trúc URL Connection dành cho MySQL
			// Ví dụ: jdbc:mysql://localhost:3306/automationfc
			
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			System.out.println("Connection URL: "+ connectionURL);
			conn = DriverManager.getConnection(connectionURL, userName, passWord);
			System.out.println("Conn: "+ conn);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return conn;
	}

}
