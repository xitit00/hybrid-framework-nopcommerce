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
	
	//Xpath Locator
//	private By getByXpath(String xpathLocator) {
//		
//		return By.xpath(xpathLocator);
//	}
	
	// Dynamic Locator
	// locator Type: id= , css= , xpath= , name= , class=
	// locator Type: ID= , CSS= , XPATH= , NAME= , CLASS=
	// locator Type: Id= , Css= , Xpath= , Name= , Class=
	private By getByLocator(String locatorType) {
		
		By byLocator = null;
		
		// buộc dùng startWith để chắc chắn ở những kí tự đầu ứng với locator bên trên
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			
			String strId = locatorType.substring(3);
			byLocator = By.id(strId);
			
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class")) {
			
			String strClass = locatorType.substring(6);
			byLocator = By.className(strClass);
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			
			String strName = locatorType.substring(5);
			byLocator = By.name(strName);
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			
			String strCss = locatorType.substring(4);
			byLocator = By.cssSelector(strCss);
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			
			String strXpath = locatorType.substring(6);
			byLocator = By.xpath(strXpath);
			
		} else {
			
			throw new RuntimeException("Locator type is not supported");
		}
		
		return byLocator;
	}
	
	// Dynamic_Xpath , Rest Parameters
	// Nếu như truyền vào locator type là xpath = đúng 
	// Truyền vào locator type # xpath = sai 
	private String getDynamicXpath(String locatorType, String... restValues) {
		
		System.out.println("Locator Type Before = " + locatorType);
		// check là xpath thì dùng rest params truyền vào , còn ko thì thôi bỏ qua
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			
			locatorType = String.format(locatorType, (Object[])restValues);
		}
		
		for (String value : restValues) {
		
			System.out.println("Values map to locator = " + value);
		}
		
		System.out.println("Locator Type After = " + locatorType);
		return locatorType;
	}
	
	private WebElement getWebElement(WebDriver driver, String locatorType) {
		
		return driver.findElement(getByLocator(locatorType));
	} 
	
	private List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		
		return driver.findElements(getByLocator(locatorType));
	}
	
	public void clickToElement(WebDriver driver, String locatorType) {
		
		getWebElement(driver, locatorType).click();
	}
	
	public void clickToElement(WebDriver driver, String locatorType, String... restValues) {
		
		locatorType = getDynamicXpath(locatorType, restValues);
		getWebElement(driver, locatorType).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		
		// khai báo biến gán nếu như dùng nhiều lần , thay vì gọi lại getWebElement() clear rồi sendkey.
		WebElement element = getWebElement(driver, locatorType);
		
		element.clear();
		element.sendKeys(textValue);
		
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue , String... restValues) {
		
		// khai báo biến gán nếu như dùng nhiều lần , thay vì gọi lại getWebElement() clear rồi sendkey.
		
		locatorType = getDynamicXpath(locatorType, restValues);
		
		WebElement element = getWebElement(driver, locatorType);
		
		element.clear();
		element.sendKeys(textValue);
		
	}
	
	// Default Dropdown
	// cấu trúc : select[@name='DateOfBirthMonth']
	public void selectItemByValueInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... restValues) {
		
		locatorType = getDynamicXpath(locatorType, restValues);
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textItem);
	}
	
	public void selectItemByTextInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... restValues) {
		
		locatorType = getDynamicXpath(locatorType, restValues);
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType,  String... restValues) {
		
		locatorType = getDynamicXpath(locatorType, restValues);
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String locatorType , String... restValues) {
		
		locatorType = getDynamicXpath(locatorType, restValues);
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}
	
	
	// Custom Dropdown
	// cấu trúc : div
	public void selectElementInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedElement) {

		//c1 
//		getWebElement(driver, parentXpath).click();
//		sleepInSecond(1);
		
		//c2
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(parentLocator))).click();

		List<WebElement> allElements = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
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
	
	// ít dùng
	public String getElementAttribute(WebDriver driver , String locatorType, String attributeName) {
		
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementText(WebDriver driver , String locatorType) {
		
		return getWebElement(driver, locatorType).getText();
	}
	
	public String getElementText(WebDriver driver , String locatorType, String... restValues) {
		
		return getWebElement(driver, getDynamicXpath(locatorType, restValues)).getText();
	}
	
	public String getElementCssValue(WebDriver driver , String locatorType, String propertyName) {
		
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver , String locatorType) {
		
		return  getListWebElement(driver, locatorType).size();
	}
	
	public int getElementSize(WebDriver driver , String locatorType, String... restValues) {
		
		locatorType = getDynamicXpath(locatorType, restValues);
		return  getListWebElement(driver, locatorType).size();
	}
	
	// check , uncheck -> checkbox , radio checkbox
	
	public void checkToDefaultCheckboxRadio(WebDriver driver , String locatorType) {
		
		WebElement element = getWebElement(driver, locatorType);
		
		if (!element.isSelected()) {
			
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckboxRadio(WebDriver driver , String locatorType) {
		
		WebElement element = getWebElement(driver, locatorType);
		
		if (element.isSelected()) {
			
			element.click();
		}
	}
	
	// Displayed  , Enabled , Selected
	
	public boolean isElementDisplayed(WebDriver driver , String locatorType) {
		
		return getWebElement(driver, locatorType).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver , String locatorType, String... restValues) {
		
		return getWebElement(driver, getDynamicXpath(locatorType, restValues)).isDisplayed();
	}
	
	public boolean isElementEnabled(WebDriver driver , String locatorType) {
		
		return getWebElement(driver, locatorType).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver , String locatorType) {
		
		return getWebElement(driver, locatorType).isSelected();
	}
	
	// Frame , Iframe
	
	public void switchToFrameIframe(WebDriver driver , String locatorType ) {
		
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		
		driver.switchTo().defaultContent();
	}
	
	// User action
	
	public void hoverMouseToElement(WebDriver driver , String locatorType ) {
		
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType));
	}
	
	//Upload đợi học trong phần Framework tiếp theo 
	
	//...
	
	//JsExecutor

	public void scrollToBottomPage(WebDriver driver) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void hightlightElement(WebDriver driver, String locatorType , String...restValues) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		locatorType = getDynamicXpath(locatorType, restValues);
		
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");

		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}
	
	public void clickToElementByJS(WebDriver driver, String locatorType, String...restValues) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		locatorType = getDynamicXpath(locatorType, restValues);
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElementOnTop(WebDriver driver, String locatorType) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void scrollToElementOnDown(WebDriver driver, String locatorType) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
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

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		}
		return false;
	}
	
	// Explicit Wait
	
	public void waitForElementVisible(WebDriver driver, String typeLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(typeLocator)));
		
	}
	
	public void waitForElementVisible(WebDriver driver, String typeLocator, String... restValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(typeLocator, restValues))));
		
	}
	
	public void waitForAllElementVisible(WebDriver driver, String typeLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(typeLocator)));
		
	}
	
	public void waitForAllElementVisible(WebDriver driver, String typeLocator, String... restValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(typeLocator, restValues))));
		
	}
	
	public void waitForElementInVisible(WebDriver driver, String typeLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(typeLocator)));
		
	}
	
	public void waitForElementInVisible(WebDriver driver, String typeLocator, String... restValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(typeLocator, restValues))));
		
	}
	
	public void waitForAllElementInVisible(WebDriver driver, String typeLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElement(driver, typeLocator)));
	
	}
	
	public void waitForAllElementInVisible(WebDriver driver, String typeLocator, String... restValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElement(driver, getDynamicXpath(typeLocator, restValues))));
	
	}
	
	public void waitForElementClickable(WebDriver driver, String typeLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(typeLocator)));
		
	}
	
	public void waitForElementClickable(WebDriver driver, String typeLocator, String... restValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(typeLocator, restValues))));
		
	}
	
	// ít dùng
	public void waitForElementPresence(WebDriver driver, String typeLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(typeLocator)));
		
	}
	
	public void waitForAllElementPresence(WebDriver driver, String typeLocator) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(typeLocator)));
		
	}
	
	// Tối ưu ở bài học Level_07_Switch_Page / Switch Page UI
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
	
	// Tối ưu ở bài học Level_09_Dynamic_Locator / Dynamic Xpath , gom tất cả hàm đã viết ở Level_07_Switch_Page lại thành 1 hàm
	// cách này dùng cho ít page: 10 - 20 pages
	public BasePage openPagesAtMyAccountByName(WebDriver driver, String areaName , String pageName) {
		
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, areaName, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, areaName, pageName);
		
		switch (pageName) {
		
		case "Addresses":
			
			return PageGeneratorManager.getUserAddressPage(driver);
			
		case "My product reviews":
			
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
			
		case "Reward points":

			return PageGeneratorManager.getUserRewardPointPage(driver);	

		default:
			
			throw new RuntimeException("Invalid page name at My Account area.");
			
		}
	}
	
	// cách này dùng cho nhiều page , vd : 15 - 20 page trở lên 
	public void openPagesAtMyAccountByPageName(WebDriver driver, String areaName , String pageName) {
		
		waitForElementClickable(driver,BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, areaName, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, areaName, pageName);
	}
	
	// Level_08_Switch_Role 
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
	
	//Level_05_Page_Factory
	// Học cho biết pageFactory , phỏng vấn có khả năng gặp
	// override method waitForElement , click , isDisplay , getText , sendkey ...
	
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
