package pageObjects.FacebookLogin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public LoginPageObject (WebDriver driver) {
		this.driver=driver;
	}
	public void clickToButtonCreateAccount() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}
	public void inputEmailAddressTextbox(String value) {
		waitForElementVisible(driver, LoginPageUI.INPUT_VALUE_EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.INPUT_VALUE_EMAIL_ADDRESS_TEXTBOX, value);
	}
	public boolean reEnterEmailAddressisDisplayed() {
		waitForElementVisible(driver, LoginPageUI.INPUT_VALUE_RE_ENTER_EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplay(driver, LoginPageUI.INPUT_VALUE_RE_ENTER_EMAIL_ADDRESS_TEXTBOX);
	}
	public boolean reEnterEmailAddressUndisplayed() {
		return isElementUndisplayed(driver, LoginPageUI.INPUT_VALUE_RE_ENTER_EMAIL_ADDRESS_TEXTBOX);
	}
	public void clickCloseIconRegister() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON_REGISTER);
		clickToElement(driver, LoginPageUI.CLOSE_ICON_REGISTER);
	}	

}
	
