package common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class BasePage {
	
	
	// hàm constructor
	
	public static BasePage getBasePageObject() {
		
		BasePage b = new BasePage();
		return b;
	}

	// các hàm dùng chung để tương tác với pageObjects
	// common class
	// Thật ra có thể khởi tạo cái web driver bên ngoài để dùng trong các hàm bên dưới thông qua hàm constructor , nhưng ko nên 
	// vì class này là common class , những class khác dùng lại BasePage sẽ có nhiệm vụ truyền webdriver vào là sẽ dùng đc.
	// => Tham số WebDriver là bắt buộc 
	
	
	// Web Browser
	public void openPageUrl(WebDriver driver, String pageUrl) {
		
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		
		return driver.getCurrentUrl();
		
	}
	
	public String getPageSourceCode(WebDriver driver) {
		
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		
		driver.navigate().refresh();
	}
	
	//alert
	// wait alert is Presence to accept , dismiss , sendkey ...
	
	public Alert waitForAlertPresence(WebDriver driver) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		// return alert
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		
		waitForAlertPresence(driver).accept();
		
	}
	
	public void cancelAlert(WebDriver driver) {
		
		waitForAlertPresence(driver).dismiss();
		
	}
	
	public String getAlertText(WebDriver driver) {
		
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendKeyToAlert(WebDriver driver,String textValue) {
		
		waitForAlertPresence(driver).sendKeys(textValue);
		
	}
	
	//window , tab
	
	public void switchToWindowByID(WebDriver driver,String pageID) {

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		
		for (String window : allWindows) {

			if (!window.equals(pageID)) {

				driver.switchTo().window(window);
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver,String expectedPageTitle) {

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		
		for (String window : allWindows) {
			
			
			driver.switchTo().window(window);
		
			String actualTitle = driver.getTitle().trim();
			System.out.println(actualTitle);
			if (actualTitle.equals(expectedPageTitle)) {

				break;
			}
		}
	}
	
	public void closeAllTabWithoutParent(WebDriver driver,String parentPageID) {
		
	 	Set<String> allWindowsID = driver.getWindowHandles();
	 	
	 	for (String windowID : allWindowsID) {
			
	 		if (!windowID.equals(parentPageID)) {
	 			
	 			driver.switchTo().window(windowID);
	 			driver.close();
	 			
	 		}
		}
	 	
	 	driver.switchTo().window(parentPageID);
	}
	
	//Web Element
	
	private By getByXpath(String xpathLocator) {
		
		return By.xpath(xpathLocator);
	}
	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		
		return driver.findElement(getByXpath(xpathLocator));
	} 
	
	private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {
		
		getWebElement(driver, xpathLocator).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		
		// khai báo biến gán nếu như dùng nhiều lần , thay vì gọi lại getWebElement() clear rồi sendkey.
		WebElement element = getWebElement(driver, xpathLocator);
		
		element.clear();
		element.sendKeys(textValue);
		
	}
	
	// Default Dropdown
	
	public void selectItemByValueInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}
	
	public void selectItemByTextInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	
	// Custom Dropdown
	
	public void selectElementInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedElement) {

		//c1 
//		getWebElement(driver, parentXpath).click();
//		sleepInSecond(1);
		
		//c2
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(parentXpath))).click();

		List<WebElement> allElements = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		System.out.println("All Item is " + allElements.size());

		for (WebElement element : allElements) {

			System.out.println("Item text: " + element.getText());

			if (element.getText().trim().equals(expectedElement)) {

				if (element.isDisplayed()) {

					element.click();

				} else {

					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
					sleepInSecond(1);
					element.click();

				}

				break;

			}
		}
	}
	
	public void sleepInSecond(long timeoutInSec) {

		try {

			Thread.sleep(timeoutInSec * 1000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	public String getElementAttribute(WebDriver driver , String xpathLocator, String attributeName) {
		
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getElementText(WebDriver driver , String xpathLocator) {
		
		return getWebElement(driver, xpathLocator).getText();
	}
	
	public String getElementCssValue(WebDriver driver , String xpathLocator, String propertyName) {
		
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver , String xpathLocator) {
		
		return  getListWebElement(driver, xpathLocator).size();
	}
	
	// check , uncheck -> checkbox , radio checkbox
	
	public void checkToDefaultCheckboxRadio(WebDriver driver , String xpathLocator) {
		
		WebElement element = getWebElement(driver, xpathLocator);
		
		if (!element.isSelected()) {
			
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckboxRadio(WebDriver driver , String xpathLocator) {
		
		WebElement element = getWebElement(driver, xpathLocator);
		
		if (element.isSelected()) {
			
			element.click();
		}
	}
	
	// Displayed  , Enabled , Selected
	
	public boolean isElementDisplayed(WebDriver driver , String xpathLocator) {
		
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	public boolean isElementEnabled(WebDriver driver , String xpathLocator) {
		
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver , String xpathLocator) {
		
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	// Frame , Iframe
	
	public void switchToFrameIframe(WebDriver driver , String xpathLocator ) {
		
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		
		driver.switchTo().defaultContent();
	}
	
	// User action
	
	public void hoverMouseToElement(WebDriver driver , String xpathLocator ) {
		
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator));
	}
	
	//Upload đợi học trong phần Framework tiếp theo 
	
	//...
	
	//JsExecutor

	public void scrollToBottomPage(WebDriver driver) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void hightlightElement(WebDriver driver, String xpathLocator) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");

		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElementOnTop(WebDriver driver, String xpathLocator) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	public void scrollToElementOnDown(WebDriver driver, String xpathLocator) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}
	
	public boolean isPageLoadedSuccess(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {

				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active == 0);");

			}

		};

		return explicitWait.until(jQueryLoad);

	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		}
		return false;
	}
	
	// Explicit Wait
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
		
	}
	
	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
		
	}
	
	public void waitForElementInVisible(WebDriver driver, String xpathLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
		
	}
	
	public void waitForAllElementInVisible(WebDriver driver, String xpathLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElement(driver, xpathLocator)));
	
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
		
	}
	
	// ít dùng
	public void waitForElementPresence(WebDriver driver, String xpathLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(xpathLocator)));
		
	}
	
	public void waitForAllElementPresence(WebDriver driver, String xpathLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathLocator)));
		
	}
	
	// Switch Page UI
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		
		waitForElementClickable(driver, BasePageUI.ADDRESSES_LINK);
		clickToElement(driver, BasePageUI.ADDRESSES_LINK);
		
		UserAddressPageObject a = PageGeneratorManager.getUserAddressPage(driver);
		return a;
		
	}
	
	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		
		waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		
		UserRewardPointPageObject r = PageGeneratorManager.getUserRewardPointPage(driver);
		return r;
		
	}
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		
		UserMyProductReviewPageObject m = PageGeneratorManager.getUserMyProductReviewPage(driver);
		return m;
		
	}
	
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		
		UserHomePageObject u = PageGeneratorManager.getUserHomePage();
		u.setDriver(driver);
		return u;
	}
	

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		
		AdminLoginPageObject a = PageGeneratorManager.getAdminLoginPage(driver);
		return a;
	}
	
	// Học cho biết pageFactory
	// override method waitForElement , click  pageFactory
	
	public void waitForElementClickableByElement(WebDriver driver, WebElement element) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void clickToElementByElement(WebElement element) {
		
		// k cần findElement vì FindBy đã giúp mình findElement r.
		element.click();
	}
	
	public void waitForElementVisibleByElement(WebDriver driver, WebElement element) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public boolean isElementDisplayedByElement(WebElement element) {
		
		return element.isDisplayed();
	}
	
	
	public String getElementTextByElement(WebElement element) {
		
		return element.getText();
	}
	
	public void sendkeyToElementByElement(WebElement element, String textValue) {
		
		element.clear();
		element.sendKeys(textValue);
		
	}
	
}
