package javOOP.overriding;

public class Student extends Person implements IWork {
	
	@Override
	//Option
	public void eat() {
		
		System.out.println("An com 20k");
	}

	@Override
	//Requirement from abstract class
	public void sleep() {
		// TODO Auto-generated method stub
		
		System.out.println("Ngu 12tieng/1ngay");
		
	}

	//Requirement from abstract method 
	@Override
	public void workingTime() {
		// TODO Auto-generated method stub
		
		System.out.println("Choi game 5 tieng / 1ngay");
	}

}
