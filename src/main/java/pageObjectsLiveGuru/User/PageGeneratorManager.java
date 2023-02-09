package pageObjectsLiveGuru.User;

import org.openqa.selenium.WebDriver;
import pageObjectsLiveGuru.Admin.AdminLoginPageObject;
import pageObjectsLiveGuru.Admin.AdminManageCustomerPageObject;

public class PageGeneratorManager {
	
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserMyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new UserMyDashboardPageObject(driver);
	
	}
	
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
    }
	public static AdminManageCustomerPageObject getAdminManagerCustomerPage(WebDriver driver){
		return new AdminManageCustomerPageObject(driver);
	}
}
