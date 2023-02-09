package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.User.*;

import java.util.concurrent.TimeUnit;

public class Level_12_Assert_Verify extends BaseTest {


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Firstname ="Tester";
		Lastname ="Automation";
		Email = "abc" + randomNumber() + "@mail.vn" ;
		Password ="123456";		
	}

  @Test
  public void User_01_Register_Login () {
	    homePage = PageGeneratorManager.getUserHomePage(driver);
	    System.out.println("Register_Account-Step 01:clickToRegister");
		homePage.clickToRegisterLink();
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Register_Account-Step 02:input value");
		registerPage.sendkeyToFirstname(Firstname);
		registerPage.sendkeyToLastname(Lastname);
		registerPage.sendkeyToEmail(Email);
		registerPage.sendkeyToPassword(Password);
		registerPage.sendkeyToConfirmPassword(Password);
		System.out.println("Register_Account-Step 03:clickToResgisterButton");
		registerPage.clickToResgisterButton();
		System.out.println("Register_Account-Step 04:verify return message");

		verifyEquals(registerPage.getRegisterSuccess(), "Your registration completed");
	
		homePage = registerPage.clickToLogoutLink();
		loginPage =  homePage.clickToLoginLink();
		System.out.println("Login_06-Step 01:clickToLogin");
		loginPage.clickToLoginLink();
		  
	    System.out.println("Login_06-Step 02:input value");	  
	    loginPage =  homePage.clickToLoginLink();
	    System.out.println("Login_06-Step 01:clickToLogin");
	    loginPage.clickToLoginLink();
	  
        System.out.println("Login_06-Step 02:input value");
        loginPage.sendkeyToEmail(Email);
        loginPage.sendkeyToPassword(Password);

        System.out.println("Login_06-Step 03:clickToLoginButton");
        homePage = loginPage.clickToLoginButton();
	  
	    System.out.println("Login_06-Step 04:Login_Success");
	    verifyTrue(homePage.isMyAccountDisplay());
		customerPage = homePage.openMyAccount();
		System.out.println("User_03-Step 01:ClickToMyAccount");
		verifyTrue(customerPage.isCustomerInfoDisplay());
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
