package pageObject.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.BasePageHrmUI;
import pageUIs.hrm.MyInfoPageUI;

public class MyInfoPO extends BasePage {
	WebDriver driver;
	
	public MyInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangeAvatar() {
		waitForElementClickable(driver, MyInfoPageUI.ICON_AVATAR);
		clickToElement(driver, MyInfoPageUI.ICON_AVATAR);
		
	}

	public Boolean isDisplayNewImageAfterUpload() {
		waitForElemenInVisible(driver, MyInfoPageUI.ICON_AVATAR);
		int width=Integer.parseInt(getElementAttribute(driver, MyInfoPageUI.ICON_AVATAR, "width"));
		int height=Integer.parseInt(getElementAttribute(driver, MyInfoPageUI.ICON_AVATAR, "height"));
		return (width !=200 || height !=200 ) ; 
	}


	public boolean isFieldEnableByName(WebDriver driver, String fieldByID) {
		waitForElementVisible(driver, BasePageHrmUI.ANY_FIELD_BY_ID, fieldByID);
		return isElementEnable(driver, BasePageHrmUI.ANY_FIELD_BY_ID, fieldByID);
	}






}
