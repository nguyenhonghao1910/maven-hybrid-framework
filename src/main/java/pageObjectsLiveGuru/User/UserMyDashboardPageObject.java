package pageObjectsLiveGuru.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsLiveGuru.User.UserMyDashboardPageUI;

public class UserMyDashboardPageObject extends BasePage {
	private WebDriver driver;

	public UserMyDashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public String returnMessageRegisterIsSuccess() {
		waitForElementVisible(driver, UserMyDashboardPageUI.REGISTER_IS_SUCCESS);
		return getTextElement(driver, UserMyDashboardPageUI.REGISTER_IS_SUCCESS);
	}

	public UserHomePageObject clickToLogoutButton() {
		waitForElementClickable(driver, UserMyDashboardPageUI.LOGOUT_BUTTON);
		clickToElement(driver, UserMyDashboardPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
	

	public void clickToAccountButton() {
		waitForElementClickable(driver, UserMyDashboardPageUI.ACCOUNT_BUTTON);
		clickToElement(driver, UserMyDashboardPageUI.ACCOUNT_BUTTON);
		
	}

	public String returnMessageLoginIsSuccess() {
		waitForElementVisible(driver, UserMyDashboardPageUI.LOGIN_IS_SUCCESS);
		return getTextElement(driver, UserMyDashboardPageUI.LOGIN_IS_SUCCESS);
	}


}
