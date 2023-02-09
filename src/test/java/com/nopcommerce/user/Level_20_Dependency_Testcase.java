package com.nopcommerce.user;

import org.testng.annotations.Test;


import commons.BaseTest;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;



public class Level_20_Dependency_Testcase extends BaseTest {
	private WebDriver driver;
	private String Email,EmailNotExist,InvalidEmail,Password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	
	@Parameters ("browser")
	@BeforeMethod // chạy trước cho từng testcase
	public void beforeClass(String browsername) {
		Email = "abc" + randomNumber() + "@mail.vn" ;
		InvalidEmail = "hoc";
		EmailNotExist = "abcd" + randomNumber() + "@mail.com";
		Password ="123456";
		driver = getBrowserDriver(browsername);
		homePage = new UserHomePageObject(driver);
		homePage.clickToLoginLink();
		loginPage = new UserLoginPageObject(driver);
	
	}

  @Test
  public void Login_01_Empty_Data () {
	  
	  System.out.println("Login_01-Step 01:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_01-Step 02:verify return message");
	  Assert.assertEquals(loginPage.getMessageErrorEmail(), "Please enter your email");
	  	  
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  
	  System.out.println("Login_02-Step 01:input value");
	  loginPage.sendkeyToEmail(InvalidEmail);
	  
	  System.out.println("Login_02-Step 02:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_02-Step 03:verify return message");
	  Assert.assertEquals(loginPage.getMessageErrorEmail(), "Wrong email");
	   
  }
  
  @Test
  public void Login_03_Email_Not_Exist() {

	  System.out.println("Login_03-Step 01:input email no exist");
	  loginPage.sendkeyToEmail(EmailNotExist);
	  loginPage.sendkeyToPassword(Password);
	 

	  System.out.println("Login_03-Step 02:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_03-Step 03:verify return message");
	  Assert.assertEquals(loginPage.getErrorAccount(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	 
	  
  }
 
  @Test
  public void Login_04_No_Input_Password() {

	  System.out.println("Login_04-Step 01:No_Input_Password");
	  loginPage.sendkeyToEmail(Email);

	 
	  System.out.println("Login_04-Step 02:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  
	  System.out.println("Login_04-Step 03:verify return message");
	  Assert.assertEquals(loginPage.getErrorAccount(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	  
	  
  }
  @Test
  public void Login_05_Wrong_Password() {

	  System.out.println("Login_05-Step 01:input value");
	  loginPage.sendkeyToEmail(Email);
	  loginPage.sendkeyToPassword("123457");


	  System.out.println("Login_05-Step 02:clickToLoginButton");
	  loginPage.clickToLoginButton();
	  
	  System.out.println("Login_05-Step 03:verify return message");
	  Assert.assertEquals(loginPage.getErrorAccount(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	  
  }
  @Test
  public void Login_06_Success() {

      System.out.println("Login_06-Step 01:input value");
      loginPage.sendkeyToEmail(Email);
      loginPage.sendkeyToPassword(Password);


      System.out.println("Login_06-Step 02:clickToLoginButton");
      loginPage.clickToLoginButton();
	  
      homePage = new UserHomePageObject(driver);
	  System.out.println("Login_06-Step 03:Login_Success");
	  Assert.assertTrue(homePage.isMyAccountDisplay());
 
  }
 
 public int randomNumber () {
	 Random ran = new Random();
	 return ran.nextInt(9999);
 }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
