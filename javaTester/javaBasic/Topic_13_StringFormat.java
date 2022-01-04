package javaBasic;

public class Topic_13_StringFormat {
	
	// 14 pages = 14 biến locator 
	public static String ADDRESSES_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	
	// 1 biến cho cả 14 pages hoặc n pages tuỳ ( format giống nhau - khác nhau bởi tên page - text value )
	public static String DYNAMIC_SIDEBAR = "//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	// 1 locator để đại diện cho các page (Header/ Sidebar/ Footer) 
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";

	public static void main(String[] args) {
		
		// only sidebar 
//		clickToLink(DYNAMIC_SIDEBAR, "Addresses");
//		clickToLink(DYNAMIC_SIDEBAR, "Reward points");
//		clickToLink(DYNAMIC_SIDEBAR, "My product reviews");
		
		// include sidebar , header , footer 
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME,"account-navigation","Addresses");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME,"footer-upper","Search");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME,"header-upper","My account");
	}
	
	// 1 tham số pageName
	public static void clickToLink(String dynamicLocator ,String pageName) {
		
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("Click to: " + locator);
		
		
	}
	
	// 2 tham số areaName , pageName 
	public static void clickToLink(String dynamicLocator , String areaName, String pageName) {
		
		String locator = String.format(dynamicLocator, areaName ,pageName);
		System.out.println("Click to: " + locator);
		
	}
	
	// n tham số , dùng ... rest parameter : tham số có kiểu dữ liệu giống nhau 
	
	public static void clickToLink(String dynamicLocator , String ...params) {
		
		// báo ko match type hiện tại nên cast to Object => (Object[]) params
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
		
		
	}
}
