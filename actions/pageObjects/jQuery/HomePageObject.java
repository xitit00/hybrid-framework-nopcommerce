package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void openPagingByPageNumber(String pageNumber) {
		
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public boolean isPageNumberActived(String pageNumber) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public List<String> getValueEachRowAtAllPage() {
		// TODO Auto-generated method stub
		
		// Lấy ra toàn bộ trang
		int totalSize = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		
		List<String> allRowValuesAllPage = new ArrayList<String>();
		
		// Duyệt qua toàn bộ trang
		for (int i = 1; i <= totalSize; i++) {
			
			// click vào từng trang
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(i));
			sleepInSecond(1);
			
			List<WebElement> allRowValueEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE_COUNTRY);
			
			// Duyệt qua tất cả row của mỗi page
			for (WebElement eachRow : allRowValueEachPage) {
				
				// get text của tất cả row và add vào ArrayList
				allRowValuesAllPage.add(eachRow.getText());
				
				// lấy index của each Row ra
//				int index = allRowValueEachPage.indexOf(eachRow);
				
				// so sánh chỉ add LAST INDEX của mỗi page
//				if (index == allRowValueEachPage.size() - 1) {
//					
//					allRowValuesAllPage.add(eachRow.getText());
//				}
				
				// so sánh chỉ add FIRST INDEX của mỗi page
//				if (index == 0) {
//					
//					allRowValuesAllPage.add(eachRow.getText());
//				}
				
			}
			
		}
		
	
		
		for (String value : allRowValuesAllPage) {
			
			
//			System.out.println("-----");
			System.out.println(value);
		
		}
		
		return allRowValuesAllPage;
		
	}
	
	public void sleepInSecond(long timeoutInSec){

		try {

			Thread.sleep(timeoutInSec * 1000);

		}catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	
}
