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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	
	private WebDriver driver;
	private String emailExisting;
	private String emailInvalid = "anh.1234";
	private String emailNotFound;
	
	private String firstName  = "anh";
	private String lastName = "BTC";
	private String password = "123456";
	
	
	private LoginPageObject loginPageObject;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		
		// Set timeout tim element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// open URL 
		driver.get("https://demo.nopcommerce.com/");
		
		emailExisting = "anhBTC" + generateFakeNumber() + "@gmail.com"; 
		emailNotFound = "anhBTC" + generateFakeNumber() + "@mail.com";

		// open URL -> Home : khoi tao Home 
		homePageObject = PageGeneratorManager.getHomePage();
		homePageObject.setDriver(driver);		
		
		//Home click Register Link -> qua trang Register -> khởi tạo Register
		registerPageObject = homePageObject.clickToRegisterLink();
		
		//Input to required fields
		registerPageObject.inputFirstName(firstName);
		registerPageObject.inputLastName(lastName);
		registerPageObject.inputEmail(emailExisting);
		registerPageObject.inputPassword(password);
		registerPageObject.inputConfirmPassword(password);
		
		//Click to register button
		registerPageObject.clickToRegisterButton();
		
		//Verify success message displayed
		Assert.assertEquals(registerPageObject.getTextRegisterSuccessMess(), "Your registration completed");
		
		//Register click log out to Home -> qua trang Home -> khởi tạo Home
		homePageObject = registerPageObject.clickToLogout();

	}

	@Test
	public void Login_01_Empty_Data() {
		
		//Click to login link
		loginPageObject = homePageObject.clickToLoginLink();
		
		//Click to login button
		loginPageObject.clickToLoginButton();
		
		//Verify err message display
		Assert.assertEquals(loginPageObject.getErrMessageEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		
		//Home click Login Link -> qua trang Login -> khởi tạo login lại 
		loginPageObject = homePageObject.clickToLoginLink();
		
		//Input to required fields
		loginPageObject.inputEmail(emailInvalid);
	
		//Click to login button
		loginPageObject.clickToLoginButton();
		
		//Verify err message display
		Assert.assertEquals(loginPageObject.getErrMessageEmailTextbox() , "Wrong email");
	
	}
	
	@Test
	public void Login_03_Email_Not_Found() {
		
		//Home click Login Link -> qua trang Login -> khởi tạo login lại 
		loginPageObject = homePageObject.clickToLoginLink();
		
		//Input to required fields
		loginPageObject.inputEmail(emailNotFound);
		
		//Click to login button
		loginPageObject.clickToLoginButton();
		
		//Verify success message displayed
		Assert.assertEquals(loginPageObject.getErrMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
	}
	
	@Test
	public void Login_04_Existing_Email_And_Empty_Password() {
		
		//Home click Login Link -> qua trang Login -> khởi tạo login lại 
		loginPageObject = homePageObject.clickToLoginLink();
		
		//Input to required fields
		loginPageObject.inputEmail(emailExisting);
		loginPageObject.inputPassword("");
		
		//Click to login button
		loginPageObject.clickToLoginButton();
		
		//verify email exists 
		Assert.assertEquals(loginPageObject.getErrMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	
	@Test
	public void Login_05_Existings_Email_And_Wrong_Password() {
		
		//Home click Login Link -> qua trang Login -> khởi tạo login lại 
		loginPageObject = homePageObject.clickToLoginLink();
		
		//Input to required fields
		loginPageObject.inputEmail(emailExisting);
		loginPageObject.inputPassword("123");
		
		//Click to register button
		loginPageObject.clickToLoginButton();
		
		//verify err password
		Assert.assertEquals(loginPageObject.getErrMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		
	}
	
	@Test
	public void Login_06_Email_Password_Successfully() {

		// Home click Login Link -> qua trang Login -> khởi tạo login lại
		loginPageObject = homePageObject.clickToLoginLink();
		
		// Input to required fields
		loginPageObject.inputEmail(emailExisting);
		loginPageObject.inputPassword(password);

		//Login Sucessfull -> Home
		homePageObject = loginPageObject.clickToLoginButton();
		
		//verify err confirm password
		Assert.assertTrue(homePageObject.checkDisplayMyAccountLink());
		Assert.assertTrue(homePageObject.checkDisplayLogout());
		
		
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
