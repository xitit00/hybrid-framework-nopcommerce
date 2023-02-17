package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLTestConnection {
	
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		// Lấy ra đối tượng Connection kết nối vào DB 
		Connection conn = MySQLTestConnection.getMyConnection();
		
		System.out.println("Opened connection: " + conn);
		 
		Statement statement = conn.createStatement();
		
		int count = 0;
		
		String sql = "SELECT * FROM wp_users;";
		
		// Thực thi câu lệnh SQL trả về đối tượng ResultSet
		ResultSet rs = statement.executeQuery(sql);
		
		// Duyệt trên kết quả trả về 
		while (rs.next()) {
			
			// Di chuyển con trỏ xuống bản ghi kế tiếp
			count++;
			
			// getInt(1) hay getString(2) là lấy theo num cột.
			int userID = rs.getInt(1);
			String userLogin = rs.getString(2);
			
			// getString("user_email") là lấy theo tên cột.
			String userEmail = rs.getString("user_email");
			
			System.out.println("-----------------------");
			System.out.println("User Id: " + userID);
			System.out.println("User Login: " + userLogin);
			System.out.println("User Email: " + userEmail);
		}
	
		// Đóng kết nối 
		conn.close();
		System.out.println("------------Closed connection-----------");
		System.out.println("Total count: " + count);
	}

}
