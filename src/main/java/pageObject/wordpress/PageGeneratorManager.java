package pageObject.wordpress;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
		
	}
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver) ;
	}

	public static AdminCreatePostNewPO getAdminCreatePostNewPage(WebDriver driver) {
		return new AdminCreatePostNewPO(driver);
	}

	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}

	public static UserPostDetailPO getUserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPO(driver);
	}

	public static UserPostSearchPO getUserPostSearchPage(WebDriver driver) {
		return new UserPostSearchPO(driver);
	}



	

}
