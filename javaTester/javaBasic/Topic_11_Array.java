package javaBasic;

import java.util.ArrayList;
import java.util.List;

import common.GlobalConstants;


public class Topic_11_Array {
	
	// Thuộc tính / Biến 
	
	String name;
	int age;
	
	// Constructor: hàm khởi tạo , chứa các thuộc tính , biến của cái class , object mà m muốn khởi tạo 
	public Topic_11_Array(String name , int age) {
		
		this.name = name;
		this.age = age;
	}
	
	public void display() {
		
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Topic_11_Array students[] = new Topic_11_Array[3];
//		
//		students[0] = new Topic_11_Array("A", 23);
//		students[1] = new Topic_11_Array("B", 24);
//		students[2] = new Topic_11_Array("C", 25);
//		
//		
//		for (Topic_11_Array std : students) {
//			
//			std.display();
//		}
		
		TC_02();
		TC_03();
		TC_04();
		TC_05();
		TC_06();
		TC_07();
		TC_08();
	}

	public void TC_01() {

		// Khai báo mảng có 2 cách viết

		// c1 : phổ biến nhất
		int number[] = { 1, 2, 3, 4, 5, 6 };
		// cập nhật lại 1 pt trong mảng
		// -> 0,2,3,4,5,6
		number[0] = 1;

		// c2 : ít phổ biến
		int[] num = { 6, 7, 8, 9, 0 };
		// in ra pt tuỳ ý
		System.out.print(num[2]);

		// c3 : ko hay dùng , khởi tạo rồi gán từng giá trị
		int temp[] = new int[5];
		temp[0] = 1;
		temp[1] = 3;
		temp[2] = 5;

		// c4: dùng vòng lặp để duyệt , rồi gán giá trị trong mảng , for hoặc for each
		// tuỳ
		// h

		String stdName[] = { "A", "B", "C" };

		for (int i = 0; i < stdName.length; i++) {

			if (stdName[i].equals("B")) {

				stdName[i] = "D";
			}
		}

		for (String strStdName : stdName) {

			if (strStdName.equals("A")) {

				strStdName = "E";
			}
		}

		// Array List

		ArrayList<String> arrName = new ArrayList<>();
		arrName.add("");
		arrName.remove("");
		arrName.contains("");
		arrName.size();
		arrName.isEmpty();
		arrName.lastIndexOf("");

		// List
		List<String> listName = new ArrayList();
	}
	
	public static void TC_02() {
		
		int arrNum[] = {99,7,11,8,9};
		int n = 0;
		for (int i = 0; i < arrNum.length; i++) {
			
			if (arrNum[i] > n) {
				
				n = arrNum[i];
			}
		}
		
		System.out.println(n);
	}
	
	public static void TC_03() {
		
		int arrNum[] = {99,7,11,8,9};
		int totalNum = 0;
		totalNum = arrNum[0] + arrNum[arrNum.length - 1];
		
		System.out.println(totalNum);
	}
	
	public static void TC_04() {
		
		int arrNum[] = {2,7,6,8,9,17,16,20};
		for (int i = 0; i < arrNum.length; i++) {
			
			if (arrNum[i] % 2 == 0) {
				
				System.out.println(arrNum[i]);
			}
		}
		
		
	}
	
	public static void TC_05() {

		int arrNum[] = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int totalSum = 0;
		for (int i = 0; i < arrNum.length; i++) {

			if (arrNum[i] % 2 == 1 && arrNum[i] > 0) {

				totalSum += arrNum[i];
				
			}
		}
		
		System.out.println(totalSum);

	}
	
	public static void TC_06() {

		int arrNum[] = { 3, -7, 2, 5, 9, -6, 10, 12 };
	
		for (int i = 0; i < arrNum.length; i++) {

			if (arrNum[i] >= 0 && arrNum[i] <= 10) {

				System.out.println(arrNum[i]);
			}
		}
		
		

	}
	
	public static void TC_07() {

		int arrNum[] = { 3, 5, 7, 30, 10, 5, 8, 23 ,0 , -5 };
		int tong = 0;
		float tb = 0;
		for (int i = 0; i < arrNum.length; i++) {

				tong += arrNum[i];
				tb = tong / arrNum.length;
				
				

		}
		
		System.out.println("Tong cac pt: " + tong);
		System.out.println("Tb cong: " + tb);

	}
	
	public static void TC_08() {
		
		String[] fileNames = {"CSharp.png","Java.png","Python.png"};
		
		String filePath = GlobalConstants.UPLOAD_FILE;
		
		String fullFileName = "";
		for (String file : fileNames) {
		
			fullFileName = fullFileName + filePath + file + "\n";
			
		}
		fullFileName = fullFileName.trim();
		
		System.out.println(fullFileName);
	}

}
