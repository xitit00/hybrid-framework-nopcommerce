package javaOOP.knowledge;

public class Topic_03_Method {
	
	// Non static method
	public void display() {
		
		System.out.println("Automation pro FC");
	}

	// Static method
	public static void showABC() {
		
		System.out.println("ABC pro FC");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Non static method buộc mình phải khởi tạo object , rồi mới gọi hàm
		Topic_03_Method t = new Topic_03_Method();
		t.display();
		
		//Static method thông qua class gọi 
		Topic_03_Method.showABC();
	}

}
