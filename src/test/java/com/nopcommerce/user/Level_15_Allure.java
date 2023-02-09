package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import com.relevantcodes.extentreports.LogStatus;

import pageObjects.NopCommerce.User.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Level_15_Allure extends BaseTest {


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
	
	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
  @Test
  public void User_01_Register (Method method) {
	  
	  registerPage = homePage.clickToRegisterLink();
	    
	  registerPage.sendkeyToFirstname(Firstname);
		
	  registerPage.sendkeyToLastname(Lastname);
		
	  registerPage.sendkeyToEmail(Email);
		 
	  registerPage.sendkeyToPassword(Password);
		
	  registerPage.sendkeyToConfirmPassword(Password);
		
	  registerPage.clickToResgisterButton();
	 
	  Assert.assertEquals(registerPage.getRegisterSuccess(), "Your registration completed");
	  
  }
  
	@Description("Login to system")
  @Test
  public void User_02_Login (Method method) {
	  
	  homePage = registerPage.clickToLogoutLink();
	  
	  loginPage =  homePage.clickToLoginLink();
	  
      loginPage.sendkeyToEmail(Email);
      
      loginPage.sendkeyToPassword(Password);

      homePage = loginPage.clickToLoginButton();
      
      Assert.assertFalse(homePage.isMyAccountDisplay());
      
      customerPage = homePage.openMyAccount();
      
      Assert.assertFalse(customerPage.isCustomerInfoDisplay());
      
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
	private UserCustomerPageObject customerPage;

}
