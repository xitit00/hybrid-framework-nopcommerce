package javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Topic_12_String {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC_02();
		TC_03();
		TC_04();
		TC_05();
		TC_06();
		TC_07();
		TC_08();
		TC_09();
	}
	
	public static void TC_01() {
		
		String s = "anh BTC ne";
		// length : độ dài chuỗi
		System.out.println(s.length());
		
		//charAt : lấy ra vị trí Ký Tự trong chuỗi 
		System.out.println(s.charAt(3));
		
		//concate: nối chuỗi
		String a = "haha";
		System.out.println(s.concat(a));
		
		//equals: so sánh tuyệt đối  , nhưng phân biệt hoa thường 
		if (a.equals(s)) {
			
			//
		}
		
		//equalsIgnoreCase: so sánh tương đối , nhưng ko phân biệt hoa thường , dùng cho ss multiBrowser
		if (a.equalsIgnoreCase(s)) {
			
			//
		}
		
		//startWith ,endWith , contains 
		if (a.contains("h")) {
			
			//
		}
		
		if (a.startsWith("a")) {
			
			//
		}

		if (a.endsWith("b")) {
			
			//
		}
		
		//index : lấy vị trí Từ trong 1 chuỗi , tính từ ký tự mà mình truyền vô
		
		int i = s.indexOf(" BTC");
		System.out.println(i);
		
		//substring : tách ký tự ra trong 1 chuỗi theo index , sẽ bỏ đi những ký tự trước ký tự theo cái index truyền vô 
		//anh BTC ne -> ne
		String z = s.substring(7);
		System.out.println(z);
		
		// anh BTC ne -> BT
		String y = s.substring(4, 6);
		System.out.println(y);

		//split : phân tách chuỗi theo ký tự , vd: " ", // , ... -> ra 1 cái mảng sẽ làm dễ hơn substring ( dùng để lấy kết quả display ) 
		String result = "Viewing 72 of 1888 results";
		String results[] = result.split(" ");
		System.out.println(results[1]);
		
		//replace : thay thế ký tự/ chuỗi = ký tự/ chuỗi khác
		//parseFloat , parseInt , ... : dùng để ép kiểu String về kiểu số để tính toán 
		String temp = "$100.0";
		temp = temp.replace("$", "");
		Float d = Float.parseFloat(temp);
		
		//valueOf() : dùng để ép kiểu int , float , ... về String
		int num = 100;
		String strNum = String.valueOf(num);
		
		// -> Sẽ có 1 bài học ở trong phần Framework về sort Asc / Desc , vì String và Float nó sort kiểu khác nhau cho nên phải convert 
		
		String osName = System.getProperty("os.name");
		// Handle multiple OS: Mac/Windows(Actions - keys - Ctrl / Cmd)
		// ép lowercase cho chắc chắn tất cả ký tự về thường hết để dễ so sánh 
		if (osName.toLowerCase().contains("mac")) {

			Keys key = Keys.COMMAND;
			
		} else {

			Keys key = Keys.CONTROL;
		}
		
		// Multiple browser: toUpperCase 
		// firefox => FIREFOX ( Enum ) 
		// -> sang phần framework sẽ có bài cần phải viết Hoa hết lên và sẽ dùng Enum để kiểm tra
		
		
		// FirefoxDriver: firefox on WINDOWS 
		// Close browser / driver ( gecko , chrome , msedge ) trên Window taskbar -> Process sẽ ko tự tắt browser/driver bên trong before
		
		String driverInstanceName = driver.toString();
		System.out.println(driverInstanceName);
		
		// Trên IE thì cần phải sleep cứng thêm 5s sau mỗi sự kiện chuyển page
		if (driverInstanceName.contains("internetexplorer")) {
			
		}

		// Trim khoảng trắng / xuống dòng / tab 
		String text = "\n"
				+ "                First Option\n"
				+ "            ";

		System.out.println("-----" + text + "-----");
		System.out.println(text.trim());
		
		Assert.assertEquals(text.trim(),"First Option");
		
		String hello = " ";
		//isEmpty : trả về boolean , vẫn chứa ký tự khoảng trắng là vẫn tính là có , trừ khi ko chứa bất kỳ ký tự nào hết
		// true 
		hello.isEmpty();
		//isBlank : trả về boolean , dù chứa ký tự khoảng trắng thì vẫn là blank 
		// flase 
		hello.isBlank(); 
	}
	
	public static void TC_02() {

		String a = "anh BTC ne HAHa";
		// conver String to charArr
		char[] charArray = a.toCharArray();
		int numUpper = 0;
		int numLower = 0;

		// upper case
		for (int i = 0; i < charArray.length; i++) {

			// if any char is uppercase
			// c1
			if (Character.isUpperCase(charArray[i])) {

				numUpper++;

			}

			// c2
//			if (charArray[i] <= 'Z' && charArray[i] >= 'A') {
//
//				numUpper++;
//			}

		}

		System.out.println(numUpper);

		// lower case
		for (int i = 0; i < charArray.length; i++) {

			// if any char is uppercase
			// c1
			if (Character.isLowerCase(charArray[i])) {

				numLower++;

			}

			// c2
//			if (charArray[i] <= 'z' && charArray[i] >= 'a') {
//
//				numLower++;
//			}

		}

		System.out.println(numLower);

	}
	
	public static void TC_03() {
		
		String a = "Automation Testing 345 Tutorials Online 789";
		// convert String to charArr
		char[] charArray = a.toCharArray();
        int numCount = 0; 
        for(int i=0; i < charArray.length; i++){
            
        	// convert char to String
        	// c1 
            String strA = String.valueOf(charArray[i]); 
            if (strA.equalsIgnoreCase("a")) {
            	  
            	numCount++;
            }
            
            // c2 
            if (charArray[i] == 'a') {
            	
            	numCount++;
            }

        }
        
        System.out.println(numCount);
	}

	public static void TC_04() {

		String a = "Automation Testing 345 Tutorials Online 789";
		if (a.contains("Testing")) {

			System.out.println("True");
		}

	}
	
	public static void TC_05() {

		String a = "Automation Testing 345 Tutorials Online 789";
		if (a.startsWith("Automation")) {

			System.out.println("True");
		}

	}
	
	public static void TC_06() {

		String a = "Automation Testing 345 Tutorials Online 789";
		if (a.contains("Online")) {

			System.out.println("False");
		}

	}
	
	public static void TC_07() {

		String a = "Automation Testing 345 Tutorials Online 789";
		System.out.println(a.indexOf("Tutorials"));

	}
	
	public static void TC_08() {

		String a = "Automation Testing 345 Tutorials Online 789";
		a = a.replace("Online", "Offline");
		System.out.println(a);

	}
	
	public static void TC_09() {

		String a = "Automation Testing 345 Tutorials Online 789";
		// convert String to charArr
		char[] charArray = a.toCharArray();
		int numCount = 0;
		for (int i = 0; i < charArray.length; i++) {

			// convert char to String
			// c1 
			String strA = String.valueOf(charArray[i]);
			if (strA.matches(".*\\d.*")) {

				numCount++;
			}
			
			// c2
			
//			if (charArray[i] <= '9' && charArray[i] >= 0) {
//				
//				numCount++;
//			}

		}

		System.out.println(numCount);
	}
	
}
