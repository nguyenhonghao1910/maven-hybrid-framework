package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage{
	
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver=driver;
	}

	public AdminCreatePostNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminCreatePostNewPage(driver);
	}

	public void inputTitlePostIntoSearchTextbox(String titlePost) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, titlePost);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_BUTTON);	
	}

	public boolean isDisplayValueBySearchTextbox(String headID, String cellValue) {
		int indexColumn = getElementSize(driver, AdminPostSearchPageUI.VALUE_COLUMN_SEARCH_IN_TABLE,headID) +1;
		waitForElementVisible(driver, AdminPostSearchPageUI.VALUE_INDEX_ROW_SEARCH_IN_TABLE,String.valueOf(indexColumn) ,cellValue);
		return isElementDisplay(driver, AdminPostSearchPageUI.VALUE_INDEX_ROW_SEARCH_IN_TABLE,String.valueOf(indexColumn) ,cellValue);
	}

	public AdminCreatePostNewPO clickToTitlePost(String headID, String cellValue) {
		int indexColumn = getElementSize(driver, AdminPostSearchPageUI.VALUE_COLUMN_SEARCH_IN_TABLE,headID) +1;
		waitForElementClickable(driver, AdminPostSearchPageUI.VALUE_INDEX_ROW_SEARCH_IN_TABLE,String.valueOf(indexColumn) ,cellValue);
		clickToElement(driver, AdminPostSearchPageUI.VALUE_INDEX_ROW_SEARCH_IN_TABLE,String.valueOf(indexColumn) ,cellValue);
		return PageGeneratorManager.getAdminCreatePostNewPage(driver);
	}

	public void clickToCheckboxPost(String editTitlePost) {
		waitForElementClickable(driver, AdminPostSearchPageUI.CHECKBOX_TITLE_POST,editTitlePost);
		checkToDefaultCheckboxRadio(driver, AdminPostSearchPageUI.CHECKBOX_TITLE_POST,editTitlePost);	
	}


	public void clickToItemInDropdown(String itemValue) {
		waitForElementClickable(driver, AdminPostSearchPageUI.DROPDOWN_BULK_ACTIONS);
		selecItemInDefaultDropdown(driver, AdminPostSearchPageUI.DROPDOWN_BULK_ACTIONS, itemValue);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
	}

	public boolean isDisplayDeleteMessageSuccess(String valueMessage) {
		waitForElementVisible(driver, AdminPostSearchPageUI.RETURN_MESSAGE, valueMessage);
		return isElementDisplay(driver, AdminPostSearchPageUI.RETURN_MESSAGE, valueMessage);
	}

	public boolean isDisplayMessageAfterDeletePost(String messageNotFoundPost) {
		waitForElementVisible(driver, AdminPostSearchPageUI.POST_NOT_FOUND, messageNotFoundPost);
		return isElementDisplay(driver, AdminPostSearchPageUI.POST_NOT_FOUND, messageNotFoundPost);
	}

	
	


}
