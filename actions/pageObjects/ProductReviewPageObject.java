package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage  {
	
	private WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
	
		this.driver = driver;
	}

	public void inputReviewTitle(String textValue) {
		
		sendkeyToElement(driver,ProductReviewPageUI.REVIEW_TITLE_TEXTBOX, textValue);
	}

	public void inputReviewText(String textValue) {
		
		sendkeyToElement(driver,ProductReviewPageUI.REVIEW_TEXT_TEXTBOX, textValue);
	}

	public void selectReviewRating() {
		
		waitForElementClickable(driver,ProductReviewPageUI.REVIEW_RATING_RADIO_BUTTON);
		clickToElement(driver,ProductReviewPageUI.REVIEW_RATING_RADIO_BUTTON);
	}

	public void clickReviewSubmit() {
	
		waitForElementClickable(driver,ProductReviewPageUI.REVIEW_SUBMIT_BUTTON);
		clickToElement(driver,ProductReviewPageUI.REVIEW_SUBMIT_BUTTON);
		
	}

	public String getAttributeReviewRating() {
	
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_RATING);
		return getElementAttribute(driver, ProductReviewPageUI.REVIEW_RATING, "style");
	}

	public String getTextReviewTitle() {

		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TITLE);
		return getElementText(driver, ProductReviewPageUI.REVIEW_TITLE);
	}

	public String getTextReviewText() {
		
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_TEXT);
		return getElementText(driver, ProductReviewPageUI.REVIEW_TEXT);
	}

	public boolean checkReviewMessageDisplay() {
	
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_MESSAGE);
		return isElementDisplayed(driver,ProductReviewPageUI.REVIEW_MESSAGE);
		
	}
	

}
