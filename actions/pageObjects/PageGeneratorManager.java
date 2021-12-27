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

}
