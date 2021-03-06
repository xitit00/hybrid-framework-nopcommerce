package com.nopcommerce.user;

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
import common.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	
	private WebDriver driver;
	private String email;

	
	private String firstName  = "anh";
	private String lastName = "BTC";
	private String password = "123456";
	
	
	private UserLoginPageObject loginPageObject;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserCustomerInfoPageObject customerInfoPageObject;
	private UserAddressPageObject addressPageObject;
	private UserRewardPointPageObject rewardPointPageObject;
	private UserMyProductReviewPageObject myProductReviewPageObject;
	
	@Parameters({"browser","environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environment) {

		driver = getBrowserDriver(browserName, environment);
		
		// Set timeout tim element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// open URL 
		driver.get("https://demo.nopcommerce.com/");
		
		email = "anhBTC" + generateFakeNumber() + "@gmail.com"; 
		

		// open URL -> Home : khoi tao Home 
		homePageObject = PageGeneratorManager.getUserHomePage();
		homePageObject.setDriver(driver);		

	}

	@Test
	public void User_01_Register() {

		// Home click Register Link -> qua trang Register -> kh???i t???o Register
		registerPageObject = homePageObject.clickToRegisterLink();

		// Input to required fields
		registerPageObject.inputFirstName(firstName);
		registerPageObject.inputLastName(lastName);
		registerPageObject.inputEmail(email);
		registerPageObject.inputPassword(password);
		registerPageObject.inputConfirmPassword(password);

		// Click to register button
		registerPageObject.clickToRegisterButton();

		// Verify success message displayed
		Assert.assertEquals(registerPageObject.getTextRegisterSuccessMess(), "Your registration completed");

		// Register click log out to Home -> qua trang Home -> kh???i t???o Home
		homePageObject = registerPageObject.clickToLogout();
		
	}

	@Test
	public void User_02_Login() {
		
		// Home click Login Link -> qua trang Login -> kh???i t???o login l???i
		loginPageObject = homePageObject.clickToLoginLink();

		// Input to required fields
		loginPageObject.inputEmail(email);
		loginPageObject.inputPassword(password);

		// Login Sucessfull -> Home
		homePageObject = loginPageObject.clickToLoginButton();
		
		//verify err confirm password
		Assert.assertTrue(homePageObject.checkDisplayMyAccountLink());
	}
	
	@Test
	public void User_03_My_Account() {
		
		customerInfoPageObject = homePageObject.openMyAccountPage();
		Assert.assertTrue(customerInfoPageObject.checkDisplayCustomerInfoPage());
	}
	
	@Test
	public void User_04_Switch_Page() {
		
		// Knowledge cua3 Page Object:
		// M???t page A khi chuy???n qua page B th?? ph???i vi???t 1 h??m 
		// Thay v?? t???o ra h??m l???p l???i nhi???u l???n ??? page ??a chi???u th?? gom l???i c??c h??m openPage vi???t ??? 1 ch??? l?? BasePage ????? d??? qu???n l?? 
		// sau ???? ??? testcase th?? nh??? vi???c c??c pageObject ?????u k??? th???a basePage , n??n t???i pageObject ??ang ?????ng c?? th??? g???i th???ng ra pageObject 
		// mu???n chuy???n t???i vd : Customer Info -> Address - addressPageObject = customerInfoPageObject.openAddressPage(driver);
		// (action : open/ click / ...: link / button / image / ... ) ????? m??? page B ???? l??n
		
		// Customer Info -> Address
		addressPageObject = customerInfoPageObject.openAddressPage(driver);
		
		// Address -> My Product Review 
		myProductReviewPageObject = addressPageObject.openMyProductReviewPage(driver);
		
		// My Product Review -> Reward Point
		rewardPointPageObject = myProductReviewPageObject.openRewardPointPage(driver);
		
		// Reward Point -> Address
		addressPageObject = rewardPointPageObject.openAddressPage(driver);
		
		// Address -> Reward Point
		rewardPointPageObject = addressPageObject.openRewardPointPage(driver);
		
		// Reward Point -> My Product Preview
		myProductReviewPageObject = rewardPointPageObject.openMyProductReviewPage(driver);
	}
	
	@Test
	public void User_05_Switch_Role() {
		//Switch Role
		System.out.println("Switch Role");
	}

	

	public void sleepInSecond(long timeoutInSec){
		
		try {
			
			Thread.sleep(timeoutInSec * 1000);
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
