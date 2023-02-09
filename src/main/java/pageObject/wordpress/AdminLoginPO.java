package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminLoginPageUI;

public class AdminLoginPO  extends BasePage{
	
	 WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver=driver;
	}

	public void inputValueUserNameTextbox(String userName) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME);
		sendkeyToElement(driver, AdminLoginPageUI.USERNAME, userName);
		
	}

	public void inputValuePasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD, password);
		
	}

	public AdminDashboardPO clickToButtonLogin() {
		waitForElementClickable(driver, AdminLoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, AdminLoginPageUI.BUTTON_LOGIN);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	

}
