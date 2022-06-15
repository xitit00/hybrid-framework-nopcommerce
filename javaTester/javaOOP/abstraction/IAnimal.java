package javaOOP.abstraction;

public interface IAnimal {
	
	// biến trong interface mặc định là 1 hằng số , mặc dù có khai báo public static final hay ko 
	public static final int numm = 200;
	int num = 100;

	// Interfaces cannot have constructors
//	public IAnimal() {
//		
//		
//	}
	
	// ko có chỉ rõ abstract hay ko thì trong interface các method đều là abstract hết
	// và chỉ có trong mỗi interface thì các method sẽ dùng là public ( ko có private , default , protected ) , vì nó cần các lớp
	// ngoài implement để sử dụng 
	String getName();
	
	void setName(String name);
	
	abstract String getAddress();
	
	abstract void setAddress(String Address);
}
