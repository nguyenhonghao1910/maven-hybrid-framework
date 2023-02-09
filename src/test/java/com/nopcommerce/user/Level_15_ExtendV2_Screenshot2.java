package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import pageObjects.NopCommerce.User.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Level_15_ExtendV2_Screenshot2 extends BaseTest {


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

/*  @Test
  public void User_01_Register (Method method) {
	  
	  ExtentTestManager.startTest(method.getName(), "User_01_Register");
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 01: Open Register page");
	  registerPage = homePage.clickToRegister();
	    
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 02: Enter to Firstname textbox with value is '" + Firstname + "'");
	  registerPage.sendkeyToFirstname(Firstname);
		
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 03: Enter to Lastname textbox with value is '" + Lastname + "'");
	  registerPage.sendkeyToLastname(Lastname);
		
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 04: Enter to Email textbox with value is '" + Email + "'");
	  registerPage.sendkeyToEmail(Email);
		
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 05: Enter to Password textbox with value is '" + Password + "'");
	  registerPage.sendkeyToPassword(Password);
		
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 06: Enter to Confirm Password textbox with value is '" + Password + "'");
	  registerPage.sendkeyToConfirmPassword(Password);
		
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 07: Click to 'Register' button ");
	  registerPage.clickToResgisterButton();
		
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 08: Verify register message is displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccess(), "Your registration completed..");
	  ExtentTestManager.endTest();
	  
  }
  
  @Test
  public void User_02_Login (Method method) {
	  
	  ExtentTestManager.startTest(method.getName(), "User_02_Login");
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Register_Account-Step 09: Click to Logout link ");
	  homePage = registerPage.clickToLogout();
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Login_Account-Step 01: Navigate to Login page ");
	  loginPage =  homePage.clickToLoginLink();
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO,"Login_Account-Step 02: Enter to Firstname textbox with value is '" + Email + "'");
      loginPage.sendkeyToEmail(Email);
      
      ExtentTestManager.getTest().log(LogStatus.INFO,"Login_Account-Step 03: Enter to Firstname textbox with value is '" + Password + "'");
      loginPage.sendkeyToPassword(Password);

      ExtentTestManager.getTest().log(LogStatus.INFO,"Login_Account-Step 04: Click to Login button ");
      homePage = loginPage.clickToLoginButton();
      
      ExtentTestManager.getTest().log(LogStatus.INFO,"Login_Account-Step 05: Verify 'My Account' link is displayed ");
      Assert.assertFalse(homePage.isMyAccountDisplay());
      
      ExtentTestManager.getTest().log(LogStatus.INFO,"Login_Account-Step 06: Navigate to 'My Account' page ");
      customerPage = homePage.openMyAccount();
      
      ExtentTestManager.getTest().log(LogStatus.INFO,"Login_Account-Step 07: Verify 'Customer Infor' page is displayed ");
      Assert.assertFalse(customerPage.isCustomerInfoDisplay());
      ExtentTestManager.endTest();
  }
  */
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
