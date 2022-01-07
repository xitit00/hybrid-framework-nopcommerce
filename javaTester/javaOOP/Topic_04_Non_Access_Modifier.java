package javaOOP;

public final class Topic_04_Non_Access_Modifier {
	
	// Static: Variable/ Method 
	// Dùng cho tất cả các instance / object 
	// Phạm vi cho toàn bộ system sử dụng nó
	// Có thể override đc
	static String browserName = "Chrome";
	
	// Non static
	String serverName = "Testing";
	
	// Hằng số 
	final String colorCar = "Red";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(browserName);
		
		browserName = "Firefox";
		System.out.println(browserName);
		
//		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
//		System.out.println(topic.serverName);
	}
	
	//Non static 
	public void clickToElement(String elementName) {
		
		System.out.println(elementName);
	}
	
	//Static 
	public static void sendkeyToElement(String elementName) {
		
		System.out.println(elementName);
	}

	//Final
	public final void setCarName() {
		
		
	}
} 
