package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.User.UserCustomerPageUI;

public class UserCustomerPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public boolean isCustomerInfoDisplay() {
		waitForElementVisible(driver, UserCustomerPageUI.CUSTOMER_INFO);
		return isElementDisplay(driver, UserCustomerPageUI.CUSTOMER_INFO);
	}








}
