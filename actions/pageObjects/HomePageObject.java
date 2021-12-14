package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	
	private WebDriver driver;
	
	public static HomePageObject getHomePageObject() {
		
		HomePageObject hPageObject = new HomePageObject();
		return hPageObject;
	}
	
	public void setDriver(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickToRegisterLink() {
		
		waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}


}
