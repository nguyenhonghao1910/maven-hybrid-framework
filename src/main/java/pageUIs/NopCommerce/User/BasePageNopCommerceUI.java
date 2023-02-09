package pageUIs.NopCommerce.User;

public class BasePageNopCommerceUI {
	
	public static final String OPEN_CUSTOMER_INFO ="xpath=//div[@class='listbox']//a[contains(text(),'Customer info')]";
	public static final String OPEN_ADDRESS="xpath=//div[@class='listbox']//a[contains(text(),'Addresses')]";
	public static final String OPEN_ORDERS="xpath=//div[@class='listbox']//a[contains(text(),'Orders')]";
	public static final String OPEN_REWARD_POINTS="xpath=//div[@class='listbox']//a[contains(text(),'Reward points')]";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA="xpath=//div[@class='listbox']//a[contains(text(),'%s')]";
	
	public static final String LOGOUT_BUTTON_USER_PAGE="css=//a[@=class='ico-logout']";
	public static final String LOGOUT_BUTTON_ADMIN_PAGE="xpath=//a[text()='Logout']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[contains(text(),'%s')]";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";

}
