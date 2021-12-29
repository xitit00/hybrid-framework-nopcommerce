package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage() {
		
		return new HomePageObject();
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		
		return new LoginPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		
		return new MyAccountPageObject(driver);
	}
	
	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		
		return new CustomerInfoPageObject(driver);
	}
	
	public static AddressPageObject getAddressPage(WebDriver driver) {
		
		return new AddressPageObject(driver);
	}

	public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
	
		return new RewardPointPageObject(driver);
	
	}
	
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		
		return new MyProductReviewPageObject(driver);
	
	}

}
