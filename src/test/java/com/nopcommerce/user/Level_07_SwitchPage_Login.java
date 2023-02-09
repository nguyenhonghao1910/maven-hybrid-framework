package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.NopCommerce.User.UserAddressPageObject;
import pageObjects.NopCommerce.User.UserCustomerPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserOrdersPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import pageObjects.NopCommerce.User.UserRewardpointsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_SwitchPage_Login extends BaseTest {


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Firstname ="Tester";
		Lastname ="Automation";
		Email = "abc" + randomNumber() + "@mail.vn" ;
		Password ="123456";		
	}

  @Test
  public void User_01_Register () {

	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  System.out.println("Register_Account-Step 01:clickToRegister");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Register_Account-Step 02:input value");
		registerPage.sendkeyToFirstname(Firstname);
		registerPage.sendkeyToLastname(Lastname);
		registerPage.sendkeyToEmail(Email);
		registerPage.sendkeyToPassword(Password);
		registerPage.sendkeyToConfirmPassword(Password);
		System.out.println("Register_Account-Step 03:clickToResgisterButton");
		registerPage.clickToResgisterButton();
		  
		System.out.println("Register_Account-Step 04:verify return message");
		Assert.assertEquals(registerPage.getRegisterSuccess(), "Your registration completed");
	
		homePage = registerPage.clickToLogoutLink();
	    

  }
  
  @Test
  public void User_02_Login() {
	  
	  loginPage =  homePage.clickToLoginLink();
	  System.out.println("Login_06-Step 01:clickToLogin");
	  loginPage.clickToLoginLink();
	  
      System.out.println("Login_06-Step 02:input value");
      loginPage.sendkeyToEmail(Email);
      loginPage.sendkeyToPassword(Password);


      System.out.println("Login_06-Step 03:clickToLoginButton");
      homePage = loginPage.clickToLoginButton();
	  
	  System.out.println("Login_06-Step 04:Login_Success");
	  Assert.assertTrue(homePage.isMyAccountDisplay());
	   
	   
  }
  
  @Test
  public void User_03_My_Account() {
	  customerPage = homePage.openMyAccount();
	  System.out.println("User_03-Step 01:ClickToMyAccount");
	  Assert.assertTrue(customerPage.isCustomerInfoDisplay());
	  
  }
 
  @Test
  public void User_04_Switch_Page() {
	  
	  System.out.println("User_04-Step 01:OpenAddressPageFromCustomerInfoPage");
	  addressPage = customerPage.openAddressPage(driver);
	  
	  System.out.println("User_04-Step 02:OpenOrdersPageFromAddressPage");
	  ordersPage = addressPage.openOrdersPage(driver);
	  
	  System.out.println("User_04-Step 03:OpenRewardpointsPageFromOrdersPage");
	  rewardpointsPage = ordersPage.openRewardpointsPage(driver);
	  
	  System.out.println("User_04-Step 04:OpenCustomerInfoPageFromRewardpointsPage");
	  customerPage = rewardpointsPage.openCustomerinfoPage(driver); 
	  
	  System.out.println("User_04-Step 05:OpenRewardpointsPageFromCustomerInfoPage");
	  rewardpointsPage = customerPage.openRewardpointsPage(driver); 
	  

  }
  @Test
  public void User_05_Switch_Role() {
	  
	  
  }

 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
	private WebDriver driver;
	private String Email,Firstname, Lastname,Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerPageObject customerPage;
	private UserAddressPageObject addressPage;
	private UserOrdersPageObject ordersPage;
	private UserRewardpointsPageObject rewardpointsPage;
	


}
