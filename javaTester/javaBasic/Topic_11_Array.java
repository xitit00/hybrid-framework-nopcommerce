package javaBasic;

import java.util.ArrayList;
import java.util.List;

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
		
		Topic_11_Array students[] = new Topic_11_Array[3];
		
		students[0] = new Topic_11_Array("A", 23);
		students[1] = new Topic_11_Array("B", 24);
		students[2] = new Topic_11_Array("C", 25);
		
		
		for (Topic_11_Array std : students) {
			
			std.display();
		}
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

}
