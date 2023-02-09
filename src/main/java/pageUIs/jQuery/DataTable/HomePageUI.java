package pageUIs.jQuery.DataTable;

public class HomePageUI {
	public static final String SELECT_PAGE_NUMBER="xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String INPUT_BUTTON_TEXT="xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String VERIFY_PAGE_NUMBER_ACTIVE="xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String GET_NUMBER_PAGE = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page']";
	public static final String GET_VALUE_INDEX_PAGE="xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String GET_DATA_EACH_PAGE="xpath=//tbody/tr";
	public static final String GET_DATA_COUNTRY_VALUE_PAGE="xpath=//tr/td[@data-key='country']";

	public static final String GET_NUMBER_COLUMN= "xpath=//td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_INPUT_VALUE_AT_ROW="xpath=//tr[%s]/td[%s]/input";
	public static final String BUTTON_LOAD_DATA="xpath=//button[@id='btnLoad']";
	public static final String DROPDOWN_VALUE="xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String CHECK_UNCHECK_VALUE="xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String NUMBER_COLUMN_TABLE="xpath=//thead/tr/following-sibling::tr/td";
	public static final String ICON_ROW_IN_TABLE ="xpath=//tbody/tr[%s]//button[@title='%s']";


}
