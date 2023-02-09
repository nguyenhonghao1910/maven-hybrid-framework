package com.facebook.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.FacebookLogin.LoginPageObject;
import pageObjects.FacebookLogin.PageGeneratorManager;
import pageObjects.NopCommerce.User.*;

import java.util.concurrent.TimeUnit;

public class Level_13_Element_Undisplayed extends BaseTest {


	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browsername, String urlname) {
		driver = getBrowserDriverUrl(browsername, urlname);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPage= PageGeneratorManager.getLoginPage(driver);
	}

  @Test
  public void TC_01_Verify_Element_Displayed () {
	   loginPage.clickToButtonCreateAccount();
	   loginPage.inputEmailAddressTextbox("HaoAutoTest@gmail.com");
	   verifyTrue(loginPage.reEnterEmailAddressisDisplayed());
  }
  @Test
  public void TC_02_Verify_Element_Undisplayed_In_DOM () {
	  loginPage.inputEmailAddressTextbox("");
	  verifyTrue(loginPage.reEnterEmailAddressUndisplayed());
	  
	   
  }
  @Test
  public void TC_03_Verify_Element_Undisplayed_Not_In_DOM () {
	  loginPage.clickCloseIconRegister();
	  verifyTrue(loginPage.reEnterEmailAddressUndisplayed());
	   
  }
  
  
@AfterClass
  public void afterClass() {
	  driver.quit();
  }
	private WebDriver driver;
	private LoginPageObject loginPage;

}
