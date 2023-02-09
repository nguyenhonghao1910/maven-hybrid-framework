package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.MyInfoPageUI;

public class EmployeeListPO extends BasePage {
	WebDriver driver;
	
	public EmployeeListPO(WebDriver driver) {
		this.driver = driver;
	}


	public Object getValueInMainTableIDAtColumnNameAndRowIndexUserPage(WebDriver driver, String tableID, String tableIndex, String valueName) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getValueInMainTableIDAtColumnSalaryComponentRowIndexUserPage(WebDriver driver, String tableID,String rowIndex) {
		waitForElemenInVisible(driver, MyInfoPageUI.TABLE_SALARY_BY_COLOMN_SALARY_COMPONENT_BY_ROW_INDEX, tableID,rowIndex);
		return getTextElement(driver, MyInfoPageUI.TABLE_SALARY_BY_COLOMN_SALARY_COMPONENT_BY_ROW_INDEX, tableID,rowIndex);
	}


	public String getValueInMainTableIDWithRowIndexAtColumnNameUserPage(WebDriver driver, String tableID,String rowIndex, String columnName) {
		waitForElemenInVisible(driver, MyInfoPageUI.TABLE_SALARY_BY_ROW_INDEX_BY_COLOMN_NAME, tableID,rowIndex,columnName);
		return getTextElement(driver, MyInfoPageUI.TABLE_SALARY_BY_ROW_INDEX_BY_COLOMN_NAME, tableID,rowIndex,columnName);
	}


	public void clickToCheckboxInMainTableByRowIndexUserPage(WebDriver driver, String tableID, String rowIndex) {
		waitForElementClickable(driver, MyInfoPageUI.SELECT_CHECKBOX_TABLE_SALARY_BY_COLOMN_INDEX_BY_ROW_INDEX, tableID,rowIndex);
		clickToElement(driver, MyInfoPageUI.SELECT_CHECKBOX_TABLE_SALARY_BY_COLOMN_INDEX_BY_ROW_INDEX, tableID,rowIndex);
	}


	public String getValueInSubTableIDAtRowIndexAndColumnIndexUserPage(WebDriver driver, String tableID, String rowIndex,String columnIndex) {
		waitForElemenInVisible(driver, MyInfoPageUI.SUB_TABLE_ROW_BY_ROW_INDEX_AND_COLOMN_INDEX_INSIDE_TABLE, tableID,rowIndex,columnIndex);
		return getTextElement(driver, MyInfoPageUI.SUB_TABLE_ROW_BY_ROW_INDEX_AND_COLOMN_INDEX_INSIDE_TABLE, tableID,rowIndex,columnIndex);
	}










}
