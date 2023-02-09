package pageObjectsLiveGuru.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsLiveGuru.User.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public UserMyDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}


	public void sendkeyToFirstName(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver,  UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void sendkeyToLastName(String lastName) {
		sendkeyToElement(driver,  UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void sendkeyToEmailAddress(String EmailAddress) {
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, EmailAddress);
		
	}

	public void sendkeyToPassword(String Password) {
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, Password);
		
	}

	public void sendkeyToComfirmPassword(String ComfirmPassword) {
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, ComfirmPassword);
		
	}



}
