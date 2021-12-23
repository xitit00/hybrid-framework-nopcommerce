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

	public void clickToLoginLink() {
		
		waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

	public boolean checkDisplayMyAccount() {
		
		waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
		
	}

	public boolean checkDisplayLogout() {
		
		waitForElementVisible(driver,HomePageUI.LOG_OUT);
		return isElementDisplayed(driver, HomePageUI.LOG_OUT);
	}

	public void clickToMyAccountLink() {
		
		waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}

	public void clickToComputersLink() {
		
		waitForElementClickable(driver,HomePageUI.COMPUTER_LINK);
		clickToElement(driver, HomePageUI.COMPUTER_LINK);
		
	}


}
