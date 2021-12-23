package pageUIs;

public class ProductReviewPageUI {
	
	public static final String REVIEW_TITLE_TEXTBOX = "//input[@class='review-title']";
	public static final String REVIEW_TEXT_TEXTBOX = "//textarea[@class='review-text']";
	public static final String REVIEW_RATING_RADIO_BUTTON = "//input[@aria-label='Good']";
	public static final String REVIEW_SUBMIT_BUTTON = "//button[text()='Submit review']";
	
	public static final String REVIEW_MESSAGE = "//div[contains(text(),'Product review is successfully added.')]";
	public static final String REVIEW_TITLE = "//div[@class= 'review-title']/strong";
	public static final String REVIEW_TEXT = "//div[@class= 'review-text']";
	//strong[text()='order 123']/parent::div/following-sibling::div/div[@class='rating']/div
	public static final String REVIEW_RATING = "//div[@class='product-review-box']/div[@class='rating']/div";
}
