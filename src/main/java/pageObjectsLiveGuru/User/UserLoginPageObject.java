package pageObjectsLiveGuru.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsLiveGuru.User.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public UserRegisterPageObject clickToCreateAnAccount() {
		waitForElementVisible(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);
		
	}

	public UserMyDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}

	public void sendkeyEmailTextbox(String EmailAddress) {
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, EmailAddress);
		
	}

	public void sendkeyPasswordTextbox(String Password) {
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, Password);
		
	}


	


}
