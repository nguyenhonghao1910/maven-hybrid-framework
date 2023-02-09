package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.User.*;

import java.util.concurrent.TimeUnit;

public class Level_15_ReprotNG_Screenshot extends BaseTest {


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		Firstname ="Tester";
		Lastname ="Automation";
		Email = "abc" + randomNumber() + "@mail.vn" ;
		Password ="123456";		
	}

  @Test
  public void User_01_Register () {
	  
	  
	    log.info("Register_Account-Step 01: Open Register page");
	    registerPage = homePage.clickToRegisterLink();
	    
	    log.info("Register_Account-Step 02: Enter to Firstname textbox with value is '" + Firstname + "'");
		registerPage.sendkeyToFirstname(Firstname);
		
		log.info("Register_Account-Step 03: Enter to Lastname textbox with value is '" + Lastname + "'");
		registerPage.sendkeyToLastname(Lastname);
		
		log.info("Register_Account-Step 04: Enter to Email textbox with value is '" + Email + "'");
		registerPage.sendkeyToEmail(Email);
		
		log.info("Register_Account-Step 05: Enter to Password textbox with value is '" + Password + "'");
		registerPage.sendkeyToPassword(Password);
		
		log.info("Register_Account-Step 06: Enter to Confirm Password textbox with value is '" + Password + "'");
		registerPage.sendkeyToConfirmPassword(Password);
		
		log.info("Register_Account-Step 07: Click to 'Register' button ");
		registerPage.clickToResgisterButton();
		
		log.info("Register_Account-Step 08: Verify register message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccess(), "Your registration completed..");
		
		
		
  }
  
  @Test
  public void User_02_Login () {
	  
	  log.info("Register_Account-Step 09: Click to Logout link ");
	  homePage = registerPage.clickToLogoutLink();
	  
	  log.info("Login_Account-Step 01: Navigate to Login page ");
	  loginPage =  homePage.clickToLoginLink();
	  
	  log.info("Login_Account-Step 02: Enter to Firstname textbox with value is '" + Email + "'");
      loginPage.sendkeyToEmail(Email);
      
      log.info("Login_Account-Step 03: Enter to Firstname textbox with value is '" + Password + "'");
      loginPage.sendkeyToPassword(Password);

      log.info("Login_Account-Step 04: Click to Login button ");
      homePage = loginPage.clickToLoginButton();
      
      log.info("Login_Account-Step 05: Verify 'My Account' link is displayed ");
      Assert.assertFalse(homePage.isMyAccountDisplay());
      
      log.info("Login_Account-Step 06: Navigate to 'My Account' page ");
      customerPage = homePage.openMyAccount();
      
      log.info("Login_Account-Step 07: Verify 'Customer Infor' page is displayed ");
      Assert.assertFalse(customerPage.isCustomerInfoDisplay());
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

}
