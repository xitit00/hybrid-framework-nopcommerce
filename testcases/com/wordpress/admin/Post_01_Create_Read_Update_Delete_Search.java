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
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	
	private WebDriver driver;

	private String adminUsername = "automationfc";
	private String adminPassword = "automationfc2022";
	private String postTitleValue = "Live Coding Title" + generateFakeNumber();
	private String postBodyValue =  "Live Coding Body" + generateFakeNumber();
	
	// khai báo biến viewPostUrl (copy url) để dùng đc cho nhiều TC 
	String searchPostUrl = ""; 
	
	@Parameters({"browser","urlAdmin"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		
		//c1 - dùng get , set để khởi tạo class và set Driver
//		adminLoginPO = AdminLoginPO.getAdminLoginPageObject();
//		adminLoginPO.setDriver(driver);
		
		//c2 - new = cách này cũng đc , nhưng ko che dấu khởi tạo
		//adminLoginPO = new AdminLoginPO(driver);

		log.info("Pre-Condition - Step 01: Open browser and admin Url");
		driver = getBrowserDriverOnlyOneUrl(browserName, adminUrl);	
		//c3 - che dấu khởi tạo với PageGeneratorManager
		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
		
		log.info("Pre-Condition - Step 02: Enter to Username textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);
		
		
		log.info("Pre-Condition - Step 03:  Enter to Username textbox with value: " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-Condition - Step 04: Click to Login button");
		// c1 chuyển page = cách khởi tạo sẵn từ PageGeneratorManager và gán ( tốn 2 dòng code )
		//adminLoginPage.clickToLoginButton();
		//adminDashboardPage = PageGeneratorManager.getAdminDashboardPO(driver);
		
		// c2 chuyển page = cách che giấu khởi tạo từ PageGeneratorManager ở class TC , mình sẽ giấu việc khởi tạo ở trong 
		// clickToLoginButton() , với việc gôp clickLogin vs chuyển page trong 1 lần ( chỉ tốn 1 dòng code )
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Post() {
		
		// Sau khi login xong -> mình sẽ create new post
		log.info("Create Post - Step 01: Click to 'Posts' Menu Link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
	
		//copy link để mở lại url ( nếu ko có bất kỳ công cụ gì để mở lại url , vd: button , link text , ...)
		log.info("Create Post - Step 02: Get 'Search Posts' page Url");
		searchPostUrl = adminPostSearchPage.getSearchPostPageUrl(driver);
	
		log.info("Create Post - Step 03: Click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitleValue);
		
		log.info("Create Post - Step 05: Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBodyValue);
		
		log.info("Create Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create Post - Step 07: Click to 'Pre Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();
		
		log.info("Create Post - Step 08: Verify 'Post published' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));

	}
	
	@Test
	public void Post_02_Search_Post() {

		// Sau khi Create post success -> mình sẽ chuyển qua search post
		// Open searchPostUrl
		
		log.info("Search Post - Step 01: Open 'Search Post' page");
		
		// mở search post page , trả về trang post search và gán lại luôn từ trang create post 
		
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
	
	}
	
	@Test
	public void Post_03_View_Post() {
		
		
		
	}
	
	@Test
	public void Post_04_Edit_Post() {
		
		
	}
	
	@Test
	public void Post_05_Delete_Post() {
		
		
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
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;

}
