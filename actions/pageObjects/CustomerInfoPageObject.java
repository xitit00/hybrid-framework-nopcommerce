package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.BasePageUI;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	
	public WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
	
		this.driver = driver;
	}

	public boolean checkDisplayCustomerInfoPage() {
		
	
		waitForElementVisible(driver,CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver,CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		
	}

}
