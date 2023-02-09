package pageObject.jQuery.DataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.DataTable.HomePageUI;

public class HomePageObject extends BasePage {
	
	WebDriver driver;

	public HomePageObject (WebDriver driver) {
		this.driver=driver;
	}
	public void movePageNumer(String Value) {
		waitForElementClickable(driver, HomePageUI.SELECT_PAGE_NUMBER, Value);;
		clickToElement(driver, HomePageUI.SELECT_PAGE_NUMBER, Value);
		}
	public void inputValueHeaderTextbox(String headerlabel, String valueheader) {
		waitForElemenInVisible(driver, HomePageUI.INPUT_BUTTON_TEXT, headerlabel);
		sendkeyToElement(driver, HomePageUI.INPUT_BUTTON_TEXT, valueheader, headerlabel);
		pressKeyToElement(driver, HomePageUI.INPUT_BUTTON_TEXT, Keys.ENTER, headerlabel);
	}
	public boolean isPageNumberActive(String value) {
		waitForElementVisible(driver, HomePageUI.VERIFY_PAGE_NUMBER_ACTIVE, value);
		return isElementDisplay(driver, HomePageUI.VERIFY_PAGE_NUMBER_ACTIVE, value);
	}

	public List<String> getValueEachRowAtAllPage() {
		int pageNumber = getElementSize(driver, HomePageUI.GET_NUMBER_PAGE);
		
		List<String> allValueTable = new ArrayList<String>();
		
		for (int i = 1; i <= pageNumber; i++) {
			clickToElement(driver, HomePageUI.GET_VALUE_INDEX_PAGE,String.valueOf(i));
			
			List<WebElement> allDataElementRowEachPage = getListWebElement(driver, HomePageUI.GET_DATA_EACH_PAGE);
			
			for (WebElement eachRow : allDataElementRowEachPage) {
				allValueTable.add(eachRow.getText());	
			}	
			}
		for (String value : allValueTable) {
			System.out.println("---------------");
			System.out.println("Value" + value);
		}
		return allValueTable;
	}
	public void inputValueToEachRow(String columnname, String numberrow, String value) {
		int numberColumn = getElementSize(driver,HomePageUI.GET_NUMBER_COLUMN,columnname) + 1;
		waitForElementClickable(driver,HomePageUI.TEXTBOX_INPUT_VALUE_AT_ROW,numberrow,String.valueOf(numberColumn));
		sendkeyToElement(driver,HomePageUI.TEXTBOX_INPUT_VALUE_AT_ROW,value,numberrow,String.valueOf(numberColumn));
	}

	public void openTableData() {
		waitForElementClickable(driver,HomePageUI.BUTTON_LOAD_DATA);
		clickToElement(driver,HomePageUI.BUTTON_LOAD_DATA);
	}

	public void selectValueToEachRow(String columnname,String numberrow,String value){
		int numberColumn = getElementSize(driver,HomePageUI.GET_NUMBER_COLUMN,columnname) + 1;
		waitForElementClickable(driver,HomePageUI.DROPDOWN_VALUE,numberrow,String.valueOf(numberColumn));
		selecItemInDefaultDropdown(driver,HomePageUI.DROPDOWN_VALUE,value,numberrow,String.valueOf(numberColumn));
	}

	public void checkValueToEachRow(String columnname, String numberrow) {
		int numberColumn = getElementSize(driver,HomePageUI.GET_NUMBER_COLUMN,columnname) + 1;
		waitForElementClickable(driver,HomePageUI.CHECK_UNCHECK_VALUE,numberrow,String.valueOf(numberColumn));
		checkToDefaultCheckboxRadio(driver,HomePageUI.CHECK_UNCHECK_VALUE,numberrow,String.valueOf(numberColumn));

	}
	public void uncheckValueToEachRow(String columnname, String numberrow) {
		int numberColumn = getElementSize(driver,HomePageUI.GET_NUMBER_COLUMN,columnname) + 1;
		waitForElementClickable(driver,HomePageUI.CHECK_UNCHECK_VALUE,numberrow,String.valueOf(numberColumn));
		uncheckToDefaultCheckbox(driver,HomePageUI.CHECK_UNCHECK_VALUE,numberrow,String.valueOf(numberColumn));
	}
	public void updateRowInTable(String value, String numberrow) {
		waitForElementClickable(driver,HomePageUI.ICON_ROW_IN_TABLE,value,numberrow);
		clickToElement(driver,HomePageUI.ICON_ROW_IN_TABLE,value,numberrow);
	}

}


