package pageObjects.wordpress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.wordpress.AdminUserPageUI;
import utilities.MySQLConnUtils;

public class AdminUserPO extends BasePage {
	
	public WebDriver driver;
	
	public AdminUserPO(WebDriver driver) {
		
		this.driver = driver;
	}

	public int getUserNumberUI() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		String totalNumber = getElementText(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
		String totalArray[] = totalNumber.split(" ");		
		int totalNum = Integer.parseInt(totalArray[0]);
		
		return totalNum;
		
		
	}
	
	public int getUserNumberDB(){
		
	// TODO Auto-generated method stub
		
		// Lấy ra đối tượng Connection kết nối vào DB 
		Connection conn = MySQLConnUtils.getMySQLConnection();
		System.out.println("Opened connection: " + conn);
		 
		Statement statement;
		int count = 0;
		try {
			statement = conn.createStatement();
		
			String sql = "SELECT * FROM wp_users;";
			
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			
			// Duyệt trên kết quả trả về 
			while (rs.next()) {
				
				count++;
				// Di chuyển con trỏ xuống bản ghi kế tiếp
				
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// Đóng kết nối 
			try {
				
				if (conn != null) {
					
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("------------Closed connection-----------");
			
		}
		return count;
		
	}
	
	
	
}
