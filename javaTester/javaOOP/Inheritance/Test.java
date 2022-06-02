package javaOOP.Inheritance;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Dog d = new Dog();	
//		d.eat();
//		d.run();
//		d.runnable();
		
		// Encapsulation
		Dog d = new Dog();
		d.setAge(15);
		System.out.println("Dog's Age:" + d.getAge());
		
		// Multiple Level ( Kế thừa nhiều cấp )
		HuskyDog h = new HuskyDog();
		h.eat();
		h.hunt();
		h.run();
		h.runnable();
	}

}
