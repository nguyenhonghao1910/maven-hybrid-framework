package pageObjectsLiveGuru.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsLiveGuru.User.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		 this.driver=driver;	
	}

	public UserLoginPageObject clickToMyAccountLink() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getLoginPage(driver);
		
		
	}
	
	

}
