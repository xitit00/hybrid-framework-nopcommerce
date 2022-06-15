package javaOOP.polymorphism;

public class Operator {
	
	public void sum (int a, int b) {
		
		System.out.println(a+b);
	}
	
	public void sum (float a, float b) {

		System.out.println(a+b);
	}

	public void sum (long a, long b) {

		System.out.println(a+b);
	}

	public void sum (double a, double b) {

		System.out.println(a+b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Operator op = new Operator();
		op.sum(5, 10);
		op.sum(5.5f, 2.3f);
		op.sum(50000000000l, 300000l);
		op.sum(13.33333d, 6.444444d);
	}

}
