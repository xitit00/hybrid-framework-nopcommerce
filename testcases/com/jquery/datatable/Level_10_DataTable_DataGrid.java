package com.jquery.datatable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;



public class Level_10_DataTable_DataGrid extends BaseTest {
	
	private WebDriver driver;
	private HomePageObject homePageObject;
	List<String> actualAllCountryValueAllPage;
	List<String> expectedAllCountryValueAllPage = new ArrayList<String>();
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {

		driver = getBrowserDriverOnlyOneUrl(browserName, appurl);
	
		homePageObject = PageGeneratorManager.getHomePageObject(driver);
	}
	
	//@Test
	public void Table_01_Paging() {
		
		// case này dùng để phân trang , nếu như trong TH có data table 
		// click vào các số trang mong muốn , sleep vài giây để load trang ( Action )
		// check page number hiện tại đã click là actived , dựa vào thay đổi element để ( verify )
		
		homePageObject.openPagingByPageNumber("10");
		Assert.assertTrue(homePageObject.isPageNumberActived("10"));
		sleepInSecond(3);
		
		homePageObject.openPagingByPageNumber("20");
		Assert.assertTrue(homePageObject.isPageNumberActived("20"));
		sleepInSecond(3);
		
		homePageObject.openPagingByPageNumber("7");
		Assert.assertTrue(homePageObject.isPageNumberActived("7"));
		sleepInSecond(3);
		
	}
	
	//@Test
	public void Table_02_Enter_To_Header() {
		
		// sau khi chạy xong Table_01 action và verify việc phân trang 
		// ở Table_02 ta sẽ check việc search = cách input text and enter xem có hiệu quả ko nhé 
		
		homePageObject.refreshCurrentPage(driver);
		homePageObject.enterToHeaderTextboxByLabel("Country","Argentina");
		sleepInSecond(2);
	}
	
	@Test
	public void Table_03_Get_All_Row_Each_Page() {
		
		// Đọc dữ liệu file country.txt ra 
		// Lưu vào 1 list expectedAllCountryValueAllPage
		
		File file = new File("/Users/anhnguyen/Documents/Selenium/03-Hybrid Automation Framework/countryData/country.txt");
	
		try {
			var scan = new Scanner(file);
			while (scan.hasNextLine()) {
				expectedAllCountryValueAllPage.add(scan.nextLine());
			  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		actualAllCountryValueAllPage = homePageObject.getValueEachRowAtAllPage();
		System.out.print("Expected size : " + expectedAllCountryValueAllPage.size());
		System.out.print("Actual size : " + actualAllCountryValueAllPage.size());
		Assert.assertEquals(actualAllCountryValueAllPage, expectedAllCountryValueAllPage);
	}

	public void sleepInSecond(long timeoutInSec){
		
		try {
			
			Thread.sleep(timeoutInSec * 1000);
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
