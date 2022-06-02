package javaOOP.Inheritance;

public class Dog extends Animal implements Runnable {
	
	// encapsulation ( tính đóng gói ) 
	private int age;
	
	public void setAge(int age) {
		
		if (age > 0) {
			
			this.age = age;
		}
		else {
			
			this.age = 0;
		}
	}
	
	public int getAge() {
		
		return age;
	}

	// nếu như class Cha có nhiều constructor thì dùng super để định nghĩa constructor từ class Cha mà class Con cần phải gọi
	public Dog() {
		
		super("Lucky");
		System.out.print("Child's constructor");
	}
	
	public void run() {
		
		System.out.print("Running...");
	}
	
	@Override
	public void runnable() {
		// TODO Auto-generated method stub
	
		System.out.print("Runnable...");
	}

}
