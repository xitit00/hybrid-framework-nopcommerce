package javaOOP.polymorphism;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal a = new Animal();
		a.eat();
		
		a = new Pig();
		// Khi xem eat() trong lúc compile dẫn tới đâu thì là Animal , nhưng thực chất nó khi chạy nó lại nhảy vào Pig 
		// => tính đa hình trong quá trình Runtime của JVM 
		a.eat();

	}

}
