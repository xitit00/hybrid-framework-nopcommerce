package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	
	// Kiểu nguyên thuỷ
	
	byte bNumber = 6;
	
	short sNumber = 1500;
	
	int iNumber = 65000;
	
	float fNumber = 15.98f;
	
	double dNumber = 15.98d;
	
	char cChar = '1';
	
	boolean bStatus = false;
	
	// Kiểu tham chiếu 
	
	// String 
	static String address = "anh BTC";
	
	//Array
	static String[] stdAddress = {address, "Ha Noi", "DN"};
	static int[] stdNumber = {15 , 20, 50};
	
	//Class
	static Topic_02_Data_Type topic;
	
	//Interface
	WebDriver driver;
	
	//Object
	Object object;
	
	//Collection
	// List/Set/...
	List<WebElement> homepageLinks = driver.findElements(By.tagName("abc"));
	Set<String> allWindows = driver.getWindowHandles();
	List<String> productName = new ArrayList<String>();
	
	public void clickToElement() {
		
		address.trim();
		stdAddress.clone();
		driver.getCurrentUrl();
		object.toString();
		homepageLinks.size();
		allWindows.clear();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}
