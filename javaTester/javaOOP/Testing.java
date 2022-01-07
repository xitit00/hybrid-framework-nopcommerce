package javaOOP;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Static 
		// Truy cập trực tiếp từ tên Class 
		// Ko cần phải tạo instance / object 
		// Ko nên lạm dụng tạo các biến là static
		Topic_04_Non_Access_Modifier.sendkeyToElement("Safari");
		System.out.println(Topic_04_Non_Access_Modifier.browserName);
		
		//Final class
		Topic_04_Non_Access_Modifier t = new Topic_04_Non_Access_Modifier();
		t.serverName = "ABC";
		t.sendkeyToElement("DEF");
		
	}
	
	// khi mà mình override lại hàm class Cha thì class Con sẽ gọi hàm ở chính nó , chứ ko lấy hàm ở class Cha nữa vì đã override r.
	public void clickToElement(String elementName) {
		
		System.out.println(elementName);
	}
	
	// hàm final từ class Cha ko override đc ở class con nha
//	public void setCarName() {
//		
//		
//	}

}
