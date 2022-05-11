package javaOOP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Topic_05_Super extends BaseOOP {
	
	private WebDriver driver;
	private long longTimeout;
	private long shortTimeout;
	
	public Topic_05_Super() {
		
		// Super luôn luôn gọi qua constructor class cha , dù cho có gọi ra hay ko , nếu mặc định thì ko cần gọi ra cũng đc 
//		super();
		// Nếu constructor class cha có nhiều hàm khởi tạo thì lúc đó mình nên xài super().constructor method để gọi ra cái cần xài
		
//		super(1);
		super("abc");
		System.out.println("\n Constructor class Con");
		
	}
	
	public void setImplicitWait() {
		
		long shortTimeout = 15;
		
		// shortTimeout parent 
		driver.manage().timeouts().implicitlyWait(super.shortTimeout, TimeUnit.SECONDS);
		
		// shortTimeout global 
		driver.manage().timeouts().implicitlyWait(this.shortTimeout, TimeUnit.SECONDS);
		
		// shortTimeout local
		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);
		
	}
	
	public void clickToElement() {
		
		// method from parent
		super.setImplicitWait();
		
		// method from local
		setImplicitWait();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stud
		
		Topic_05_Super t = new Topic_05_Super();
	}

}
