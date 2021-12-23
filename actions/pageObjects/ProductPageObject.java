package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.ProductPageUI;

public class ProductPageObject extends BasePage  {
	
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
	
		this.driver = driver;
	}

	public void clickToProductReview() {
		
		waitForElementClickable(driver,ProductPageUI.PRODUCT_REVIEW_LINK);
		clickToElement(driver,ProductPageUI.PRODUCT_REVIEW_LINK);
		
	}
	
	
	

}
