package com.liveguru.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsLiveGuru.Admin.AdminLoginPageObject;
import pageObjectsLiveGuru.Admin.AdminManageCustomerPageObject;
import pageObjectsLiveGuru.User.*;

public class Level_10_HandleWebDataTable_Exercise extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserMyDashboardPageObject userMyDashboardPage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminManageCustomerPageObject adminManageCustomer;
    private String FirstName,LastName,EmailAddress,Password, ConfirmPassword,UserName,PasswordAdmin;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browsername, String urlname ) {
        driver = getBrowserDriverUrl(browsername,urlname);
        userHomePage = PageGeneratorManager.getHomePage(driver);
        FirstName ="Hao";
        LastName ="TesterAutomation";
        EmailAddress="Hao" + randomNumber() + "@hotmail.com";
        Password="123456";
        ConfirmPassword ="123456";
        UserName="user01";
        PasswordAdmin="guru99com";
    }
    @Test
    public void User_01_Register_To_System() {
        System.out.println("User_01_Step 01:HomePage:Click to My Account");
        userLoginPage = userHomePage.clickToMyAccountLink();

        System.out.println("User_01_Step 02:LoginPage:Click to Create An Account");
        userRegisterPage = userLoginPage.clickToCreateAnAccount();

        System.out.println("User_01_Step 03:RegisterPage: Input Value");
        userRegisterPage.sendkeyToFirstName(FirstName);
        userRegisterPage.sendkeyToLastName(LastName);
        userRegisterPage.sendkeyToEmailAddress(EmailAddress);
        userRegisterPage.sendkeyToPassword(Password);
        userRegisterPage.sendkeyToComfirmPassword(ConfirmPassword);
        userMyDashboardPage = userRegisterPage.clickToRegisterButton();

        System.out.println("User_01_Step 04:Verify Register Is Success");
        Assert.assertEquals(userMyDashboardPage.returnMessageRegisterIsSuccess(), "Thank you for registering with Main Website Store.");
        userMyDashboardPage.openPageUrl(driver,"http://live.techpanda.org/index.php/backendlogin/customer/");
    }

    @Test
    public void User_02_Login_To_AdminPage() {
        System.out.println("User_02_Step 01:Move to the PageAdmin");
        adminLoginPage =  PageGeneratorManager.getAdminLoginPage(driver);
        adminManageCustomer= adminLoginPage.loginIntoManageCustomer(UserName,PasswordAdmin);
        adminManageCustomer = PageGeneratorManager.getAdminManagerCustomerPage(driver);
        adminManageCustomer.sleepinsecond(5);
        adminManageCustomer.closePopup();
        adminManageCustomer.inputValueInTextbox("name",FirstName + " " + LastName);
        adminManageCustomer.inputValueInTextbox("email",EmailAddress);
        adminManageCustomer.clickToSearchButton();
        Assert.assertTrue(adminManageCustomer.isDisplayResult(FirstName + " " + LastName , EmailAddress));

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
