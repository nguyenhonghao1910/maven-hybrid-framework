package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {

	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver=driver;
	}

	public AdminPostSearchPO clickToPostSearchPage() {
		waitForElementClickable(driver,AdminDashboardPageUI.POSTS_PAGE);
		clickToElement(driver,AdminDashboardPageUI.POSTS_PAGE);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

}
