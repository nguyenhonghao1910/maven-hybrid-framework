package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	

	@Parameters("browser")
	@BeforeTest(description= "Create new user for all Classes Test")
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		Firstname ="Tester";
		Lastname ="Automation";
		Email = "abc" + randomNumber() + "@mail.vn" ;
		Password ="123456";	
	  
	    log.info("Pre-Condition - Step 01: Open Register page");
	    registerPage = homePage.clickToRegisterLink();
	    
	    log.info("Pre-Condition - Step 02: Enter to Firstname textbox with value is '" + Firstname + "'");
		registerPage.sendkeyToFirstname(Firstname);
		
		log.info("Pre-Condition - Step 03: Enter to Lastname textbox with value is '" + Lastname + "'");
		registerPage.sendkeyToLastname(Lastname);
		
		log.info("Pre-Condition - Step 04: Enter to Email textbox with value is '" + Email + "'");
		registerPage.sendkeyToEmail(Email);
		
		log.info("Pre-Condition - Step 05: Enter to Password textbox with value is '" + Password + "'");
		registerPage.sendkeyToPassword(Password);
		
		log.info("Pre-Condition - Step 06: Enter to Confirm Password textbox with value is '" + Password + "'");
		registerPage.sendkeyToConfirmPassword(Password);
		
		log.info("Pre-Condition - Step 07: Click to 'Register' button ");
		registerPage.clickToResgisterButton();
		
		log.info("Pre-Condition - Step 08: Verify register message is displayed");
		verifyEquals(registerPage.getRegisterSuccess(), "Your registration completed");
		
		log.info("Pre-Condition - Step 09: Click to Logout link ");
		homePage = registerPage.clickToLogoutLink();


  }
  
  @AfterTest
  public void afterClass() {
	  driver.quit();
  }
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String Lastname,Firstname;
	public static String Password,Email;


}
