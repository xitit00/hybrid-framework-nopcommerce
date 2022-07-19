package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	//các hàm dùng cho tầng testcases , vd : User_01_
	private String projectPath = System.getProperty("user.dir");
	// thay vì dùng 
	//System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver");
	//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver");
	//System.setProperty("webdriver.msedge.driver", projectPath + "/browserDriver/msedgedriver");
	// => dùng webdrivermanager thay thế 
	private WebDriver driverBaseTest;
	
	//Multiple browser
//	protected WebDriver getBrowserDriver(String browserName, String environment) {
//		
//		
//		switch (browserName) {
//		
//		case "firefox":
//			
//			WebDriverManager.firefoxdriver().setup();
//			driverBaseTest = new FirefoxDriver();
//		
//		break;
//		
//		case "chrome":
//			
//			WebDriverManager.chromedriver().setup();
//			driverBaseTest = new ChromeDriver();
//			
//		break;
//		
//		case "edge":
//			
//			WebDriverManager.edgedriver().setup();
//			driverBaseTest = new EdgeDriver();
//			
//		break;
//		
//		case "h_firefox":
//			
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1920x1080");
//			driverBaseTest = new FirefoxDriver(options);
//		
//		break;
//	
//		case "h_chrome":
//			
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options1 = new ChromeOptions();
//			options1.addArguments("-headless");
//			options1.addArguments("window-size=1920x1080");
//			driverBaseTest = new ChromeDriver(options1);
//			
//		break;
//		
//		// trừ đi 5,6 version chrome driver sẽ ra đc version cốc cốc
//		case "coccoc":
//			
//			// truyền version vào là sẽ tải đc version như mong muốn để run Cốc cốc , vd : 91.0.4472.101
//			WebDriverManager.chromedriver().driverVersion("").setup();
//			ChromeOptions options2 = new ChromeOptions();
//			options2.setBinary("/Applications/Cốc Cốc.app");
//			driverBaseTest = new ChromeDriver(options2);
//			
//		break;
//		
//		// ko ổn định 
//		case "safari":
//			
//			driverBaseTest = new SafariDriver();
//			driverBaseTest.manage().window().maximize();
//		
//		break;
//		
//		// opera kéo driver vào đổi từ text edit -> .exe 
//		case "opera":
//			
//			WebDriverManager.operadriver().setup();
//			driverBaseTest = new OperaDriver();
//		
//		break;
//		
//		// ko ổn định , ít dùng , dùng trên window và từ window 11 đã khai tử bỏ 
//		case "ie":
//			
//			WebDriverManager.iedriver().arch32();
//			driverBaseTest = new InternetExplorerDriver();	
//		break;
//
//		default:
//			
//			new RuntimeException("Browser name invalid");
//			break;
//		}
//		
//		// Set timeout tim element
//		driverBaseTest.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		
//		// open URL 
//		
//		driverBaseTest.get(getEnvironmentUrl(environment));
//		
//		return driverBaseTest;
//	}
	
	// GlobalConstants
//	private String getEnvironmentUrl(String environment) {
//		
//		String url = "";
//		
//		switch (environment) {
//		case "DEV":
//			
//			url = GlobalConstants.DEV_PORTAL_PAGE_URL;
//			break;
//			
//		case "STG":
//			
//			url = GlobalConstants.STG_PORTAL_PAGE_URL;
//			break;
//		
//		case "TEST":
//			
//			url = GlobalConstants.TEST_PORTAL_PAGE_URL;
//			break;
//			
//		case "PRO":
//			
//			url = GlobalConstants.PRO_PORTAL_PAGE_URL;
//			break;
//
//		default:
//			break;
//		}
//		
//		return url;
//	}
	
	//Enum 
	protected WebDriver getBrowserDriver(String browserName, String environmentName) {
		
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		switch (browserList) {
		
		case FIREFOX:
			
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		
		break;
		
		case CHROME:
			
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
			
		break;
		
		case EDGE:
			
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
			
		break;
		
		case H_FIREFOX:
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
		
		break;
	
		case H_CHROME:
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("-headless");
			options1.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options1);
			
		break;
		
		// trừ đi 5,6 version chrome driver sẽ ra đc version cốc cốc
		case COCCOC:
			
			// truyền version vào là sẽ tải đc version như mong muốn để run Cốc cốc , vd : 91.0.4472.101
			WebDriverManager.chromedriver().driverVersion("").setup();
			ChromeOptions options2 = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Mac")) {
				
				//MAC
				options2.setBinary("/Applications/Cốc Cốc.app");
			}
			else {
				
				//Windows
				options2.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			}
			driverBaseTest = new ChromeDriver(options2);
			
		break;
		
		// ko ổn định 
		case SAFARI:
			
			driverBaseTest = new SafariDriver();
			
		
		break;
		
		// opera kéo driver vào đổi từ text edit -> .exe 
		case OPERA:
			
			WebDriverManager.operadriver().setup();
			driverBaseTest = new OperaDriver();
		
		break;
		
		// ko ổn định , ít dùng , dùng trên window và từ window 11 đã khai tử bỏ 
		case IE:
			
			WebDriverManager.iedriver().arch32();
			driverBaseTest = new InternetExplorerDriver();	
		break;

		default:
			
			throw new RuntimeException("Browser name invalid");
			
		}
		
		// Set timeout tim element 
		// Mình chỉ cần set implicit wait 1 lần để sét time out cho tất cả element trong class TC.
		driverBaseTest.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// open URL 
		driverBaseTest.get(getEnvironmentUrl(environmentName));
		
		driverBaseTest.manage().window().setSize(new Dimension(414, 896));
		
		return driverBaseTest;
	}
	
	//Enum 
	private String getEnvironmentUrl(String environment) {
		
		String url = "";
		
		EnvironmentList enList = EnvironmentList.valueOf(environment);
		if (enList == EnvironmentList.DEV) {
			
			url = GlobalConstants.DEV_PORTAL_PAGE_URL;
		}
		else if (enList == EnvironmentList.STG) {
			
			url = GlobalConstants.STG_PORTAL_PAGE_URL;
		}
		else if (enList == EnvironmentList.TESTING) {
			
			url = GlobalConstants.TEST_PORTAL_PAGE_URL;
		}
		else {
			
			url = GlobalConstants.PRO_PORTAL_PAGE_URL;
		}
		
		return url;
	}
	
	// Ở bài Level_10_Jquery_DataTable , mình sẽ tạm thời bỏ qua phần environment ( STG , DEV, .. sẽ học ở Multiple Enviroment sau ) 
	// => tạo 1 cái getBrowserDriver mới chỉ chứa browserName , appURL
	
	protected WebDriver getBrowserDriverOnlyOneUrl(String browserName, String appUrl) {

		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {

		case FIREFOX:

			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();

			break;

		case CHROME:

			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();

			break;

		case EDGE:

			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

			break;

		case H_FIREFOX:

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);

			break;

		case H_CHROME:

			WebDriverManager.chromedriver().setup();
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("-headless");
			options1.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options1);

			break;

			// trừ đi 5,6 version chrome driver sẽ ra đc version cốc cốc
		case COCCOC:

			// truyền version vào là sẽ tải đc version như mong muốn để run Cốc cốc , vd : 91.0.4472.101
			WebDriverManager.chromedriver().driverVersion("").setup();
			ChromeOptions options2 = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Mac")) {

				//MAC
				options2.setBinary("/Applications/Cốc Cốc.app");
			}
			else {

				//Windows
				options2.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			}
			driverBaseTest = new ChromeDriver(options2);

			break;

			// ko ổn định 
		case SAFARI:

			driverBaseTest = new SafariDriver();


			break;

			// opera kéo driver vào đổi từ text edit -> .exe 
		case OPERA:

			WebDriverManager.operadriver().setup();
			driverBaseTest = new OperaDriver();

			break;

			// ko ổn định , ít dùng , dùng trên window và từ window 11 đã khai tử bỏ 
		case IE:

			WebDriverManager.iedriver().arch32();
			driverBaseTest = new InternetExplorerDriver();	
			break;

		default:

			throw new RuntimeException("Browser name invalid");
			
		}

		// Set timeout tim element
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);

		// open URL 
		driverBaseTest.get(appUrl);

		
		driverBaseTest.manage().window().maximize();

		return driverBaseTest;
	}
	
	protected int generateFakeNumber() {
		
		Random random = new Random();
		return random.nextInt(99999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {

			Assert.assertFalse(condition);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			
			System.out.println(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
}
