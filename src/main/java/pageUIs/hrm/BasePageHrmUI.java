package pageUIs.hrm;

public class BasePageHrmUI {
	
	//Dynamic locator
	public static final String MENU_PAGE_NAME="xpath=//div[@id='mainMenu']//a[string()='%s']";
	public static final String TEXTBOX_BY_ID="xpath=//input[@id='%s']";
	public static final String BUTTON_BY_ID="xpath=//input[@id='%s']";
	public static final String DROPDOWN_BY_ID="xpath=//select[@id='%s']";
	public static final String ANY_FIELD_BY_ID="xpath=//*[@id='%s']";
	public static final String CHECKBOX_BY_NAME="xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String RADIO_BY_NAME="xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String TABLE_BY_COLUMN="xpath=//table[@id='resultTable']//a[contains(text(),'Last Name')]//parent::th//preceding-sibling::th";
	public static final String TABLE_HEADER_BY_ID_BY_NAME="xpath=//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX="xpath=//table[@id='%s']//tbody/tr[%s]//td[%s]";
	public static final String UPDATE_INFO_SUCCESS="xpath=//div[@class='inner']/div[contains(text(),'%s')]";
	public static final String SELECT_ALL_CHECKBOX="xpath=//table[@id='%s']//th/input[@id='checkAll']";
	public static final String SELECT_CHECKBOX_ROW_INDEX="xpath=//table[@id='%s']//tbody/tr[%s]/td/input[@type='checkbox']";
	public static final String LABEL_NOT_DEFINED="xpath=//label[contains(text(),'%s')]//following-sibling::span/label[@id='%s']";
	public static final String TAB_SIDE_BAR_BY_NAME="xpath=//div[@id='sidebar']//a[text()='%s']";
	public static final String CHECKBOX_TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX="xpath=//table[@id='%s']//tbody/tr[%s]//td[%s]/input";
	public static final String TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX_INSIDE_TABLE="xpath=//table[@id='%s']//tbody/tr[%s]//tr/td[%s]";
	
	
	//Login to system with hard locator
	public static final String USERNAME_BY_ID="xpath=//input[@id='txtUsername']";
	public static final String PASSWORD_BY_ID="xpath=//input[@id='txtPassword']";
	public static final String BUTTON_BY_LOGIN_ID="xpath=//input[@id='btnLogin']";
	
	//Logout to system with hard locator
	public static final String ICON_LOGOUT_BY_ID="xpath=//a[@id='welcome']";
	public static final String LOGOUT_BUTTON_BY_NAME="xpath=//div[@id='welcome-menu']//a[text()='Logout']";
	
	
}
