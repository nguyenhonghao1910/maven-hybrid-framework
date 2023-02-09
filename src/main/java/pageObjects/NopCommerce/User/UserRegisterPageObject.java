package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.NopCommerce.User.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to Register Button")
	public void clickToResgisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		
	}
	
	@Step("Click to Register Link")
	public void clickToRegister() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_CLICK);
		clickToElement(driver, UserRegisterPageUI.REGISTER_CLICK);
		
	}
	
	@Step("Enter to Firstname textbox with value is {0}")
	public void sendkeyToFirstname(String Firstname) {
		waitForElemenInVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXT , Firstname);
	}
	
	@Step("Enter to Lastname textbox with value is {0}")
	public void sendkeyToLastname(String Lastname) {
		waitForElemenInVisible(driver, UserRegisterPageUI.LASTNAME_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXT , Lastname);
	}
	
	@Step("Enter to Email textbox with value is {0}")
	public void sendkeyToEmail(String Email) {
		waitForElemenInVisible(driver, UserRegisterPageUI.EMAIL_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXT , Email);
		
	}
	
	@Step("Enter to Password textbox with value is {0}")
	public void sendkeyToPassword(String Password) {
		waitForElemenInVisible(driver, UserRegisterPageUI.PASSWORD_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT , Password);
		
	}
	
	@Step("Enter to ConfirmPassword textbox with value is {0}")
	public void sendkeyToConfirmPassword(String ConfirmPassword) {
		waitForElemenInVisible(driver, UserRegisterPageUI.CONFIRMPASSWORD_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRMPASSWORD_TEXT , ConfirmPassword);
		
	}
	
	@Step("Click to Button logout")
	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.BUTTON_LOGOUT);
		clickToElement(driver, UserRegisterPageUI.BUTTON_LOGOUT);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}
	public String getEmailExist() {
		waitForElemenInVisible(driver, UserRegisterPageUI.EMAIL_EXIST_TEXT);
		return getElementText(driver, UserRegisterPageUI.EMAIL_EXIST_TEXT);
	}

	public String getMessageErrorFirstname() {
		waitForElemenInVisible(driver, UserRegisterPageUI.ERROR_FIRSTNAME_TEXT);
		return getElementText(driver, UserRegisterPageUI.ERROR_FIRSTNAME_TEXT);
	}
	public String getMessageErrorLastname() {
		waitForElemenInVisible(driver, UserRegisterPageUI.ERROR_LASTTNAME_TEXT);
		return getElementText(driver, UserRegisterPageUI.ERROR_LASTTNAME_TEXT);
	}
	public String getMessageErrorEmail() {
		waitForElemenInVisible(driver, UserRegisterPageUI.ERROR_EMAIL_TEXT);
		return getElementText(driver, UserRegisterPageUI.ERROR_EMAIL_TEXT);
	}
	public String getMessageErrorPassword() {
		waitForElemenInVisible(driver, UserRegisterPageUI.ERROR_PASSWORD_TEXT);
		return getElementText(driver, UserRegisterPageUI.ERROR_PASSWORD_TEXT);
	}
	public String getMessageErrorConfirmPassword() {
		waitForElemenInVisible(driver, UserRegisterPageUI.ERROR_CONFIRM_PASSWORD_TEXT);
		return getElementText(driver, UserRegisterPageUI.ERROR_CONFIRM_PASSWORD_TEXT);
	}
	public String getRegisterSuccess() {
		waitForElemenInVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_TEXT);
	}





	
	}



