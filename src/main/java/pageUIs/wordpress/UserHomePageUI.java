package pageUIs.wordpress;

public class UserHomePageUI {
	
	public static final String TITLE_POST = "xpath=//article//a[text()='%s']";
	public static final String BOBY_POST = "xpath=//article//a[text()='%s']//ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String AUTHOR_POST = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//span/a[text()='%s']";
	public static final String TIME_CREATE_POST = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div/span/a/time[text()='%s']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='wp-block-search__input-1']";
	public static final String SEARCH_BUTTON = "xpath=//button[@class='wp-block-search__button  ']";
	
}
