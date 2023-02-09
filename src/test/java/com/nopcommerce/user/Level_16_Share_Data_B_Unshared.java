package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.User.*;
public class Level_16_Share_Data_B_Unshared extends BaseTest {


	@Parameters("browser")
	@BeforeClass
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
		
		log.info("Pre-Condition - Step 10: Navigate to Login page ");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition - Step 11: Enter to Firstname textbox with value is '" + Email + "'");
		loginPage.sendkeyToEmail(Email);

		log.info("Pre-Condition - Step 12: Enter to Firstname textbox with value is '" + Password + "'");
		loginPage.sendkeyToPassword(Password);

		log.info("Pre-Condition - Step 13: Click to Login button ");
		homePage = loginPage.clickToLoginButton();
		
  }
  
	@Test
	  public void TC_01_Search_Empty_Data () {

	  }
	  @Test
	  public void TC_02_Search_Data_Not_Exist () {

	  }
	  @Test
	  public void User_03_Search_Relative_Product_Name () {

	  }
	  @Test
	  public void User_04_Search_Absolute_Product_Name () {

	  }
	  @Test
	  public void User_05_Parent_Category () {

	  }
	  @Test
	  public void User_06_Sub_Category () {

	  }
	  @Test
	  public void User_07_Incorrect_Manuafacturer () {

	  }
	  
	  @Test
	  public void User_08_correct_Manuafacturer () {

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


}
