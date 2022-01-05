package javaOOP;

public abstract class Computer {
	
	// Normal Method
	public void showComputerPerformance() {
		
		System.out.println("Show Computer Performance");
		
	}
	
	// Abstract Method
	// Phần thân để cho các Class con kế thừa nó phải override lại (implement) lại 
	public abstract void showComputerRam();

}
