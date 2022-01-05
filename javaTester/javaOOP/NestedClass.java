package javaOOP;

public class NestedClass {
	
	public class InnerClass {
		
		String test = "";
		
		public void display() {
			
			System.out.print("ABC");
		}
	}
	
	public static void main (String[] args) {
		
		
		NestedClass n = new NestedClass();
		NestedClass.InnerClass inner = n.new InnerClass();
		
		inner.test = "Nested";
		inner.display();
		
	}

}
