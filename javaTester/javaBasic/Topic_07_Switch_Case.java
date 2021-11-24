package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	Scanner scan = new Scanner(System.in);

	//@Parameters("browser")
	//@Test
	public void TC_01(String browserName) {
		
		driver = getBrowserName(browserName);
		
		System.out.println(browserName);
		System.out.println(driver.toString());

		driver.quit();
	}
	
	//@Test
	public void TC_02() {

		int month = scan.nextInt();
		
		switch (month) {
		
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			
		System.out.println("Thang co 31 ngay");
			
		break;
		
		case 2:
			
		System.out.println("Thang co 28 ngay");
			
		break;
		
		case 4:
		case 6:
		case 9:
		case 11:
			
		System.out.println("Thang co 30 ngay");
				
		break;

		default:
			
		System.out.println("Vui long nhap lai!");
			
		break;
		}

	}
	
	//@Test
	public void TC_03() {

		int num = scan.nextInt();
		
		switch (num) {
		
		case 1:
			
		System.out.println("One");
			
		break; 
		
		case 2:
			
			System.out.println("Two");
				
			break; 
			
		case 3:
			
			System.out.println("Three");
				
			break; 
			
		case 4:
			
			System.out.println("Four");
				
			break; 
			
		case 5:
			
			System.out.println("Five");
				
			break; 
			
		case 6:
			
			System.out.println("Six");
				
			break; 
			
		case 7:
			
			System.out.println("Seven");
				
			break; 
			
		case 8:
			
			System.out.println("Eight");
				
			break; 
			
		case 9:
			
			System.out.println("Nine");
				
			break; 
		case 10:
			
			System.out.println("Ten");
				
			break; 


		default:
			
		System.out.println("Vui long nhap lai tu 1 -> 10");
			
		break;
		}

	}
	
	@Test
	public void TC_04() {

		int a = 10;
		int b = 5;
		String math = scan.nextLine();
		
		switch (math) {
		
		case "+":
		
		int c = a + b;
		System.out.println(c);
			
		break; 
		
		case "-":
			
			
		int d = a - b;
		System.out.println(d);
				
		break; 
			
		case "*":
			
			
			int e = a * b;
			System.out.println(e);
				
			break; 
			
		case "/":
			
			float f = a / b;
			System.out.println(f);
				
			break; 
			
		case "%":
		
			int j = a % b;
			System.out.println(j);
				
			break;  

		default:
			
		System.out.println("Vui long nhap lai phep toan");
			
		break;
		}

	}
	
	
	public WebDriver getBrowserName(String browserName) {
		
		switch (browserName) {
		case "chrome":
		
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			driver = new ChromeDriver();
				
			
		break;
		
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
				
			
		break;
		
		case "edge":
			
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			driver = new EdgeDriver();
				
		break;

		default:
			
			new RuntimeException("Please input correct the browser name!");
			
		break;
		}
		
		return driver;
	}

}
