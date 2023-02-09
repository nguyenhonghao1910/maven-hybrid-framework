package pageObject.SauceLab.Sort;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.SauceLab.Sort.LoginPageUI;


public class LoginPO extends BasePage {
	WebDriver driver;
	
	public LoginPO (WebDriver driver) {
		this.driver=driver;
		
	}

	public void inputToUserNameTextbox(String username) {
		waitForElemenInVisible(driver, LoginPageUI.INPUT_USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.INPUT_USERNAME_TEXTBOX, username);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElemenInVisible(driver, LoginPageUI.INPUT_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.INPUT_PASSWORD_TEXTBOX, password);
		
	}

	public HomePO clickToButtonLogin() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
		
	}
	
	
	
	
	

}
