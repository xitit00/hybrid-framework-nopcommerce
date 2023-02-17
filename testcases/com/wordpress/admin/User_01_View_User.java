package com.wordpress.admin;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminUserPO;
import pageObjects.wordpress.PageGeneratorManager;



public class User_01_View_User extends BaseTest {
	
	private WebDriver driver;

	private String adminUsername = "automationfc";
	private String adminPassword = "automationfc2022";

	// khai báo biến viewPostUrl (copy url) để dùng đc cho nhiều TC 
	String searchPostUrl = ""; 
	
	@Parameters({"browser","urlAdmin","urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String urlUser) {
		
		log.info("Pre-Condition - Step 01: Open browser and admin Url");
		driver = getBrowserDriverOnlyOneUrl(browserName, adminUrl);	
		//c3 - che dấu khởi tạo với PageGeneratorManager
		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);
		
		log.info("Pre-Condition - Step 03:  Enter to Username textbox with value: " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_View_User() {
		
		log.info("Create Post - Step 01: Click to 'Users' Menu Link");
		adminUserPage = adminDashboardPage.clickToUserMenuLink();

		log.info("Create Post - Step 02: Get all users from UI");
		int totalNumberUI = adminUserPage.getUserNumberUI();
		
		log.info("Create Post - Step 03: Get all users from DB");
		int totalNumberDB = adminUserPage.getUserNumberDB();
		
		log.info("Create Post - Step 04: Verify Users are matching");
		verifyEquals(totalNumberUI, totalNumberDB);

	}
	
	public void sleepInSecond(long timeoutInSec){
		
		try {
			
			Thread.sleep(timeoutInSec * 1000);
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		closeBrowserAndDriver();
	}
	
	AdminLoginPO adminLoginPage; 
	AdminDashboardPO adminDashboardPage;
	AdminUserPO adminUserPage;
}
