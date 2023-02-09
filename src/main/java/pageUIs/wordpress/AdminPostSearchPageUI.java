package pageUIs.wordpress;

public class AdminPostSearchPageUI {
	
	public static final String POSTS_PAGE="xpath=//div[@class='wp-menu-name' and text()='Posts']";
	public static final String ADD_NEW_BUTTON="xpath=//a[@class='page-title-action' and text()='Add New']";
	public static final String SEARCH_TEXTBOX="xpath=//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON="xpath=//input[@id='search-submit']";
	public static final String VALUE_COLUMN_SEARCH_IN_TABLE="xpath=//table[contains(@class,'table-view-list')]//th[@id='%s']/preceding-sibling::*";
	public static final String VALUE_INDEX_ROW_SEARCH_IN_TABLE="xpath=//table[contains(@class,'table-view-list')]//tbody/tr/*[%s]//a[contains(text(),'%s')]";
	public static final String CHECKBOX_TITLE_POST="xpath=//table[contains(@class,'table-view-list')]//tbody/tr/th/label[contains(text(),'%s')]/following-sibling::input";
	public static final String DROPDOWN_BULK_ACTIONS="xpath=//select[@id='bulk-action-selector-top']";
	public static final String APPLY_BUTTON="xpath=//input[@id='doaction']";
	public static final String RETURN_MESSAGE="xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String POST_NOT_FOUND="xpath=//table[contains(@class,'table-view-list')]//tbody/tr/td[text()='%s']";
	
	
	

}
