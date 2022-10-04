package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.wordpress.admin.AdminPostSearchPageUI;

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

}
