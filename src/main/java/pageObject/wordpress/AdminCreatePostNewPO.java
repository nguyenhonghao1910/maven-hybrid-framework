package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminCreatePostNewPageUI;

public class AdminCreatePostNewPO extends BasePage {
	
	 WebDriver driver;

	public AdminCreatePostNewPO(WebDriver driver) {
		this.driver=driver;
	}

	public void inputValueInTitlePost(String textValueTitle) {
		waitForElementVisible(driver, AdminCreatePostNewPageUI.TITLE_POST_TEXTBOX);
		sendkeyToElement(driver, AdminCreatePostNewPageUI.TITLE_POST_TEXTBOX, textValueTitle);
		
	}

	public void inputValueInBodyPost(String textValueBody) {
		waitForElementClickable(driver, AdminCreatePostNewPageUI.BODY_POST_BEFORE_SENDKEY);
		clickToElement(driver, AdminCreatePostNewPageUI.BODY_POST_BEFORE_SENDKEY);
		
		waitForElementVisible(driver, AdminCreatePostNewPageUI.BODY_POST_SENDKEY);
		sendkeyToElement(driver, AdminCreatePostNewPageUI.BODY_POST_SENDKEY, textValueBody);
		
	}

	public void clickToButtonPrePublish() {
		waitForElementClickable(driver, AdminCreatePostNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminCreatePostNewPageUI.PRE_PUBLISH_BUTTON);
		
	}
	
	public void clickToButtonPublish() {
		waitForElementClickable(driver, AdminCreatePostNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminCreatePostNewPageUI.PUBLISH_BUTTON);
		
	}

	public boolean isDisplayCreatePostSuccess(String messageValue) {
		waitForElementVisible(driver, AdminCreatePostNewPageUI.RETURN_PUBLISHED_AND_UPDATE_MESSAGE, messageValue);
		return isElementDisplay(driver, AdminCreatePostNewPageUI.RETURN_PUBLISHED_AND_UPDATE_MESSAGE, messageValue);
	}

	public void editValueInBodyPost(String editBodyPost) {
		waitForElementClickable(driver, AdminCreatePostNewPageUI.BODY_POST_SENDKEY);
		clickToElement(driver, AdminCreatePostNewPageUI.BODY_POST_SENDKEY);
		
		waitForElementVisible(driver, AdminCreatePostNewPageUI.BODY_POST_SENDKEY);
		clearValueInElementByDeleteKey(driver, AdminCreatePostNewPageUI.BODY_POST_SENDKEY);
		sendkeyToElement(driver, AdminCreatePostNewPageUI.BODY_POST_SENDKEY, editBodyPost);
		
	}

	public void clickToPopup() {
		waitForElementVisible(driver, AdminCreatePostNewPageUI.POPUP_CREATE_POST);
		clickToElement(driver, AdminCreatePostNewPageUI.POPUP_CREATE_POST);
	}


}
