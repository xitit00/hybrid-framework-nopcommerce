package javaException;

public class TryCatchException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 10; 
		
		// ví dụ ở đây cho ta thấy đc là có nhiều step sau đây thì :
			// nếu dùng try/catch thì sẽ KO bị gián đoạn 
			// nếu KO dùng try/catch thì sẽ bị gián đoạn
		
		try {
			
			// đúng: chạy hết đoạn code trong try và ko qua catch
			// sai: gặp exception - nhảy qua catch 
			// lỗi ArithmeticException 
			number = number / 0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		
		// 
		
		String[] browserName = {"Chrome", "Firefox", "Safari"};
		
		try {
			
			browserName[0] = "Edge";
			// lỗi array index out of bounds expception 
			browserName[3] = "Edge";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// in ra xem thay đổi data trong mảng từ "Chrome", "Firefox", "Safari" => "Edge", "Firefox", "Safari"
		
		
		for (String browser : browserName) {
			
			System.out.println(browser);
			
		}
		
	}

}
