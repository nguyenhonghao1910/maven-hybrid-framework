package com.nopcommerce.user;

import org.testng.annotations.Test;


import commons.BaseTest;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;



public class Level_04_Page_Object_02_Login_Multiple_Browser extends BaseTest {
	private WebDriver driver;
	private String Email,EmailNotExist,InvalidEmail ,Firstname, Lastname,Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	@Parameters ("browser")
	
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		
		Firstname ="Tester";
		Lastname ="Automation";
		Email = "abc" + randomNumber() + "@mail.vn" ;
		InvalidEmail = "hoc";
		EmailNotExist = "abcd" + randomNumber() + "@mail.com";
		Password ="123456";
		homePage = new UserHomePageObject(driver);
		System.out.println("Register_Account-Step 01:clickToRegister");
		homePage.clickToRegisterLink();
		
		registerPage = new UserRegisterPageObject(driver);
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
	
		registerPage.clickToLogoutLink();
		
		homePage = new UserHomePageObject(driver);
	

	}

  @Test
  public void Login_01_Empty_Data () {
	  
	  System.out.println("Login_01-Step 01:clickToLogin");
	  homePage.clickToLoginLink();
	  
	  loginPage = new UserLoginPageObject(driver);
	  System.out.println("Login_01-Step 02:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_01-Step 03:verify return message");
	  Assert.assertEquals(loginPage.getMessageErrorEmail(), "Please enter your email");
	  	  
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  loginPage = new UserLoginPageObject(driver);
	  System.out.println("Login_02-Step 01:clickToLoginLink");
	  loginPage.clickToLoginLink();
	  
	  System.out.println("Login_02-Step 02:input value");
	  loginPage.sendkeyToEmail(InvalidEmail);
	  
	  System.out.println("Login_02-Step 03:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_02-Step 04:verify return message");
	  Assert.assertEquals(loginPage.getMessageErrorEmail(), "Wrong email");
	   
  }
  
  @Test
  public void Login_03_Email_Not_Exist() {
	  loginPage = new UserLoginPageObject(driver);
	  System.out.println("Login_03-Step 01:clickToLoginLink");
	  loginPage.clickToLoginLink();
	  
	  System.out.println("Login_03-Step 02:input email no exist");
	  loginPage.sendkeyToEmail(EmailNotExist);
	  loginPage.sendkeyToPassword(Password);
	 

	  System.out.println("Login_03-Step 03:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_03-Step 04:verify return message");
	  Assert.assertEquals(loginPage.getErrorAccount(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	 
	  
  }
 
  @Test
  public void Login_04_No_Input_Password() {
	  loginPage = new UserLoginPageObject(driver);
	  System.out.println("Login_04-Step 01:clickToRegister");
	  loginPage.clickToLoginLink();
	  
	  System.out.println("Login_04-Step 01:No_Input_Password");
	  loginPage.sendkeyToEmail(Email);

	 
	  System.out.println("Login_04-Step 03:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  
	  System.out.println("Login_04-Step 04:verify return message");
	  Assert.assertEquals(loginPage.getErrorAccount(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
	  
  }
  @Test
  public void Login_05_Wrong_Password() {
	  loginPage = new UserLoginPageObject(driver);
	  System.out.println("Login_05-Step 01:clickToLogin");
	  loginPage.clickToLoginLink();
	  
	  System.out.println("Login_05-Step 02:input value");
	  loginPage.sendkeyToEmail(Email);
	  loginPage.sendkeyToPassword("123457");


	  System.out.println("Login_05-Step 03:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_05-Step 04:verify return message");
	  Assert.assertEquals(loginPage.getErrorAccount(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  @Test
  public void Login_06_Success() {
	  loginPage = new UserLoginPageObject(driver);
	  System.out.println("Login_06-Step 01:clickToLogin");
	  loginPage.clickToLoginLink();
	  
      System.out.println("Login_06-Step 02:input value");
      loginPage.sendkeyToEmail(Email);
      loginPage.sendkeyToPassword(Password);


      System.out.println("Login_06-Step 03:clickToLoginButton");
      loginPage.clickToLoginButton();
	  
      homePage = new UserHomePageObject(driver);
	  System.out.println("Login_06-Step 04:Login_Success");
	  Assert.assertTrue(homePage.isMyAccountDisplay());
	  
	 
  }
 
 public int randomNumber () {
	 Random ran = new Random();
	 return ran.nextInt(9999);
 }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
