package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.NopCommerce.User.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@Step("Navigate to Register page")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_HOME);
		clickToElement(driver, UserHomePageUI.REGISTER_HOME);
		return  PageGeneratorManager.getUserRegisterPage(driver);
	}
	
	@Step("Navigate to Login page")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_HOME);
		clickToElement(driver, UserHomePageUI.LOGIN_HOME);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	@Step("Verify 'My Account' link to Displayed")
	public boolean isMyAccountDisplay() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_HOME);
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_HOME);
	}
	
	@Step("Navigate to My Account page")
	public UserCustomerPageObject openMyAccount() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_HOME);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_HOME);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}


		
	}



	//chứa những action của page này
	//click và button ( search)
	//sendkey vào textbox (username)


