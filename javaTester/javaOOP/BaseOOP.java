package javaOOP;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BaseOOP {

	public long shortTimeout = 15;
	protected long longTimeout = 45;
	private WebDriver driver;
	
	// Access modifier constructor : private thì Ngăn Chặn việc khởi tạo đối tượng 
	private BaseOOP() {
		
		System.out.print("Constructor class Cha");
		
	}
	
	// Access modifier constructor : protected thì Hạn Chế việc khởi tạo đối tượng 
	protected BaseOOP(String name) {
		
		System.out.print("Constructor class Cha: " + name);
		
	}
	
	public BaseOOP(int num) {
		
		System.out.print("Constructor class Cha: " + num);
		
	}
	
	public void setImplicitWait() {

		long shortTimeout = 15;

		// shortTimeout parent
		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);
		

	}
}
