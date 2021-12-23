package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	//các hàm dùng cho tầng testcases , vd : User_01_
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driverBaseTest;
	
	public WebDriver getBrowserDriver(String browserName) {
		
		switch (browserName) {
		
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driverBaseTest = new FirefoxDriver();
		
		break;
		
		case "chrome":
			
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			driverBaseTest = new ChromeDriver();
			
		break;
		
		case "edge":
			
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			driverBaseTest = new EdgeDriver();
			
		break;
		
		

		default:
			
			new RuntimeException("Browser name invalid");
			break;
		}
		
		return driverBaseTest;
	}
	
	
}
