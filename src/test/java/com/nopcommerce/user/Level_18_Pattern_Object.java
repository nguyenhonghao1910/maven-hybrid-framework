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

public class Level_18_Pattern_Object extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		driver = getBrowserDriver(browsername);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	
		firstname ="Tester";
		lastname ="Automation";
		email = "abc" + randomNumber() + "@mail.vn" ;
		password ="123456";
		day="20";
		month="April";
		year="1994";
	}

  @Test
  public void User_01_Register () {
	 
	    log.info("Register_Account-Step 01: Open Register page");
	    registerPage = homePage.clickToRegisterLink();
	    
	    log.info("Register_Account-Step 02: click to radio Male");
	    registerPage.clickToRadioButtonByLabel(driver,"Male");
	    
	    
	    log.info("Register_Account-Step 03: Enter to Firstname textbox with value is '" + firstname + "'");
		registerPage.inputToTextboxByID( driver, "FirstName", firstname);
		
		
		log.info("Register_Account-Step 04: Enter to Lastname textbox with value is '" + lastname + "'");
		registerPage.inputToTextboxByID( driver,"LastName",  lastname);
		
		
		log.info("Register_Account-Step 05: select to day dropdown with value is '" + day + "'");
//		registerPage.selectToDropdownByName(driver,"DateOfBirthDay", day);
		
		
		log.info("Register_Account-Step 06: select to day dropdown with value is '" + month + "'");
//		registerPage.selectToDropdownByName(driver,"DateOfBirthMonth", month);
		
		
		log.info("Register_Account-Step 07: select to day dropdown with value is '" + year + "'");
//		registerPage.selectToDropdownByName(driver,"DateOfBirthYear", year);
		
		
		log.info("Register_Account-Step 08: Enter to Email textbox with value is '" + email + "'");
		registerPage.inputToTextboxByID( driver,"Email",  email);
		
		log.info("Register_Account-Step 09: click to Newsletter");
	    registerPage.clickToCheckboxByLabel(driver,"Newsletter");
	    
		log.info("Register_Account-Step 10: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToTextboxByID( driver,"Password",  password);
		
		
		log.info("Register_Account-Step 11: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputToTextboxByID( driver,"ConfirmPassword",  password);
		

		log.info("Register_Account-Step 12: Click to 'Register' button ");
//		registerPage.clickToButtonByText(driver, "Register");
		
		log.info("Register_Account-Step 13: Verify register message is displayed");
		verifyEquals(registerPage.getRegisterSuccess(), "Your registration completed");
		
		log.info("Register_Account-Step 14: Click to Logout link ");
		homePage = registerPage.clickToLogoutLink();
		
  }
  
  @Test
  public void User_02_Login () {
	  
	  log.info("Login_Account-Step 01: Navigate to Login page ");
	  loginPage =  homePage.clickToLoginLink();
	  
	  log.info("Login_Account-Step 02: Enter to Firstname textbox with value is '" + email + "'");
      //loginPage.sendkeyToEmail(Email);
	  loginPage.inputToTextboxByID(driver, "Email", email);
      
      log.info("Login_Account-Step 03: Enter to Firstname textbox with value is '" + password + "'");
      //loginPage.sendkeyToPassword(Password);
      loginPage.inputToTextboxByID(driver, "Password", password);

      log.info("Login_Account-Step 04: Click to Login button ");
//      loginPage.clickToButtonByText(driver, "Log in");
      homePage = PageGeneratorManager.getUserHomePage(driver);
      
      log.info("Login_Account-Step 05: Verify 'My Account' link is displayed ");
      verifyTrue(homePage.isMyAccountDisplay());

  }
  
  @Test
  public void User_03_My_Account () {
	  
	  log.info("My_Account-Step 01: Navigate to 'My Account' page ");
      customerPage = homePage.openMyAccount();
      
      log.info("My_Account-Step 02: Verify 'Customer Infor' page is displayed ");
      verifyTrue(customerPage.isCustomerInfoDisplay());
      
      log.info("My_Account-Step 03: Verify 'Male' value is correctly ");
//      Assert.assertTrue(customerPage.checkToRadioButtonByLabel(driver,"Male"));
      
      log.info("My_Account-Step 04: Verify 'Firstname' value is correctly ");
//      Assert.assertEquals(customerPage.getTextboxValueById(driver,"FirstName"), firstname);
      
      log.info("My_Account-Step 05: Verify 'Lastname' value is correctly ");
//      Assert.assertEquals(customerPage.getTextboxValueById(driver,"LastName"), lastname);
      
      log.info("My_Account-Step 06: Verify 'DateOfBirthDay' value is correctly ");
//      Assert.assertEquals(customerPage.getDropdownValueByName(driver,"DateOfBirthDay"), day);
      
      log.info("My_Account-Step 07: Verify 'DateOfBirthMonth' value is correctly ");
//      Assert.assertEquals(customerPage.getDropdownValueByName(driver,"DateOfBirthMonth"), month);
      
      log.info("My_Account-Step 08: Verify 'DateOfBirthYear' value is correctly ");
//      Assert.assertEquals(customerPage.getDropdownValueByName(driver,"DateOfBirthYear"), year);
      
      log.info("My_Account-Step 09: Verify 'Email' value is correctly ");
//      Assert.assertEquals(customerPage.getTextboxValueById(driver,"Email"), email);
      
      log.info("My_Account-Step 10: Verify 'Newsletter' value is selected ");
      Assert.assertTrue(customerPage.isCheckboxByLabel(driver,"Newsletter"));
  }
  

@AfterClass (alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver();
  }
	private WebDriver driver;
	private String email,firstname, lastname,password ,day,month,year;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerPageObject customerPage;

}
