package javaOOP.knowledge;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Static 
		// Truy cập trực tiếp từ tên Class 
		// Ko cần phải tạo instance / object 
		// Ko nên lạm dụng tạo các biến là static
//		Topic_04_Non_Access_Modifier.sendkeyToElement("Safari");
//		System.out.println(Topic_04_Non_Access_Modifier.browserName);
		
		//Final class
//		Topic_04_Non_Access_Modifier t = new Topic_04_Non_Access_Modifier();
//		t.serverName = "ABC";
//		t.sendkeyToElement("DEF");
		
		// Topic_06_Getter_Setter
		Topic_06_Getter_Setter t06 = new Topic_06_Getter_Setter();
		t06.setPersonName("A");
		System.out.println(t06.getPersonName());
		t06.setPersonName("ABC");
		System.out.println(t06.getPersonName());
		t06.setPersonName(null);
		System.out.println(t06.getPersonName());
		t06.setPersonName("");
		System.out.println(t06.getPersonName());
		t06.setPersonAge(10);
		System.out.println(t06.getPersonAge());
		t06.setPersonBankAccountAmount(50000);
		System.out.println(t06.getPersonBankAccountAmount());
		t06.setPersonPhone(123);
		System.out.println(t06.getPersonPhone());
		
		
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
