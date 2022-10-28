package pageUIs.wordpress;

public class AdminPostSearchPageUI {

	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCH_POSTS_BUTTON = "css=input#search-submit";
	
	// thead lấy ra index cột nào muốn trỏ tới nhờ header_name 
	// tbody lấy ra data cột nhờ header_index
	// dùng * để lấy toàn bộ , trong TH này thì là trỏ tới cột có thể là td hoặc th
	public static final String TABLE_HEADER_INDEX_BY_HEADER_ID = "xpath=//table[contains(@class,'table-view-list')]/thead/tr/th[@id ='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list')]/tbody/tr/*[%s]//a[text()='%s']";
}
