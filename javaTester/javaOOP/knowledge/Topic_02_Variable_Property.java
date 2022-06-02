package javaOOP.knowledge;

public class Topic_02_Variable_Property {
	
	// Biến gồm : Access Modifer + Data Type + Variable name + Variable value 
	private String studentName = "Automation FC";
	
	// Instance variable: nếu khai báo như là global và ko gán dữ liệu cho nó thì nó sẽ tự có giá trị mặc định 
	// = 0
	int studentNumber;
	// = null 
	String studentCountry;
	// = false
	boolean studentStatus;
	
	// Static variable : dùng và gán lại đc 
	public static String studentAddress = "HCM";
	
	// Dùng trong phạm vi Class này (cho tất cả instance/ object dùng)
	private static String studentPhone = "0123456789";
	
	// Final variable: Ko cho phép gán lại/ko override lại 
	// Cố định dữ liệu ko đc phép thay đổi trong quá trình chạy 
	final String country = "VN";
	
	// Static final variable: hẳng số (Constant)
	// Nó ko đc ghi đè 
	// Có thể truy cập rộng rãi cho tất cả các instance/ thread 
	// viết hoa tên biến lên , phân cách bởi _
	static final float PI_NUMBER = 3.1423544f;
	
	//Access modifer: default 
	int studentID = 100;
	
	//Method - static 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Local variable - biến cục bộ : hàm 
		String studentName = "Automation FC";
		
		if (studentName.startsWith("Automation")) {
			
			//Local variable - biến cục bộ : block code 
			int number = 100;
		}
		
		// biến local khi đã khai báo trong thân hàm thì buộc phải có gía trị , nếu ko sẽ báo lỗi
		int studentNumber;
		String studentCountry;
		boolean studentStatus;
		
		//may not have been initialized
//		System.out.println(studentNumber);
//		System.out.println(studentCountry);
//		System.out.println(studentStatus);
		
	}
	
	// Method - non static 
	public void display() {
		
		//Local variable - biến cục bộ: hàm 
		String a = "ABC";
	}
	
	// Method - Constructor
	public Topic_02_Variable_Property() {
		
		// Nếu như 1 class mà có biến cục bộ và toàn cục khai báo trùng tên thì phân biệt qua this.student Name - global variable 
		
		String studentName = "Automation Fc";
		
		if (this.studentName.startsWith("Automation")) {
			
			
		}
	}

	// Method - Constructor - params
	public Topic_02_Variable_Property(String studentName, int studentID) {
		
		this.studentName = studentName;
		this.studentID = studentID;
	}
	
	


}
