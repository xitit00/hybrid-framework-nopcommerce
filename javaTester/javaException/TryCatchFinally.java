package javaException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileOutputStream outputStream = null;
		
		try {
			
//			File f = new File("/Users/anhnguyen/Documents/Java.docx");
//			f.createNewFile();
			
			// MAC
			outputStream = new FileOutputStream("/Users/anhnguyen/Documents/Appium.docx");
			
			// WIN outputStream = new FileOutputStream("D://abc.txt");
			outputStream.write(65);
			
		} catch (FileNotFoundException e) {
			// TODO: handle
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				outputStream.close();
				
			} catch (IOException e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
			
		}

	}

}
