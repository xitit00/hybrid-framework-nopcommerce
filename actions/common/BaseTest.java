package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	//các hàm dùng cho tầng testcases , vd : User_01_
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driverBaseTest;
	
	public WebDriver getBrowserDriver(String browserName) {
		
		switch (browserName) {
		
		case "firefox":
			
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		
		break;
		
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
			
		break;
		
		case "edge":
			
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
			
		break;
		
		case "h_firefox":
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
		
		break;
	
		case "h_chrome":
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("-headless");
			options1.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options1);
			
		break;
		
		// trừ đi 5,6 version chrome driver sẽ ra đc version cốc cốc
		case "coccoc":
			
			// truyền version vào là sẽ tải đc version như mong muốn để run Cốc cốc , vd : 91.0.4472.101
			WebDriverManager.chromedriver().driverVersion("").setup();
			ChromeOptions options2 = new ChromeOptions();
			options2.setBinary("/Applications/Cốc Cốc.app");
			driverBaseTest = new ChromeDriver(options2);
			
		break;
		
		// ko ổn định 
		case "safari":
			
			driverBaseTest = new SafariDriver();
			driverBaseTest.manage().window().maximize();
		
		break;
		
		// opera kéo driver vào đổi từ text edit -> .exe 
		case "opera":
			
			WebDriverManager.operadriver().setup();
			driverBaseTest = new OperaDriver();
		
		break;
		
		// ko ổn định , ít dùng , dùng trên window và từ window 11 đã khai tử bỏ 
		case "ie":
			
			WebDriverManager.iedriver().arch32();
			driverBaseTest = new InternetExplorerDriver();	
		break;

		default:
			
			new RuntimeException("Browser name invalid");
			break;
		}
		
		return driverBaseTest;
	}
	
	
}
