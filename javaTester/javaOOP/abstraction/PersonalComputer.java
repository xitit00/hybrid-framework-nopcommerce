package javaOOP.abstraction;

public class PersonalComputer extends Computer {

	// do bản chất của abstract method , abstract class cứ kế thừa là phải implement lại
	@Override
	public void setRam() {
		// TODO Auto-generated method stub
		
	}

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
	
	// có thể ko có 1 abstract method bên trong 1 abstract class 
	// nhưng mà ko thể có 1 abstract method bên trong 1 normal class
	
//	public abstract void abc() {
//		
//		
//	}

	
}
