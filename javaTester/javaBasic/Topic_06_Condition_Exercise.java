package javaBasic;


import java.util.Scanner;

import org.testng.annotations.Test;


public class Topic_06_Condition_Exercise {
	
	Scanner scan = new Scanner(System.in);

	//@Test
	public void TC_01() {

		
		int number = scan.nextInt();
		
		if (number % 2 == 0) {
			
			
			System.out.println("So chan");
		}
		else {
			
			System.out.println("So le");
		}
		
		
	}

	//@Test
	public void TC_02() {
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		if (a > b) {
			
			System.out.println(a + "" + "lon hon" + "" + b);
		}
		else if ( a == b) {
			
			System.out.println(a +"" + "bang" + "" + b);
		}
		else {
			
			System.out.println(a + "" + "nho hon" + "" + b);

		}

	}
	
	//@Test
	public void TC_03() {

		String nameA = scan.nextLine();
		String nameB = scan.nextLine();
		
		
		// == ko dung cho so sanh chuoi String 
//		if (nameA == nameB) {
//			
//			System.out.println(nameA + "" + " giong " + "" + nameB);
//		}
//		else {
//			
//			System.out.println(nameA + "" + " khac " + "" + nameB);
//		}
		
		if (nameA.equals(nameB)) {
			
			System.out.println(nameA + "" + " giong " + "" + nameB);
		}
		else {
			
			System.out.println(nameA + "" + " khac " + "" + nameB);
		}
		
	}
	
	@Test
	public void TC_04() {
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		if (a > b && a > c) {
			
			System.out.println(a + " la so lon nhat");
		}
		else if (b > a && b > c)  {
			
			System.out.println(b + " la so lon nhat");
		}
		else if (c > a && c > b)  {
			
			System.out.println(c + " la so lon nhat");

		}
		else {
			
			System.out.println("Ko co so lon nhat");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
