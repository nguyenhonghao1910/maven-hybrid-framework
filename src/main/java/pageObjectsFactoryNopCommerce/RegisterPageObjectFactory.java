package pageObjectsFactoryNopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage_Factory;

public class RegisterPageObjectFactory extends BasePage_Factory {
	
private WebDriver driver;
	
	public RegisterPageObjectFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id= "register-button")
	private WebElement REGISTER_BUTTON;
	
	@FindBy(xpath ="//a[@class='ico-register']")
	private WebElement REGISTER_CLICK;
	
	@FindBy(id= "FirstName")
	private WebElement FIRSTNAME_TEXT;
	
	@FindBy(id= "LastName")
	private WebElement LASTNAME_TEXT;
	
	@FindBy(id="Email")
	private WebElement EMAIL_TEXT;
	
	@FindBy(id="Password")
	private WebElement PASSWORD_TEXT;
	
	@FindBy(id="ConfirmPassword")
	private WebElement CONFIRMPASSWORD_TEXT;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	private WebElement BUTTON_LOGOUT;
	
	@FindBy(xpath="//div[contains(@class,'message-error ')]//li")
	private WebElement EMAIL_EXIST_TEXT;
	
	@FindBy(id="FirstName-error")
	private WebElement ERROR_FIRSTNAME_TEXT;
	
	@FindBy(id="LastName-error")
	private WebElement ERROR_LASTTNAME_TEXT;
	
	@FindBy(id="Email-error")
	private WebElement ERROR_EMAIL_TEXT;
	
	@FindBy(id="Password-error")
	private WebElement ERROR_PASSWORD_TEXT;
	
	@FindBy(id="ConfirmPassword-error")
	private WebElement ERROR_CONFIRM_PASSWORD_TEXT;
	
	@FindBy(xpath="//div[@class='result']")
	private WebElement REGISTER_SUCCESS_TEXT;
	
	
	
	public void clickToResgisterButton() {
		
		waitForElementClickable(driver, REGISTER_BUTTON);
		clickToElement(driver, REGISTER_BUTTON);
		
	}
	
	public void clickToRegister() {
		waitForElementClickable(driver, REGISTER_CLICK);
		clickToElement(driver, REGISTER_CLICK);
		
	}
	
	public void sendkeyToFirstname(String Firstname) {
		sendkeyToElement(driver, FIRSTNAME_TEXT , Firstname);
		
	}
	public void sendkeyToLastname(String Lastname) {
		sendkeyToElement(driver, LASTNAME_TEXT , Lastname);
		
	}
	public void sendkeyToEmail(String Email) {
		sendkeyToElement(driver, EMAIL_TEXT , Email);
		
	}
	public void sendkeyToPassword(String Password) {
		sendkeyToElement(driver, PASSWORD_TEXT , Password);
		
	}
	public void sendkeyToConfirmPassword(String ConfirmPassword) {
		sendkeyToElement(driver, CONFIRMPASSWORD_TEXT , ConfirmPassword);
		
	}
	

	public void clickToLogout() {
		waitForElementClickable(driver, BUTTON_LOGOUT);
		clickToElement(driver, BUTTON_LOGOUT);
		
	}
	public String getEmailExist() {
		waitForElementVisible(driver,EMAIL_EXIST_TEXT);
		return getElementText(driver, EMAIL_EXIST_TEXT);
	}

	public String getMessageErrorFirstname() {
		waitForElementVisible(driver,ERROR_FIRSTNAME_TEXT);
		return getElementText(driver,ERROR_FIRSTNAME_TEXT);
	}
	public String getMessageErrorLastname() {
		waitForElementVisible(driver,ERROR_LASTTNAME_TEXT);
		return getElementText(driver,ERROR_LASTTNAME_TEXT);
	}
	public String getMessageErrorEmail() {
		waitForElementVisible(driver, ERROR_EMAIL_TEXT);
		return getElementText(driver, ERROR_EMAIL_TEXT);
	}
	public String getMessageErrorPassword() {
		waitForElementVisible(driver, ERROR_PASSWORD_TEXT);
		return getElementText(driver, ERROR_PASSWORD_TEXT);
	}
	public String getMessageErrorConfirmPassword() {
		waitForElementVisible(driver,ERROR_CONFIRM_PASSWORD_TEXT);
		return getElementText(driver,ERROR_CONFIRM_PASSWORD_TEXT);
	}
	public String getRegisterSuccess() {
		waitForElementVisible(driver,REGISTER_SUCCESS_TEXT);
		return getElementText(driver,REGISTER_SUCCESS_TEXT);
	}
	

}
