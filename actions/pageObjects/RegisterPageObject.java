package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	
	private WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void inputFirstName(String textValue) {
		
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, textValue);
	}
	
	public void inputLastName(String textValue) {
		
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, textValue);
	}
	
	public void inputEmail(String textValue) {
		
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, textValue);
	}
	
	public void inputPassword(String textValue) {
		
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, textValue);
	}
	
	public void inputConfirmPassword(String textValue) {
		
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD, textValue);
	}
	
	public void clickToRegisterButton() {
		
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public void clickToLogout() {
		
		waitForElementClickable(driver,RegisterPageUI.LOG_OUT);
		clickToElement(driver, RegisterPageUI.LOG_OUT);
	}
	
	public String getTextFirstNameErr() {
		
		return getElementText(driver, RegisterPageUI.FIST_NAME_ERR_MESSAGE);
	}

	public String getTextLastNameErr() {

		return getElementText(driver, RegisterPageUI.LAST_NAME_ERR_MESSAGE);
	}

	public String getTextEmailErr() {

		return getElementText(driver, RegisterPageUI.EMAIL_ADDRESS_ERR_MESSAGE);
	}

	public String getTextPasswordErr() {

		return getElementText(driver, RegisterPageUI.PASSWORD_ERR_MESSAGE);
	}

	public String getTextConfirmPasswordErr() {

		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERR_MESSAGE);
	}
	
	
	public String getTextRegisterSuccessMess() {
		
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
	public String getTextExistingsEmailErr() {
		
		return getElementText(driver, RegisterPageUI.EXISTINGS_EMAIL_ERR_MESSAGE);
	}

	public void clickToTheMoon() {
		// TODO Auto-generated method stub
		
	}
}
