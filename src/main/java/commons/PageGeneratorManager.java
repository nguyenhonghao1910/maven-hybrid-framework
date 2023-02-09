package commons;

import org.openqa.selenium.WebDriver;

import pageObject.SauceLab.Sort.LoginPO;
import pageObjects.NopCommerce.User.UserCustomerPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserOrdersPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import pageObjects.NopCommerce.User.UserRewardpointsPageObject;
import pageObjects.NopCommerce.admin.AdminDashboardPageObject;
import pageObjects.NopCommerce.admin.AdminLoginPageObject;
import pageObjects.NopCommerce.User.UserAddressPageObject;

public class PageGeneratorManager {

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserCustomerPageObject getUserCustomerPage (WebDriver driver) {
		return new UserCustomerPageObject(driver);
		
	}
	
	public static UserAddressPageObject getUserAddressPage (WebDriver driver) {
		return new UserAddressPageObject(driver);
		
	}
	public static UserRewardpointsPageObject getUserRewardpointsPage (WebDriver driver) {
		return new UserRewardpointsPageObject(driver);
		
	}
	public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new  UserHomePageObject(driver);
	}


	

}
