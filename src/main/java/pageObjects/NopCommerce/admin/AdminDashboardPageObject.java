package pageObjects.NopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.Admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver=driver;
}
	public boolean isAdminMyDashboardDisplay() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementEnable(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

}
