package javaOOP.Inheritance;

public class Animal {
	
	// Constructor class Con sẽ gọi vào Constructor class Cha trc  
	// default Constructor class Cha tự động đc gọi nếu như ko chỉ định rõ bởi class Con 
	
	public Animal() {
		
		System.out.println("Parent's contructor");
	}
	
	public Animal(String name) {
		
		System.out.println("Parent's contructor " + name);
	}
	
	public Animal(String name,String age) {
		
		System.out.println("Parent's contructor " + name + " " + age);
	}
	
	protected void eat() {
		
		System.out.println("Eating...");
	}
}
