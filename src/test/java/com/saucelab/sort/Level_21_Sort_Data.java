package com.saucelab.sort;

import commons.BaseTest;
import pageObject.SauceLab.Sort.HomePO;
import pageObject.SauceLab.Sort.LoginPO;
import pageObject.SauceLab.Sort.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Level_21_Sort_Data extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		loginPage=PageGeneratorManager.getLoginPage(driver);
		
		username = "standard_user";
		password ="secret_sauce";

		log.info("Login_Account-Step 01: Enter to Username textbox with value is '" + username + "'");
		loginPage.inputToUserNameTextbox(username);

		log.info("Login_Account-Step 02: Enter to Password textbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login_Account-Step 03: Click to Login button ");
		homePage=loginPage.clickToButtonLogin();


  }
  
  @Test
  public void Sort_Data_01_Name_Ascending () {
	  homePage.selectDropdownValue("Name (A to Z)");
	  verifyTrue(homePage.isDisplayAscendingName());
	  
	  
	  
  }
  
  @Test
  public void Sort_Data_02_Name_Descending () {
	  homePage.selectDropdownValue("Name (Z to A)");
	  verifyTrue(homePage.isDisplayDescendingName());
	  
	  
  }
  
  @Test
  public void Sort_Data_03_Price_Ascending () {
	  homePage.selectDropdownValue("Price (low to high)");
	  verifyTrue(homePage.isDisplayAscendingPrice());
	  
	  
  }
  
  @Test
  public void Sort_Data_04_Price_Descending () {
	  homePage.selectDropdownValue("Price (high to low)");
	  verifyTrue(homePage.isDisplayDescendingPrice());
	  
	  
  }
  
  

@AfterClass (alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver();
  }
	private WebDriver driver;
	private String username,password;
	private LoginPO loginPage;
	private HomePO homePage;
	

}
