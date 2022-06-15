package javaOOP.abstraction;

// các lớp có thể cài đặt (implements) 1 hoặc nhiều interface ( đa kế thừa )
// Ko mang ra để sử dụng đc luôn 
// Buộc Phải viết lại mới dùng đc 
// Khác knowledge của kế thừa ( extends )
public class Dog implements IAnimal,ICity {

	// must implement abstract method from interface
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddress(String Address) {
		// TODO Auto-generated method stub
		
	}

	
}
