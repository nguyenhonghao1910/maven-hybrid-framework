package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.User.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public void clickToLoginLink() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_LINK);
		clickToElement(driver, UserLoginPageUI.LOGIN_LINK);
		
	}
	
	public void sendkeyToEmail(String Email) {
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_INPUT, Email);
		
	}
	public void sendkeyToPassword(String Password) {
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_INPUT, Password);
		
	}

	public String getMessageErrorEmail() {
		waitForElementVisible(driver, UserLoginPageUI.GET_MESSAGE_WRONG_EMAIL);
		return getTextElement(driver, UserLoginPageUI.GET_MESSAGE_WRONG_EMAIL);
	}

	public String getErrorAccount() {
		waitForElemenInVisible(driver, UserLoginPageUI.GET_MESSAGE_ERROR_EMAIL);
		return getTextElement(driver, UserLoginPageUI.GET_MESSAGE_ERROR_EMAIL);
	}
	
	public UserHomePageObject loginMyaccount (String Email,String Password) {
		sendkeyToEmail(Email);
		sendkeyToPassword(Password);
		return clickToLoginButton();
		
	}







}
