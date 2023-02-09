package pageObjectsFactoryNopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage_Factory;

public class LoginPageObjectFactory extends BasePage_Factory {
	private WebDriver driver;
	
	public LoginPageObjectFactory(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	private WebElement LOGIN_BUTTON;
	
	@FindBy(xpath="//a[@class='ico-login']")
	private WebElement LOGIN_LINK;
	
	@FindBy(id="Email")
	private WebElement EMAIL_INPUT;
	
	@FindBy(id="Password")
	private WebElement PASSWORD_INPUT;
	
	@FindBy(id="Email-error")
	private WebElement GET_MESSAGE_WRONG_EMAIL;
	
	@FindBy(xpath="//div[contains(@class,'message-error')]")
	private WebElement GET_MESSAGE_ERROR_EMAIL;
	
	public void clickToLoginButton() {
		waitForElementClickable(driver,LOGIN_BUTTON);
		clickToElement(driver, LOGIN_BUTTON);	
	}
	
	public void clickToLoginLink() {
		waitForElementClickable(driver, LOGIN_LINK);
		clickToElement(driver, LOGIN_LINK);
		
	}
	
	public void sendkeyToEmail(String email) {
		sendkeyToElement(driver, EMAIL_INPUT, email);
		
	}
	public void sendkeyToPassword(String password) {
		sendkeyToElement(driver, PASSWORD_INPUT, password);
		
	}

	public String getMessageErrorEmail() {
		waitForElementVisible(driver, GET_MESSAGE_WRONG_EMAIL);
		return getTextElement(driver, GET_MESSAGE_WRONG_EMAIL);
	}

	public String getErrorAccount() {
		waitForElementVisible(driver, GET_MESSAGE_ERROR_EMAIL);
		return getTextElement(driver, GET_MESSAGE_ERROR_EMAIL);
	}
	
	

}
