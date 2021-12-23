package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.ComputersPageUI;

public class ComputersPageObject extends BasePage  {
	
	private WebDriver driver;

	public ComputersPageObject(WebDriver driver) {
	
		this.driver = driver;
	}

	public void clickToDesktopsLink() {
		
		
		waitForElementClickable(driver,ComputersPageUI.DESKTOPS_LINK);
		clickToElement(driver,ComputersPageUI.DESKTOPS_LINK);
	}
	
	
	

}
