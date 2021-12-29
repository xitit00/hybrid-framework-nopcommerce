package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {

	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		
		
		this.driver = driver;
	}

	public void clickToGender() {
		
		waitForElementClickable(driver,MyAccountPageUI.GENDER_RADIO_BUTTON);
		clickToElement(driver, MyAccountPageUI.GENDER_RADIO_BUTTON);
		
	}

	public void inputLastName(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, textValue);
		
	}

	public void inputFirstName(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, textValue);
		
	}

	public void clickToDayOfBirth(String textValue) {
		
		waitForAllElementPresence(driver, MyAccountPageUI.BIRTHDAY_DROPDOWN);
		selectItemByValueInDefaultDropdown(driver, MyAccountPageUI.BIRTHDAY_DROPDOWN, textValue);
	}

	public void clickToMonthOfBirth(String textValue) {
		
		waitForAllElementPresence(driver, MyAccountPageUI.BIRTHMONTH_DROPDOWN);
		selectItemByValueInDefaultDropdown(driver, MyAccountPageUI.BIRTHMONTH_DROPDOWN, textValue);
		
	}

	public void clickToYearOfBirth(String textValue) {
		
		waitForAllElementPresence(driver, MyAccountPageUI.BIRTHYEAR_DROPDOWN);
		selectItemByValueInDefaultDropdown(driver, MyAccountPageUI.BIRTHYEAR_DROPDOWN, textValue);
		
	}

	public void inputEmail(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, textValue);
		
	}

	public void inputCompanyName(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_TEXTBOX, textValue);
	}

	public void clickToSaveInfoButton() {
		
		waitForElementClickable(driver,MyAccountPageUI.SAVE_INFO_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_INFO_BUTTON);
		
	}

	public boolean checkGenderSelected() {
	
		
		return isElementSelected(driver, MyAccountPageUI.GENDER_RADIO_BUTTON);
	}

	public String getValueTextFirstName() {
		
		return getElementAttribute(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getValueTextLastName() {
		
		return getElementAttribute(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getValueSelectedDayOfBirth() {
		
		return getSelectedItemDefaultDropdown(driver, MyAccountPageUI.BIRTHDAY_DROPDOWN);
	}

	public String getValueSelectedMonthOfBirth() {

		return getSelectedItemDefaultDropdown(driver, MyAccountPageUI.BIRTHMONTH_DROPDOWN);
	}

	public String getValueSelectedYearOfBirth() {
		
		return getSelectedItemDefaultDropdown(driver, MyAccountPageUI.BIRTHYEAR_DROPDOWN);
	}

	public String getValueTextEmail() {
		
		return getElementAttribute(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getValueTextCompanyName() {
		
		
		return getElementAttribute(driver, MyAccountPageUI.COMPANY_TEXTBOX, "value");
	}

	public void clickToAddressLink() {
		
		waitForElementClickable(driver,MyAccountPageUI.ADDRESSES_LINK);
		clickToElement(driver, MyAccountPageUI.ADDRESSES_LINK);
	}

	public void clickToAddNewBtn() {
		
		waitForElementClickable(driver,MyAccountPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADD_NEW_BUTTON);
		
	}

	public void inputAddressFirstName(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX, textValue);
	}

	public void inputAddressLastName(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX, textValue);
		
	}

	public void inputAddressEmail(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, textValue);
		
	}

	public void selectCountry(String textValue) {
		
		waitForAllElementPresence(driver, MyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemByTextInDefaultDropdown(driver, MyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN, textValue);
		
	}

	public void inputAddressCity(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_CITY_TEXTBOX, textValue);
		
	}

	public void inputAddress1(String textValue) {
	
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_1_TEXTBOX, textValue);
		
	}

	public void inputZipCode(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_ZIPCODE_TEXTBOX, textValue);
		
	}

	public void inputAddressPhoneNumber(String textValue) {
	
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_PHONE_TEXTBOX, textValue);
		
	}

	public void clickToSaveAddressButton() {
		
		waitForElementClickable(driver,MyAccountPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);
		
	}

	public String getTextAddressName() {
		
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_NAME);
		return getElementText(driver, MyAccountPageUI.ADDRESS_NAME);
	}

	public String getTextAddressEmail() {
	
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_EMAIL);
		return getElementText(driver, MyAccountPageUI.ADDRESS_EMAIL);
	}

	public String getTextAddressPhone() {
		
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_PHONE);
		return getElementText(driver, MyAccountPageUI.ADDRESS_PHONE);
	}

	public String getTextAddress1() {
		
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_1);
		return getElementText(driver, MyAccountPageUI.ADDRESS_1);
	}

	public String getTextAddressCountry() {
		
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_COUNTRY);
		return getElementText(driver, MyAccountPageUI.ADDRESS_COUNTRY);
	}

	public String getTextAddressCityAndZipCode() {
		
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_CITY_ZIP);
		return getElementText(driver, MyAccountPageUI.ADDRESS_CITY_ZIP);
	}

	public void clickToChangePasswordLink() {
		
		waitForElementClickable(driver,MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
	}

	public void inputOldPassword(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX, textValue);
		
	}

	public void inputNewPassword(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, textValue);
		
	}

	public void inputConfirmPassword(String textValue) {
		
		sendkeyToElement(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, textValue);
	}

	public void clickToChangePasswordButton() {
		
		waitForElementClickable(driver,MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		
	}

	public boolean checkPasswordChangedDisplay() {
		
		waitForElementVisible(driver, MyAccountPageUI.CHANGED_PASSWORD_SUCCESSFULL_MESSAGE);
		return isElementDisplayed(driver, MyAccountPageUI.CHANGED_PASSWORD_SUCCESSFULL_MESSAGE);
	}

	public void clickToCloseNotification() {
		
		waitForElementClickable(driver,MyAccountPageUI.CHANGED_PASSWORD_CLOSE_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGED_PASSWORD_CLOSE_BUTTON);
		
	}

	public void clickToMyProductReviewsLink() {
		
		waitForElementClickable(driver,MyAccountPageUI.MY_PRODUCT_REVIEWS_LINK);
		clickToElement(driver, MyAccountPageUI.MY_PRODUCT_REVIEWS_LINK);
		
	}


	
}
