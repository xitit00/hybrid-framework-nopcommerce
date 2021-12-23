package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.DesktopsPageUI;

public class DesktopsPageObject extends BasePage  {
	
	private WebDriver driver;

	public DesktopsPageObject(WebDriver driver) {
	
		this.driver = driver;
	}

	public void clickToProductItem() {
	
		waitForElementClickable(driver,DesktopsPageUI.PRODUCT_LINK);
		clickToElement(driver,DesktopsPageUI.PRODUCT_LINK);
		
	}
	
	
	

}
