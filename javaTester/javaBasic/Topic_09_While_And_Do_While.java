package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_And_Do_While {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		TC_02();
	}

	//@Test
	public void TC_01() {
		
		
		// TODO Auto-generated method stub

		//For
		for (int i = 0; i < 5; i++) {

			System.out.print("For: " + i);
			if (i==2) {
				
				break;
			}

		}

		//while
		int i = 0;
		while (i < 5) {
			
			System.out.print("While: " + i);

			i++;
			
			if (i==2) {
				
				break;
			}
		}
		
		//Do-while
		do {
			
			System.out.print("Do-While: " + i);
			i++;
			
		} while (i<5);

	}
	
	//@Test
	public static void TC_02() {
		
		int n = scan.nextInt();
		
//		for (int i = n; i <= 100; i++) {
//			
//			if(i%2 == 0) {
//				
//				System.out.println(i);
//			}
//		}
		
//		while (n <= 100) {
//			
//			if (n % 2 == 0) {
//
//				System.out.println(n);
//			}
//			
//			n++;
//		}
//		
		
		do {
			
			if (n % 2 == 0) {

				System.out.println(n);
			}
			
			n++;
			
		} while (n <= 100);
		
	}
	
	//@Test
	public void TC_03() {

		int a = scan.nextInt();
		int b = scan.nextInt();

		do {

			if (a % 3 == 0 && a % 5 == 0) {

				System.out.println(a);
				
			}
			a++;

		} while (a < b);

	}
	
	//@Test
	public void TC_04() {

		int n = scan.nextInt();
		int i = 0;
		int sum = 0;

		do {

			if (i % 2 != 0) {

				
				System.out.println(i);
				
				sum = sum + i;
				System.out.println("Sum :" + sum);
				
			}
			i++;

		} while (i <= n);

	}
	
	//@Test
	public void TC_05() {

		int a = scan.nextInt();
		int b = scan.nextInt();

		do {

			if (a % 3 == 0) {

				System.out.println(a);
				
			}
			a++;

		} while (a < b);

	}
	
	@Test
	public void TC_06() {

		int n = scan.nextInt();
		int i = 1;
		int total = 1;

		do {


			total = total * i;
			System.out.println("Sum :" + total);
			i++;

		} while (i <= n);

	}
	
	

}
