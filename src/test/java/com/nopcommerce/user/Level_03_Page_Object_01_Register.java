package com.nopcommerce.user;

import org.testng.annotations.Test;

import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;



public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String Email ,Firstname, Lastname,Password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\Browserdrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Email = "abc" + nextgenemail() + "@mail.vn" ;
		Firstname ="Tester";
		Lastname ="Automation";
		Password ="123456";
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
	}

  @Test
  public void Register_01_Empty_Data () {
	  System.out.println("Register_01-Step 01:clickToRegister");
	  homePage.clickToRegisterLink();
	  
	  System.out.println("Register_01-Step 02:clickToResgisterButton");
	  registerPage.clickToResgisterButton();
	  
	  System.out.println("Register_01-Step 03:verify return message");
	  Assert.assertEquals(registerPage.getMessageErrorFirstname(), "First name is required.");
	  Assert.assertEquals(registerPage.getMessageErrorLastname(), "Last name is required.");
	  Assert.assertEquals(registerPage.getMessageErrorEmail(), "Email is required.");
	  Assert.assertEquals(registerPage.getMessageErrorPassword(), "Password is required.");
	  Assert.assertEquals(registerPage.getMessageErrorConfirmPassword(), "Password is required.");
	  
  }
  
  @Test
  public void Register_02_Invalid_Email() {
	  System.out.println("Register_02-Step 01:clickToRegister");
	  registerPage.clickToRegister();
	  
	  System.out.println("Register_02-Step 02:input value");
	  registerPage.sendkeyToFirstname(Firstname);
	  registerPage.sendkeyToLastname(Lastname);
	  registerPage.sendkeyToEmail(Firstname);
	  registerPage.sendkeyToPassword(Password);
	  registerPage.sendkeyToConfirmPassword(Password);
	  
	  System.out.println("Register_02-Step 03:clickToResgisterButton");
	  registerPage.clickToResgisterButton();
	  
	  System.out.println("Register_02-Step 04:verify return message");
	  Assert.assertEquals(registerPage.getMessageErrorEmail(), "Wrong email");
	   
  }
  
  @Test
  public void Register_03_Success() {
	  System.out.println("Register_03-Step 01:clickToRegister");
	  registerPage.clickToRegister();
	  
	  System.out.println("Register_03-Step 02:input value");
	  registerPage.sendkeyToFirstname(Firstname);
	  registerPage.sendkeyToLastname(Lastname);
	  registerPage.sendkeyToEmail(Email);
	  registerPage.sendkeyToPassword(Password);
	  registerPage.sendkeyToConfirmPassword(Password);

	  System.out.println("Register_03-Step 03:clickToResgisterButton");
	  registerPage.clickToResgisterButton();
	  
	  System.out.println("Register_03-Step 04:verify return message");
	  Assert.assertEquals(registerPage.getRegisterSuccess(), "Your registration completed");
	  
	 
	  registerPage.clickToLogoutLink();
	  
  }
 
  @Test
  public void Register_04_Existing_Email() {
	  System.out.println("Register_04-Step 01:clickToRegister");
	  registerPage.clickToRegister();
	  
	  System.out.println("Register_04-Step 02:input value");
	  registerPage.sendkeyToFirstname(Firstname);
	  registerPage.sendkeyToLastname(Lastname);
	  registerPage.sendkeyToEmail(Email);
	  registerPage.sendkeyToPassword(Password);
	  registerPage.sendkeyToConfirmPassword(Password);
	  
	  
	  System.out.println("Register_04-Step 03:clickToResgisterButton");
	  registerPage.clickToResgisterButton();
	  
	  
	  System.out.println("Register_04-Step 04:verify return message");
	  Assert.assertEquals(registerPage.getEmailExist(), "The specified email already exists");
	  
	  
  }
  @Test
  public void Register_05_Password_Less_Than_6_Chars() {
	  System.out.println("Register_05-Step 01:clickToRegister");
	  registerPage.clickToRegister();
	  
	  System.out.println("Register_05-Step 02:input value");
	  registerPage.sendkeyToFirstname(Firstname);
	  registerPage.sendkeyToLastname(Lastname);
	  registerPage.sendkeyToEmail(Email);
	  registerPage.sendkeyToPassword("1234");
	  registerPage.sendkeyToConfirmPassword("1234");

	  System.out.println("Register_05-Step 03:clickToResgisterButton");
	  registerPage.clickToResgisterButton();
	  
	  System.out.println("Register_05-Step 04:verify return message");
	  Assert.assertEquals(registerPage.getMessageErrorPassword(), "Password must meet the following rules:\nmust have at least 6 characters");
	  
  }
  @Test
  public void Register_06_Invalid_confirm_Password() {
	  System.out.println("Register_06-Step 01:clickToRegister");
      registerPage.clickToRegister();
	  
      System.out.println("Register_06-Step 02:input value");
      registerPage.sendkeyToFirstname(Firstname);
      registerPage.sendkeyToLastname(Lastname);
      registerPage.sendkeyToEmail(Email);
      registerPage.sendkeyToPassword(Password);
      registerPage.sendkeyToConfirmPassword("123457");

      System.out.println("Register_06-Step 03:clickToResgisterButton");
	  registerPage.clickToResgisterButton();
	  
	  System.out.println("Register_06-Step 04:verify return message");
	  Assert.assertEquals(registerPage.getMessageErrorConfirmPassword(), "The password and confirmation password do not match.");
	  
	 
  }
 
 public int nextgenemail () {
	 Random ran = new Random();
	 return ran.nextInt(9999);
 }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
