package javaBasic;

public class Topic_01_Variable {
	
	public Topic_01_Variable() {
		
		
	}
	
	static int studentNumber;
	int studentPrice;
	// nếu cùng khai báo static final thì java nó sẽ xem như là 1 hằng số , nhớ viết hoa tên biến 
	static final String BROWSER_NAME = "Chrome"; //constant
	String studentName = "anhBTC";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(studentNumber);
		
		System.out.println(Topic_01_Variable.studentNumber);
		
		// change var studentName to static to implement in static method
		//System.out.println(studentName);
		
		// new class which include not static variable to implement in static method 
		Topic_01_Variable topic = new Topic_01_Variable();
		System.out.println(topic.studentName);

	}
	
	// Getter: getCurrentUrl/ getTitle/ getText/ getAttribute/ getCssValue/ getSize/ getLocation/ getPosition / ...
	public String getStudentName() {
		
		return this.studentName;
	}
	
	// Setter: click/ sendkey/ clear / select/ back/ forward/ refresh/ get/...
	public void setStudentName(String stdName) {
		
		this.studentName = stdName;
	}

}
