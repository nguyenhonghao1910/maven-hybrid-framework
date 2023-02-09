package pageUIs.hrm;

public class MyInfoPageUI {
	public static final String ICON_AVATAR="xpath=//img[@id='empPic']";
	public static final String TAB_SIDE_BAR_BY_NAME="xpath=//div[@id='sidebar']//a[text()='%s']";
	
	public static final String TABLE_SALARY_BY_COLOMN_SALARY_COMPONENT_BY_ROW_INDEX="xpath=//table[@id='%s']//tbody/tr[%s]/td[@class='component']/input";
	public static final String TABLE_SALARY_BY_ROW_INDEX_BY_COLOMN_NAME="xpath=//table[@id='%s']//tbody/tr[%s]/td[@class='%s']";
	public static final String SELECT_CHECKBOX_TABLE_SALARY_BY_COLOMN_INDEX_BY_ROW_INDEX="xpath=//table[@id='%s']//tbody/tr[%s]/td/input[@type='checkbox']";
	public static final String SUB_TABLE_ROW_BY_ROW_INDEX_AND_COLOMN_INDEX_INSIDE_TABLE="xpath=//table[@id='%s']//tbody/tr[%s]//tr/td[%s]";
	

}
