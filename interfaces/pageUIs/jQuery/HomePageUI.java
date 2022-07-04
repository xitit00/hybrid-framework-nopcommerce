package pageUIs.jQuery;

public class HomePageUI {

	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()= '%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]";
	
	// Get all data 
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='country']";
	
	// Get All Column Country , tương tự Female , Male , Total
	public static final String ALL_ROW_EACH_PAGE_COUNTRY = "xpath=//tbody/tr/td[@data-key='country']";
}
