package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.wordpress.UserHomePageUI;


public class UserHomePO extends BasePage {
	
	public WebDriver driver;
	
	public UserHomePO(WebDriver driver) {
		
		this.driver = driver;
	}

	public boolean isPostInfoDisplayed(String postTitle, String postInfo, String key) {
		// TODO Auto-generated method stub body
		
		Boolean b = true;
		

		if (key == "AUTHOR") {
			
			waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, postInfo);
			b = isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, postInfo);
		}
		else if (key == "BODY") {
			
			waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postInfo);
			b = isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postInfo);
		}
		else {
			
			waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, postInfo);
			b = isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, postInfo);
		}
		
			
		return b;
	}
	
	public boolean isPostTitleDisplayed(String postTitleValue) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitleValue);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitleValue);
		
		
	}

	public UserPostDetailPO clickToPostTitle(String postTitleValue) {
		// TODO Auto-generated method stub
		
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitleValue);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitleValue);
		return PageGeneratorManager.getUserPostDetailPO(driver);
	}

}
