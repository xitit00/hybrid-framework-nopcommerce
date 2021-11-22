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
	
	//@Test
	public void TC_05() {
		
		int a = scan.nextInt();
		
		
		if (10 < a && a < 100) {
			
			System.out.println(a + " nam trong khoang xxx");
		}
		else {
			
			System.out.println(a + " nam ngoai khoang xxx");
		}
		
	}
	
	//@Test
	public void TC_06() {
		
//		0 < 5	  :D
//		5 < 7.5   :C
//		7.5 < 8.5 :B
//		8.5 - 10  :A
		
		float point = scan.nextFloat();
		
		
		if (point <= 10 && point >= 8.5) {
			
			System.out.println("He so A");
		}
		else if (point < 8.5 && point >= 7.5) {
			
			System.out.println("He so B");
			
		}else if (point < 7.5 && point >= 5) {
			
			System.out.println("He so C");

		}
		else if (point < 5 && point >= 0) {
			
			System.out.println("He so D");

		}
		else {
			
			System.out.println("Vui long nhap lai");
		}
		
	}
	
	@Test
	public void TC_07() {

		int month = scan.nextInt();

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {

			System.out.println("Thang co 31 ngay");
			
		} else if (month == 2) {

			System.out.println("Thang co 28 ngay");

		} else {

			System.out.println("Thang co 30 ngay");
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
