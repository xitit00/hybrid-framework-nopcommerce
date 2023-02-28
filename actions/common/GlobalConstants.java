package common;

import java.io.File;

public class GlobalConstants {

	// chứa các biến hằng số dùng chung cho toàn bộ class , test : URL cho STG , DEV , PRO , TEST , ... 
	
	//DEV
	public static final String DEV_PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String DEV_ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
	
	//TEST
	public static final String TEST_PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String TEST_ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
		
	//STG
	public static final String STG_PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String STG_ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
	
	//PRE_PRD
	public static final String PRE_PRD_PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String PRE_PRD_ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";

	//PRO
	public static final String PRO_PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String PRO_ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com";
	
	// đường dẫn tương đối đến 1 file nào đó
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	
	// lấy ra java version 
	public static final String OS_NAME = System.getProperty("os.name");
	
	// lấy ra os name của hệ điều hành MAC / LINUX / WINDOW	
	public static final String JAVA_VERSION = System.getProperty("java.version");
	
	// File.separator giúp việc lấy node "/" hay "\\" MAC / LINUX / WINDOW	
	// /Users/anhnguyen/Documents/Selenium/03-Hybrid Automation Framework/uploadFiles/...
	// Thêm File.separator sau "up"oadFiles" vì upload file sẽ có thêm tên File đằng sau nữa 
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	
	// Trỏ về 1 thư mục mặc định của User 
	// Windows hay Mac gì cũng có Downloads , nếu gắn vào Downloads của máy để check việc download files thì đầu tiên sẽ phải xoá 
	// tất cả file hiện có trong Downloads đi , sau đó , mới down file mới về và getSize() của nó = 1 để check 
	// => tốt nhất nên có 1 Downloads cụ thể trong project thì tốt hơn 
	
	// /Users/anhnguyen/Documents/Selenium/03-Hybrid Automation Framework/downloadFiles
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP = PROJECT_PATH + File.separator + "dragAndDrop";
	public static final String IT_AUTO_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	
	// Attach screenshot to ReportNG / Extent Report version 2
	public static final String REPORTNG_SCREENSHOT  = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
	
	// Database Account / User / Pass / Port
	// Phần jenkins sẽ học set up web local + DB local = database testing + Selenium
	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_TEST_URL = "32.18.195.23:9860";
	
	// User/Pass truy cập vào AUT 
	public static final String DB_DEV_USER = "automationFC";
	public static final String DB_DEV_PW =  "autotest@1";
	
	public static final String DB_TEST_USER = "automationFC";
	public static final String DB_TEST_DPW =  "autotest@1";
	
	// Biến timeout gán cho từng class 
	public static final long SHORT_TIME_OUT = 5;
	// mặc định Long time out = 10s là ko đủ , nên là 30s đủ để page load xong / element đc render ra
	public static final long LONG_TIME_OUT = 30; 
	
	// Số lần retry lại test failed
	public static final long RETRY_TEST_ALL =  3;
	
	// Cloud Testing ( Browser Stack ) 
	// username
	public static final String BROWSER_USERNAME = "anhnguyen_arc2Tt";
	// accesskey 
	public static final String BROWSER_AUTOMATE_KEY = "vudEmSpBvPejoJByRrSL";
	// stack_url = https://anhnguyen_arc2Tt:vudEmSpBvPejoJByRrSL@hub-cloud.browserstack.com/wd/hub
	public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	// SauceLab 
	// username
	public static final String SAUCE_USERNAME = "oauth-anh.nguyen-5b5df";
	// accesskey 
	public static final String SAUCE_AUTOMATE_KEY = "a47ad500-7be5-43f3-a740-27e1f28b0da2";
	// stack_url = https://oauth-anh.nguyen-5b5df:a47ad500-7be5-43f3-a740-27e1f28b0da2.apac-southeast-1.saucelabs.com:443/wd/hub
	public static final String SAUCE_STACK_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	
	// Lambda Test 
	// username
	public static final String LAMBDA_USERNAME = "anh.nguyenvietlinkads";
	// accesskey 
	public static final String LAMBDA_AUTOMATE_KEY = "yCPizEGasmVKPBcK3vEMEk34085ijgkK5Rh9v5XdQMgz5uXQ8a";
	// stack_url = https://anh.nguyenvietlinkads:yCPizEGasmVKPBcK3vEMEk34085ijgkK5Rh9v5XdQMgz5uXQ8a@hub.lambdatest.com/wd/hub
	public static final String LAMBDA_STACK_URL = "https://" + LAMBDA_USERNAME + ":" + LAMBDA_AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";
	
	
	
	
}
