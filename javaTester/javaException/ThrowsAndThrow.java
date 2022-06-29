package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThrowsAndThrow {

	// Throws : thay vì gọi try/catch ở dưới cho lệnh close() thì gọi IOException ngay đầu hàm 
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		

		FileOutputStream outputStream = null;
		
		try {

			outputStream = new FileOutputStream("/Users/anhnguyen/Documents/Appium.docx");
			outputStream.write(65);
			
		} catch (FileNotFoundException e) {
			// TODO: handle
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			outputStream.close();
			
		}
		
		// khi có hàm khác gọi thì 1 là xài throws trên luôn hoặc là try/catch bọc lại
		sleepInSec(1000);

	}
	
	//vd như có hàm khác dùng try/catch or throws thì gọi ra ở hàm main trên như nào ? 
	public static void sleepInSec(long timeout) throws InterruptedException {
		
		Thread.sleep(1000*timeout);
		
		
	}
	
	// Throw : xem nó như là 1 message , khai báo 1 ngoại lệ cụ thể bên trong phương thức
	// Ngoại lệ đc khai báo bởi throw sẽ đc ném cho ngoại lệ đc khai báo với throws của phương thức 
	
	public void findFile(int param) throws IOException {
		
		int f = 1;
		
		if (param > 0) {
			
			f = param;
		}
		else {
			
			throw new IOException("Be hon 0");
		}
		
	}
	

}
