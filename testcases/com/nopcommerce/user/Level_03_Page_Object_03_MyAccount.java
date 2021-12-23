package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.ComputersPageObject;
import pageObjects.DesktopsPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.ProductPageObject;
import pageObjects.ProductReviewPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_03_MyAccount {
	
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String email;
	private String firstName  = "anh";
	private String lastName = "BTC";
	
	private String updatedFirstName  = "automation";
	private String updatedLastName = "FC";
	private String updatedEmail;
	private String companyName = "VietlinkAds";
	private String dayOfBirth = "24";
	private String monthOfBirth = "11";
	private String yearOfBirth = "1994";
	private String password = "123456";
	private String newPassword = "654321";
	private String confirmPassword = "654321";
	
	private String addFirstName  = "anh";
	private String addLastName = "automation";
	private String addressEmail;
	private String addCountry = "Viet Nam";
	private String addCity = "HCM";
	private String add1 = "201 Lo C P5 Q11";
	private String addPhoneNumber = "0123456789";
	private String addZip = "200000";
	
	private String reviewTitle = "order" + generateFakeNumber();
	private String reviewText = "order sucess" + generateFakeNumber();
	//good => 4 => 80%
	private String reviewRating = "80%;";
	
	private LoginPageObject loginPageObject;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	private MyAccountPageObject myAccountPageObject;
	private ComputersPageObject computersPageObject;
	private DesktopsPageObject desktopsPageObject;
	private ProductPageObject productPageObject;
	private ProductReviewPageObject productReviewPageObject;
	
	@BeforeClass
	public void beforeClass() {
		
		// Mo trinh duyet Firefox
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		
		// Driver sau khi khoi tao thi se co 1 cai ID dc gen ra , dung de gan vao method cua BasePage se ko bi error
		driver = new FirefoxDriver();
		
		// Set timeout tim element
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// open URL 
		driver.get("https://demo.nopcommerce.com/");
		
		email = "anhBTC" + generateFakeNumber() + "@gmail.com"; 
		updatedEmail = "automation" + generateFakeNumber() + "@gmail.com";
		addressEmail = "anhautomation" + generateFakeNumber() + "@gmail.com";
		
		// open URL -> Home : khoi tao Home 
		homePageObject = HomePageObject.getHomePageObject();
		homePageObject.setDriver(driver);
		
		//Click to register link
		homePageObject.clickToRegisterLink();
		
		//Home click Register Link -> qua trang Register -> khởi tạo Register
		registerPageObject = new RegisterPageObject(driver);
		
		//Input to required fields
		registerPageObject.inputFirstName(firstName);
		registerPageObject.inputLastName(lastName);
		registerPageObject.inputEmail(email);
		registerPageObject.inputPassword(password);
		registerPageObject.inputConfirmPassword(password);
		
		//Click to register button
		registerPageObject.clickToRegisterButton();
		
		//Verify success message displayed
		Assert.assertEquals(registerPageObject.getTextRegisterSuccessMess(), "Your registration completed");
		
		//Click to log out
		registerPageObject.clickToLogout();

		//Register click log out to Home -> qua trang Home -> khởi tạo Home
		homePageObject = HomePageObject.getHomePageObject();
		homePageObject.setDriver(driver);
		
		//Click to login link
		homePageObject.clickToLoginLink();
		
		// Home click Login Link -> qua trang Login -> khởi tạo login lại
		loginPageObject = new LoginPageObject(driver);
				
		// Input to required fields
		loginPageObject.inputEmail(email);
		loginPageObject.inputPassword(password);

		// Click to register button
		loginPageObject.clickToLoginButton();

		// Login Sucessfull -> Home
		homePageObject = HomePageObject.getHomePageObject();
		homePageObject.setDriver(driver);

		// verify err confirm password
		Assert.assertTrue(homePageObject.checkDisplayMyAccount());
				
		
	}

	@Test
	public void My_Account_01_Update_Customer_Info() {
		
		//Precondition : register + login successfull
		
		//click to MyAccount link 
		homePageObject.clickToMyAccountLink();
		
		// Home click MyAccount link -> qua MyAccountPage -> khoi tao 
		myAccountPageObject = new MyAccountPageObject(driver);
		
		// input firstname , lastname , email , company  , click radiobtn Gener , select dropdown DateOFBirth 
		myAccountPageObject.clickToGender(); //Male
		myAccountPageObject.inputFirstName(updatedFirstName);
		myAccountPageObject.inputLastName(updatedLastName);
		myAccountPageObject.clickToDayOfBirth(dayOfBirth);
		myAccountPageObject.clickToMonthOfBirth(monthOfBirth);
		myAccountPageObject.clickToYearOfBirth(yearOfBirth);
		myAccountPageObject.inputEmail(updatedEmail);
		myAccountPageObject.inputCompanyName(companyName);
		
		//click to Btn Save 
		myAccountPageObject.clickToSaveInfoButton();
		
		//verify info 
		Assert.assertTrue(myAccountPageObject.checkGenderSelected());
		Assert.assertEquals(myAccountPageObject.getValueTextFirstName(), updatedFirstName);
		Assert.assertEquals(myAccountPageObject.getValueTextLastName(), updatedLastName);
		Assert.assertEquals(myAccountPageObject.getValueSelectedDayOfBirth(), dayOfBirth);
		Assert.assertEquals(myAccountPageObject.getValueSelectedMonthOfBirth(), "November");
		Assert.assertEquals(myAccountPageObject.getValueSelectedYearOfBirth(), yearOfBirth);
		Assert.assertEquals(myAccountPageObject.getValueTextEmail(), updatedEmail);
		Assert.assertEquals(myAccountPageObject.getValueTextCompanyName(), companyName);
		
		//verify login with new Email
		//Click to log out
		registerPageObject.clickToLogout();
		
		// Register click log out to Home -> qua trang Home -> khởi tạo Home
		homePageObject = HomePageObject.getHomePageObject();
		homePageObject.setDriver(driver);

		// Click to login link
		homePageObject.clickToLoginLink();

		// Home click Login Link -> qua trang Login -> khởi tạo login lại
		loginPageObject = new LoginPageObject(driver);

		// Input to required fields
		loginPageObject.inputEmail(updatedEmail);
		loginPageObject.inputPassword(password);

		// Click to register button
		loginPageObject.clickToLoginButton();

		// Login Sucessfull -> Home
		homePageObject = HomePageObject.getHomePageObject();
		homePageObject.setDriver(driver);

		// verify login successfull with My Accout display
		Assert.assertTrue(homePageObject.checkDisplayMyAccount());
		
	}

	@Test
	public void My_Account_02_Add_Address() {

		//click to MyAccount link 
		homePageObject.clickToMyAccountLink();
		
		// Home click MyAccount link -> qua MyAccountPage -> khoi tao 
		myAccountPageObject = new MyAccountPageObject(driver);
		
		//click to Address Link
		myAccountPageObject.clickToAddressLink();
		
		//click to btn Add New
		myAccountPageObject.clickToAddNewBtn();
		
		//input to required fields
		myAccountPageObject.inputAddressFirstName(addFirstName);
		myAccountPageObject.inputAddressLastName(addLastName);
		myAccountPageObject.inputAddressEmail(addressEmail);
		myAccountPageObject.selectCountry(addCountry);
		myAccountPageObject.inputAddressCity(addCity);
		myAccountPageObject.inputAddress1(add1);
		myAccountPageObject.inputZipCode(addZip);
		myAccountPageObject.inputAddressPhoneNumber(addPhoneNumber);
		
		//click to btn Save
		myAccountPageObject.clickToSaveAddressButton();
		
		//verify info Address Added 
		
		//anh automation
		String name = addFirstName + " " + addLastName;
		Assert.assertEquals(myAccountPageObject.getTextAddressName(), name);
		String emailResults[] = myAccountPageObject.getTextAddressEmail().split(" ");
		System.out.println(emailResults[1]);
		Assert.assertEquals(emailResults[1], addressEmail);
		String phoneResults[] = myAccountPageObject.getTextAddressPhone().split(" ");
		Assert.assertEquals(phoneResults[2], addPhoneNumber);
		Assert.assertEquals(myAccountPageObject.getTextAddress1(), add1);
		Assert.assertEquals(myAccountPageObject.getTextAddressCountry(), addCountry);
		//HCM, 200000
		String cityAndZip = addCity + ", " + addZip;
		Assert.assertEquals(myAccountPageObject.getTextAddressCityAndZipCode(), cityAndZip);
		
	}
	
	@Test
	public void My_Account_03_Change_Password() {
		
		//click to Change Password Link
		myAccountPageObject.clickToChangePasswordLink();
		
		//input required fields
		myAccountPageObject.inputOldPassword(password);
		myAccountPageObject.inputNewPassword(newPassword);
		myAccountPageObject.inputConfirmPassword(confirmPassword);
		
		//click to change password button
		myAccountPageObject.clickToChangePasswordButton();
		
		//verify password was changed display
		Assert.assertTrue(myAccountPageObject.checkPasswordChangedDisplay());
		
		//click to close notification : Password was changed
		myAccountPageObject.clickToCloseNotification();
		
		//verify login by new password ( updated password )
		//click to logout 
		registerPageObject.clickToLogoutByJS();
		
		// Register click log out to Home -> qua trang Home -> khởi tạo Home
		homePageObject = HomePageObject.getHomePageObject();
		homePageObject.setDriver(driver);

		// Click to login link
		homePageObject.clickToLoginLink();

		// Home click Login Link -> qua trang Login -> khởi tạo login lại
		loginPageObject = new LoginPageObject(driver);

		// Input to required fields
		loginPageObject.inputEmail(updatedEmail);
		loginPageObject.inputPassword(newPassword);

		// Click to register button
		loginPageObject.clickToLoginButton();

		// Login Sucessfull -> Home
		homePageObject = HomePageObject.getHomePageObject();
		homePageObject.setDriver(driver);

		// verify login successfull with My Accout display
		Assert.assertTrue(homePageObject.checkDisplayMyAccount());
		
	}
	@Test
	public void My_Account_04_My_Product_Reviews() {
		
		//click to Computers link
		homePageObject.clickToComputersLink();
				
		//Home click Computers link -> qua ComputersPage -> khoi tao 
		computersPageObject = new ComputersPageObject(driver);
		
		//click to Desktops link
		computersPageObject.clickToDesktopsLink();
		
		//Computers page -> Desktops page -> khoi tao
		desktopsPageObject = new DesktopsPageObject(driver);
		
		//click to product item
		desktopsPageObject.clickToProductItem();
		
		//Desktops page -> Product page -> khoi tao iep
		productPageObject = new ProductPageObject(driver);
		
		//click to product review
		productPageObject.clickToProductReview();
		
		//Product page -> product review -> khoi tao
		productReviewPageObject = new ProductReviewPageObject(driver);
		
		//input required fields 
		productReviewPageObject.inputReviewTitle(reviewTitle);
		productReviewPageObject.inputReviewText(reviewText);
		productReviewPageObject.selectReviewRating();
		productReviewPageObject.clickReviewSubmit();
		
		//verify reivew added successfully 
		Assert.assertTrue(productReviewPageObject.checkReviewMessageDisplay());
		Assert.assertEquals(productReviewPageObject.getTextReviewTitle(), reviewTitle);
		Assert.assertEquals(productReviewPageObject.getTextReviewText(), reviewText);
		String ratingResults[] = productReviewPageObject.getAttributeReviewRating().split(" ");
		Assert.assertEquals(ratingResults[1], reviewRating);
		
		
		//verify product review in MyAccount
		//click to MyAccount link 
		homePageObject.clickToMyAccountLink();
		
		// Home click MyAccount link -> qua MyAccountPage -> khoi tao 
		myAccountPageObject = new MyAccountPageObject(driver);
		
		myAccountPageObject.clickToMyProductReviewsLink();
		
		//verify review added successfully
		Assert.assertEquals(productReviewPageObject.getTextReviewTitle(), reviewTitle);
		Assert.assertEquals(productReviewPageObject.getTextReviewText(), reviewText);
		String rating1Results[] = productReviewPageObject.getAttributeReviewRating().split(" ");
		Assert.assertEquals(rating1Results[1], reviewRating);
		
	}
	

	public int generateFakeNumber() {
		
		Random random = new Random();
		return random.nextInt(99999);
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
		
		//driver.quit();
	}

}
