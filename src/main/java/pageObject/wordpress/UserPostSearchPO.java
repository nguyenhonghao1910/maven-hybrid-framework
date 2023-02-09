package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostSearchPageUI;

public class UserPostSearchPO extends BasePage {
	
	WebDriver driver;

	public UserPostSearchPO (WebDriver driver) {
		this.driver=driver;
	}

	public boolean isDisplayDeleteSuccess(String messageNotFound) {
		waitForElementVisible(driver, UserPostSearchPageUI.MESSAGE_NOTHING_FOUND, messageNotFound);
		return isElementDisplay(driver, UserPostSearchPageUI.MESSAGE_NOTHING_FOUND, messageNotFound);
	}

}
