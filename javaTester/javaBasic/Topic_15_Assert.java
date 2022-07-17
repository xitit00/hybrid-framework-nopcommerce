package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(common.MethodListener.class)
public class Topic_15_Assert extends BaseTest {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
			
	@BeforeClass
	public void beforeClass() {
		
		System.out.println("Project path : " + projectPath);
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		
	}

	//@Test
	public void TC_01_ValidateCurrentUrl() {
		
//		// Login Page Url matching
//		System.out.println("Assert 01");
//		String loginPageUrl = driver.getCurrentUrl();
//		Assert.assertEquals(loginPageUrl, "https://demo.guru99.com/v4/");
//		
//		// Login Page title
//		System.out.println("Assert 02");
//		String loginPageTitle = driver.getTitle();
//		Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
//		
//		// Login form displayed
//		System.out.println("Assert 03");
//		Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
		
		// static method : có thể gọi trực tiếp từ tên class chỉ cần import static
		//vd : import static org.testng.Assert.assertEquals;

		System.out.println("Assert 01");
		String loginPageUrl = driver.getCurrentUrl();
		assertEquals(loginPageUrl, "https://demo.guru99.com/v4/");

		System.out.println("Assert 02");
		String loginPageTitle = driver.getTitle();
		assertEquals(loginPageTitle, "Guru99 Bank Home Page");

		System.out.println("Assert 03");
		assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
	}
	
	// Custom Hard Assertion
	
	@Test
	public void TC_02_Custom_Hard_Assertion() {
		
		System.out.println("Assert 01");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl, "http://demo.guru99.com/v4/");

		System.out.println("Assert 02");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "Guru99 Bank Home Page");

		System.out.println("Assert 03");
		verifyTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
		
		System.out.println("Assert 04");
		verifyTrue(driver.findElement(By.xpath("//label[@id='message23']")).isDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
