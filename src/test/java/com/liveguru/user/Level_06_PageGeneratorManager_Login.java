package com.liveguru.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsLiveGuru.User.UserHomePageObject;
import pageObjectsLiveGuru.User.UserLoginPageObject;
import pageObjectsLiveGuru.User.UserMyDashboardPageObject;
import pageObjectsLiveGuru.User.PageGeneratorManager;
import pageObjectsLiveGuru.User.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_PageGeneratorManager_Login extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserMyDashboardPageObject myDashboardPage;
	private UserLoginPageObject loginPage;
	private String FirstName,LastName,EmailAddress,Password,ComfirmPassword;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		homePage=PageGeneratorManager.getHomePage(driver);
		FirstName ="Hao";
		LastName ="TesterAutomation";
		EmailAddress="Hao" + randomNumber() + "@hotmail.com";
		Password="123456";
		ComfirmPassword="123456";		
	}

  @Test
  public void User_01_Register_To_Systerm() {
	    System.out.println("User_01_Step 01:HomePage:Click to My Account");
	    loginPage=homePage.clickToMyAccountLink();
		
		System.out.println("User_01_Step 02:LoginPage:Click to Create An Account");
		registerPage=loginPage.clickToCreateAnAccount();
		
		
		System.out.println("User_01_Step 03:RegisterPage: Input Value");
		registerPage.sendkeyToFirstName(FirstName);
		registerPage.sendkeyToLastName(LastName);
		registerPage.sendkeyToEmailAddress(EmailAddress);
		registerPage.sendkeyToPassword(Password);
		registerPage.sendkeyToComfirmPassword(ComfirmPassword);
		myDashboardPage=registerPage.clickToRegisterButton();
	  
		System.out.println("User_01_Step 04:Verify Register Is Success");
		Assert.assertEquals(myDashboardPage.returnMessageRegisterIsSuccess(), "Thank you for registering with Main Website Store.");
		
		System.out.println("User_01_Step 05:Click To Account Button");
		myDashboardPage.clickToAccountButton();
		
		System.out.println("User_01_Step 06:Logout Register Page");
		homePage = myDashboardPage.clickToLogoutButton();
		
  }
  
  @Test
  public void User_02_Login_To_Systerm() {
	  System.out.println("User_02_Step 01:Click To My Account Link");
	  loginPage =  homePage.clickToMyAccountLink();
	  
	  System.out.println("User_02_Step 02:Input Value Account");
	  loginPage.sendkeyEmailTextbox(EmailAddress);
	  loginPage.sendkeyPasswordTextbox(Password);
	  myDashboardPage = loginPage.clickToLoginButton();
	  System.out.println("User_02_Step 03:Verify My Account");
	  Assert.assertEquals(myDashboardPage.returnMessageLoginIsSuccess(), "Hello," + " " + FirstName+ " " + LastName + "!");
	
	   
  }
  
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }



}
