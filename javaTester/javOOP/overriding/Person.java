package javOOP.overriding;

public abstract class Person {

	// Option
	public void eat() {
		
		System.out.print("An com 30k");
	}
	
	// Requirement 
	public abstract void sleep();
	
	// Nếu muốn method ko thể override thì thêm final 
	public final void walk() {
		
		System.out.println("Di bo");
	}
	
	// // Nếu muốn method ko thể override thì thêm static
	public static void run() {
		
		System.out.println("Chay bo");
	}

}
