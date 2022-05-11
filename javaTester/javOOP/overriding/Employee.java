package javOOP.overriding;

import javaOOP.Testing;

public class Employee extends Person implements IWork {

	@Override
	//Option
	public void eat() {
		
		System.out.println("An com 25k");
	}

	@Override
	//Requirement
	public void sleep() {
		// TODO Auto-generated method stub
		
		System.out.print("Ngu 8tieng / 1 ngay");
	}

	@Override
	public void workingTime() {
		// TODO Auto-generated method stub
		
		System.out.println("Choi game 10 tieng / 1ngay");
	}
	
	
}
