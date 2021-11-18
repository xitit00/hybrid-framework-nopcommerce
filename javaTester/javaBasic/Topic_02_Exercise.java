package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Exercise {

	@Test
	public void TC_01() {
		
		int a = 5; 
		int b = 10;
		
		int tong = a + b ;
		
		int hieu = a - b;
		
		Integer tich = a * b; 
		
		int thuong = a / b;
		
		System.out.println("Tong: " + tong);
		System.out.println("Hieu:" + hieu);
		System.out.println("Tich:" + tich);
		System.out.println("Thuong:" + thuong);
		
	}
	
	@Test
	public void TC_02() {
		
		double height = 7.5d;
		float width = 3.8f;
		
		float s = (float)height * width;
		
		System.out.println("Dien tich: " + s);
	}
}
