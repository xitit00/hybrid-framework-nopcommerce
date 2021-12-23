package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		
		this.driver = driver;
	}
	
	// quản lý các hàm trong LoginPageObject , chứa những actions mình cần trong page Login 

	public void clickToLoginButton() {
		
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		
	}

	public String getErrMessageEmailTextbox() {
		
		return getElementText(driver, LoginPageUI.EMAIL_ERR);
	}

	public void inputEmail(String textValue) {
	
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, textValue);
		
	}

	public String getErrMessageUnsuccessful() {
		// TODO Auto-generated method stub
		return getElementText(driver, LoginPageUI.EMAIL_LOGIN_ERR);
	}

	public void inputPassword(String textValue) {
		
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, textValue);
	}
	
	
}
