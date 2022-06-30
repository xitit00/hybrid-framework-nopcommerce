package javaBasic;

import java.io.File;

public class Topic_14_Node_Path_Window_Mac_Linux {
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	
	// MAC / LINUX / WINDOW	
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles";
	
	public static final String OS_NAME = System.getProperty("os.name");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//MAC
		System.out.println(PROJECT_PATH);
		// /Users/anhnguyen/Documents/Selenium/03-Hybrid Automation Framework
		System.out.println(UPLOAD_FILE_FOLDER);
		// /Users/anhnguyen/Documents/Selenium/03-Hybrid Automation Framework/uploadFiles
		System.out.println(OS_NAME);
	}

}
