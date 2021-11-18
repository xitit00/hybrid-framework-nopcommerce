package javaBasic;

import org.testng.Assert;

public class Topic_04_Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 10;;
		
		System.out.println(num++); // 10 
		// In num ra trc : 10 
		// ++ tăng num = 11 sau 
		
		System.out.println(++num); // 12
		// ++ trc : tăng num lên 1 = 12 
		// in num ra sau : 12
		
		for (int i = 0; i < 3; i++) {
			
			System.out.println(i);
		}
		
		// có thể truyền 1 đk vào những hàm mang tính chất so sánh
		Assert.assertTrue( 5 < 6);
		String address = "HCM";
		
		if (!(address == "HN")) {
			
			System.out.println("Address is not the same");
		}
		
		// cách viết tắt hàm if else nhanh 
		boolean status = (address == "HN") ? true : false;
		System.out.println(status);

	}

}
