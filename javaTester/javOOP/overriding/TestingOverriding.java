package javOOP.overriding;

public class TestingOverriding {
	
	public static void main(String[] args) {
		
		// class cha là class abstract , thì ko có khởi tạo ở class khác , ko thân hàm ở bên trong.

		
		// class cha là 1 class kế thừa bình thường 
//		Person p = new Person();
//		p.eat();
		
		Employee e = new Employee();
		e.eat();
		e.sleep();
		e.workingTime();
		
		Student s = new Student();
		s.eat();
		s.sleep();
		s.workingTime();
	}

}
