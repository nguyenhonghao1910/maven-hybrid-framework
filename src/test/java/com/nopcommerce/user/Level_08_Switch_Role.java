package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.NopCommerce.User.UserAddressPageObject;
import pageObjects.NopCommerce.User.UserCustomerPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserOrdersPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import pageObjects.NopCommerce.User.UserRewardpointsPageObject;
import pageObjects.NopCommerce.admin.AdminDashboardPageObject;
import pageObjects.NopCommerce.admin.AdminLoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Switch_Role extends BaseTest {


	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(String browsername , String environmentName) {
		driver = getBrowserDriver(browsername, environmentName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Email = "Testabc@hotmail.com" ;
		Password ="123456";	
		AdminEmail="admin@yourstore.com";
		AdminPassword="admin";
	}

  @Test
  public void Role_01_Page_User_To_Admin () {
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  userLoginPage =  userHomePage.clickToLoginLink();
      userHomePage = userLoginPage.loginMyaccount(Email, Password);
      
      System.out.println("Login_01-Step 02:Login_Success");
	  Assert.assertTrue(userHomePage.isMyAccountDisplay());
	  //customerPage = homePage.openMyAccount();
	  userHomePage.clickToLogoutLinkAtUserPage(driver);
	  
	  userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_NOPCOMMERCE_URL_TESTING);
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  adminDashboardPage = adminLoginPage.loginDashboardPage(AdminEmail, AdminPassword);
	  System.out.println("Login_02-:Login_Success_Display_MyDashboard");
	  Assert.assertTrue(adminDashboardPage.isAdminMyDashboardDisplay());
	  adminLoginPage  = adminDashboardPage.clickToLogoutLinkAdminPage(driver);

  }
  
  @Test
  public void Role_02_Page_Admin_To_User() {
	  adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_NOPCOMMERCE_URL_TESTING);
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  userLoginPage =  userHomePage.clickToLoginLink();
      userHomePage = userLoginPage.loginMyaccount(Email, Password);
      System.out.println("Role_02:Login_Success");
	  Assert.assertTrue(userHomePage.isMyAccountDisplay());
	  
      userHomePage.clickToLogoutLinkAtUserPage(driver);
   
  }


 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
	private WebDriver driver;
	private String Email,Password,AdminEmail,AdminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

}


 
