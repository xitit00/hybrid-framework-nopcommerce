package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Topic_06_Condition_Statement {

	boolean status;
	String  strDriver = "Internet Explorer";
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	//@Test
	public void TC_01_If() {

		if (status == true) {

			// true
			System.out.println("Go to if ");
		}

		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		// Element luôn có trong DOM dù popup hiển thị hay ko

		WebElement salePopup = driver.findElement(By.id("abc"));
		if (salePopup.isDisplayed()) {

		}

		// Element ko có trong DOM khi popup ko hiển thị
		List<WebElement> salePopups = driver.findElements(By.id("abc"));

		// Check element ko hiển thị
		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {

		}

		// Uncheck to checkbox
		WebElement languagesCheckbox = driver.findElement(By.id("abc"));
		if (languagesCheckbox.isSelected()) {

			// selected -> deselected
			languagesCheckbox.click();
		}

		// check to checkbox
		if (!languagesCheckbox.isSelected()) {

			// deselected -> selected
			languagesCheckbox.click();
		}
	}

	//@Test
	public void TC_02_If_Else() {
		
		// Nếu driver startvs browser như Chrome/ Firefox / Edege / Safari thì dùng hàm click của Selenium WebElement
		// Nếu driver là IE thì dùng hàm click của JavascriptExecutor
		
		if (strDriver.toString().contains("Explorer")) {
			
			System.out.println("Go to IE");
		}
		else {
			
			System.out.println("Go to Chrome , Firefox , Edge");
		}
		
		
	}
	
	@Parameters("browser")
	@Test
	public void TC_03_If_Else_If_Else(String browserName) {

		// equalsIgnoreCase : ko phân biệt hoa , thường
		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			driver = new EdgeDriver();

		} else {
			
			// Safari / Opera / Coccoc ...
			
			throw new RuntimeException("Please input correct the browser name!");
		}
		
		System.out.println(browserName);
		System.out.println(driver.toString());

		driver.quit();
	}
	
	@Test
	public void TC_04_If_Else_Short_Way() {
		
		int a = 10;
		
		String b = (a > 10) ? "Right" : "Wrong";
		
		System.out.println(b);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
