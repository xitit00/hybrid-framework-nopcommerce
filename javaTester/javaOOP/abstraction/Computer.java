package javaOOP.abstraction;

public abstract class Computer implements IAnimal , ICity {

	// normal 
	public void showCPU() {
		
		System.out.println("Intel CPU");
	}
	
	// Abstract 
	public abstract void setRam();
	
	// interface thì only public 
	// nhưng abstract class thì nhiều access modifier đc 
//	protected abstract String abc ();
//	private void showGPU() {
//		
//		
//	}
//	void getGPU() {
//		
//		
//	}
	
}
