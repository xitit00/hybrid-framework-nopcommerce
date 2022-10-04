package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static AdminLoginPO getAdminLoginPageObject(WebDriver driver) {
		
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPO(WebDriver driver) {
		
		return new AdminDashboardPO(driver);
	}
	
	public static AdminPostAddNewPO getAdminPostAddNewPO(WebDriver driver) {
		
		return new AdminPostAddNewPO(driver);
	}
	
	public static AdminPostSearchPO getAdminPostSearchPO(WebDriver driver) {
		
		return new AdminPostSearchPO(driver);
	}

}
