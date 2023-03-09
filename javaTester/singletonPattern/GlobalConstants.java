package singletonPattern;

import java.util.Random;

public class GlobalConstants {
	
	// Private static variable
	
	private static GlobalConstants globalInstance;
	private int number;
	
	// Private constructor
	private GlobalConstants(int number){
		
		this.number = number;
		System.out.println("Demo singleton = " + number);
		
	}

	// Public static method
	public synchronized static GlobalConstants getBloGlobalConstants() {
		
		if (globalInstance == null) {
			
			globalInstance = new GlobalConstants(new Random().nextInt(999));
			
			System.out.println("New instance");
		}
		else {
			
			System.out.println("Existing instance");
		}
		
		return globalInstance;
		
		
	}
}
