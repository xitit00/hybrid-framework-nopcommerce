package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
	
	public WebDriver driver;
	
	public AdminPostSearchPO(WebDriver driver) {
		
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		// TODO Auto-generated method stub
		
		AdminPostAddNewPO adminPostAddNewPage =  PageGeneratorManager.getAdminPostAddNewPO(driver);
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return adminPostAddNewPage;
		
	}

	public String getSearchPostPageUrl(WebDriver driver) {
		
		return getPageUrl(driver);
	}

	public void enterToSearchTextbox(String postTitleValue) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitleValue);
		
	}

	public void clickToSearchPostButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_POSTS_BUTTON);
		
	}

	public boolean isPostSearchTableDisplayed(String headerID, String postTitleValue) {
		// TODO Auto-generated method stub
		
		// tìm index cột 
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_ID, headerID) + 1;
		
		// lấy data từ cột vs verify data của cột đó
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex) , postTitleValue);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex) , postTitleValue);
		
	}


}
