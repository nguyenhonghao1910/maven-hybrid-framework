package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import pageObjects.NopCommerce.User.*;

public class Level_16_Share_Data_C_Use_Cookie extends BaseTest {


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		log.info("Pre-Condition - Step 01: Navigate to Login page ");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition - Step 02: Set Cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.LoggedCookies);
		loginPage.refreshCurrentPage(driver);
		
		log.info("Login_Account-Step 05: Verify 'My Account' link is displayed ");
	    verifyTrue(homePage.isMyAccountDisplay());
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
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;


}
