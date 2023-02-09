package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import pageObjects.NopCommerce.User.*;



public class Level_16_Share_Data_A extends BaseTest {


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		Email=Common_01_Register_End_User.Email;
		Password =Common_01_Register_End_User.Password;
		
		log.info("Login_Account-Step 01: Navigate to Login page ");
		loginPage = homePage.clickToLoginLink();

		log.info("Login_Account-Step 02: Enter to Firstname textbox with value is '" + Email + "'");
		loginPage.sendkeyToEmail(Email);

		log.info("Login_Account-Step 03: Enter to Firstname textbox with value is '" + Password + "'");
		loginPage.sendkeyToPassword(Password);

		log.info("Login_Account-Step 04: Click to Login button ");
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
	private String Email,Password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

}
