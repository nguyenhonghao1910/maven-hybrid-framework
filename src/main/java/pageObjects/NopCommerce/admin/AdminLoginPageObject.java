package pageObjects.NopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.Admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver=driver;
}
	public void inputEmail(String AdminEmail) {
		waitForElementVisible(driver,AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, AdminEmail);
	}
	
	public void inputPassword(String AdminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, AdminPassword);
	}
	
	public AdminDashboardPageObject clickButtonLogin() {
		waitForElementClickable(driver, AdminLoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, AdminLoginPageUI.BUTTON_LOGIN);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	public AdminDashboardPageObject loginDashboardPage(String AdminEmail,String AdminPassword) {
		inputEmail(AdminEmail);
		inputPassword(AdminPassword);
		return clickButtonLogin();
	}
	
	
	

	
}
