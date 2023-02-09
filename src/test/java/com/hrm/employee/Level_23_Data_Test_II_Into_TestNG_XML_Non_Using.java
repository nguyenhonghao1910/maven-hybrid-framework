package com.hrm.employee;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.hrm.AddEmployeePO;
import pageObject.hrm.DashboardPO;
import pageObject.hrm.EmployeeListPO;
import pageObject.hrm.LoginPO;
import pageObject.hrm.PageGenerator;
import pageObject.hrm.MyInfoPO;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.NopCommerce.User.*;

public class Level_23_Data_Test_II_Into_TestNG_XML_Non_Using extends BaseTest {
	String employeeID;
	String fullnameUser;
	
	
	@Parameters({"browser","usernameAdmin","passwordAdmin"})
	@BeforeClass
	public void beforeClass(String browsername,String usernameAdmin, String passwordAdmin) {
		log.info("Pre-condition - Step 01: Open browser '" + browsername + "' ");
		driver = getBrowserDriver(browsername);
		loginPage=PageGenerator.getLoginPage(driver);

		log.info("Pre-condition - Step 02: Login with Admin role");
		dashboardPage=loginPage.loginToSystem(driver, usernameAdmin,passwordAdmin);

	}
	@Parameters({"empFirstname","empLastnameUser","empUsername","empPasswod","statusValue"})
	@Test
	public void Employee_01_Add_New_Employee(String empFirstname,String empLastnameUser,String empUsername,String empPasswod,String statusValue ) {
		log.info("Add_New_01 - Step 01: Open 'Employee List' Page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New_01 - Step 02: Click to 'Add' button");
		employeeListPage.clickToButtonById(driver, "btnAdd");
		addEmployeePage=PageGenerator.getAddEmployeePage(driver);
		
		log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.inputToTextboxByID(driver, "firstName", empFirstname);
		
		log.info("Add_New_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.inputToTextboxByID(driver, "lastName", empLastnameUser);
		
		log.info("Add_New_01 - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getValueTextboxByID(driver, "employeeId");
		
		log.info("Add_New_01 - Step 06: Click to 'Create Login Detail' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");
		
		log.info("Add_New_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.inputToTextboxByID(driver, "user_name", empUsername);
		
		log.info("Add_New_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.inputToTextboxByID(driver, "user_password", empPasswod);
		
		log.info("Add_New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.inputToTextboxByID(driver, "re_password", empPasswod);
		
		log.info("Add_New_01 - Step 10: Select '" + statusValue + "' value in 'Status' dropdown");
		addEmployeePage.selectDropdownByID(driver, "status", statusValue);
		
		log.info("Add_New_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonById(driver, "btnSave");
		myInfoPage=PageGenerator.getMyInfoPage(driver);
		
		log.info("Add_New_01 - Step 12: Open 'Employee List' page");
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.inputToTextboxByID(driver, "empsearch_employee_name_empName",fullnameUser);
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add_New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonById(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add_New_01 - Step 15: Verify Employee Infomation is display at 'Result Table'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), empFirstname);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), empLastnameUser);
		
	
	}
	
	@Parameters({"empUsername","empPasswod","avatar"})
	@Test
	public void Employee_02_Upload_Avatar(String empUsername ,String empPasswod,String avatar) {
		
		log.info("Upload_Avatar_02 - Step 1: Logout page");
		loginPage=employeeListPage.logoutToSystem(driver);
		
		log.info("Upload_Avatar_02 - Step 2: Login with User role");
		dashboardPage=loginPage.loginToSystem(driver, empUsername,empPasswod);
		
		log.info("Upload_Avatar_02 - Step 3: Click to 'My Info'");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage= PageGenerator.getMyInfoPage(driver);
		
		log.info("Upload_Avatar_02 - Step 4: Click to Change photo image");
		myInfoPage.clickToChangeAvatar();
		
		log.info("Upload_Avatar_02 - Step 5: Upload new Avator image");
		myInfoPage.uploadMultipleFiles(driver, avatar);
		
		log.info("Upload_Avatar_02 - Step 6: Click to Upload Button");
		myInfoPage.clickToButtonById(driver, "btnSave");
		
		log.info("Upload_Avatar_02 - Step 7: Verify return message upload image successed");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Uploaded"));
		
		log.info("Upload_Avatar_02 - Step 8: Verify upload new image successed");
		verifyTrue(myInfoPage.isDisplayNewImageAfterUpload());
		

	}

	@Test
	public void Employee_04_Contact_Details() {
		
	}

	@Test
	public void Employee_05_Emergency_Details() {
		
		
	}

	@Test
	public void Employee_06_Assigned_Dependents() {
		
	}
	
	@Test
	public void Employee_07_Update_Immigration() {	
	
	}

	@Test
	public void Employee_08_Edit_View_Job() {	
		
	}

	@Test
	public void Employee_09_Edit_View_Salary() {
	
	}

  

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	LoginPO loginPage;
	AddEmployeePO addEmployeePage;
	DashboardPO dashboardPage;
	EmployeeListPO employeeListPage;
	MyInfoPO myInfoPage;

}
