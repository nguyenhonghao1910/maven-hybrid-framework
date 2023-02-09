package com.hrm.employee;

import commons.BaseTest;
import commons.PageGeneratorManager;
import data.hrm.employee.EmployeeTestData;
import data.hrm.employee.EmployeeTestData.Role;
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

public class Level_23_Data_Test_III_Out_Class extends BaseTest {
	String employeeID;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		log.info("Pre-condition - Step 01: Open browser '" + browsername + "' ");
		driver = getBrowserDriver(browsername);
		loginPage=PageGenerator.getLoginPage(driver);
	
		
		log.info("Pre-condition - Step 02: Login with Admin role");
		dashboardPage=loginPage.loginToSystem(driver,EmployeeTestData.Role.ADMIN_USERNAME,EmployeeTestData.Role.ADMIN_PASSWORD);

	}
	
	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_01 - Step 01: Open 'Employee List' Page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New_01 - Step 02: Click to 'Add' button");
		employeeListPage.clickToButtonById(driver, "btnAdd");
		addEmployeePage=PageGenerator.getAddEmployeePage(driver);
		
		log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.inputToTextboxByID(driver, "firstName",EmployeeTestData.EmployeeList.FIRSTNAME);
		
		log.info("Add_New_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.inputToTextboxByID(driver, "lastName", EmployeeTestData.EmployeeList.LASTNAME);
		
		log.info("Add_New_01 - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getValueTextboxByID(driver, "employeeId");
		
		log.info("Add_New_01 - Step 06: Click to 'Create Login Detail' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");
		
		log.info("Add_New_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.inputToTextboxByID(driver, "user_name", EmployeeTestData.EmployeeList.USERNAME);
		
		log.info("Add_New_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.inputToTextboxByID(driver, "user_password", EmployeeTestData.EmployeeList.PASSWORD);
		
		log.info("Add_New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.inputToTextboxByID(driver, "re_password", EmployeeTestData.EmployeeList.PASSWORD);
		
		log.info("Add_New_01 - Step 10: Select '" + EmployeeTestData.EmployeeList.STATUSVALUE + "' value in 'Status' dropdown");
		addEmployeePage.selectDropdownByID(driver, "status", EmployeeTestData.EmployeeList.STATUSVALUE);
		
		log.info("Add_New_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonById(driver, "btnSave");
		myInfoPage=PageGenerator.getMyInfoPage(driver);
		
		log.info("Add_New_01 - Step 12: Open 'Employee List' page");
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.inputToTextboxByID(driver, "empsearch_employee_name_empName",EmployeeTestData.EmployeeList.FULLNAME);
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add_New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonById(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Add_New_01 - Step 15: Verify Employee Infomation is display at 'Result Table'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), EmployeeTestData.EmployeeList.FIRSTNAME);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), EmployeeTestData.EmployeeList.LASTNAME);
		
	
	}

	@Test
	public void Employee_02_Upload_Avatar() {
		
		log.info("Upload_Avatar_02 - Step 1: Logout page");
		loginPage=employeeListPage.logoutToSystem(driver);
		
		log.info("Upload_Avatar_02 - Step 2: Login with User role");
		dashboardPage=loginPage.loginToSystem(driver, EmployeeTestData.EmployeeList.USERNAME,EmployeeTestData.EmployeeList.PASSWORD);
		
		log.info("Upload_Avatar_02 - Step 3: Click to 'My Info'");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage= PageGenerator.getMyInfoPage(driver);
		
		log.info("Upload_Avatar_02 - Step 4: Click to Change photo image");
		myInfoPage.clickToChangeAvatar();
		
		log.info("Upload_Avatar_02 - Step 5: Upload new Avator image");
		myInfoPage.uploadMultipleFiles(driver, EmployeeTestData.MyInfo.AVATAR);
		
		log.info("Upload_Avatar_02 - Step 6: Click to Upload Button");
		myInfoPage.clickToButtonById(driver, "btnSave");
		
		log.info("Upload_Avatar_02 - Step 7: Verify return message upload image successed");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Uploaded"));
		
		log.info("Upload_Avatar_02 - Step 8: Verify upload new image successed");
		verifyTrue(myInfoPage.isDisplayNewImageAfterUpload());
		

	}

	@Test
	public void Employee_03_My_Info() {
		log.info("Employee_My_Info_03 - Step 1: Open side bar 'Personal Details'");
		myInfoPage.openAtSideBarTabByName(driver,"Personal Details");
		
		log.info("Employee_My_Info_03 - Step 2: Verify  field 'First Name' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtEmpFirstName"));
		
		log.info("Employee_My_Info_03 - Step 3: Verify  field 'Last Name' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtEmpLastName"));
		
		log.info("Employee_My_Info_03 - Step 4: Verify  field 'Employee Id' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtEmployeeId"));
		
		log.info("Employee_My_Info_03 - Step 5: Verify  field 'Driver's License Number' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtLicenNo"));
		
		log.info("Employee_My_Info_03 - Step 6: Verify  field 'Nationality' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_cmbNation"));
		
		log.info("Employee_My_Info_03 - Step 7: Verify  field 'Gender' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_optGender_1"));
		
		log.info("Employee_My_Info_03 - Step 8: Verify  field 'Smoker' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_chkSmokeFlag"));
		
		log.info("Employee_My_Info_03 - Step 9: Verify  field 'License Expiry Date' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtLicExpDate"));
		
		log.info("Employee_My_Info_03 - Step 10: Click To 'Edit' Button At 'Personal Details' form");
		myInfoPage.clickToButtonById(driver, "btnSave");
		
		log.info("Employee_My_Info_03 - Step 11: Verify  field 'Employee Id' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtEmployeeId"));
		
		log.info("Employee_My_Info_03 - Step 12: Verify  field 'Driver's License Number' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtLicenNo"));
		
		log.info("Employee_My_Info_03 - Step 13: Verify  field 'SSN Number' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtNICNo"));
		
		log.info("Employee_My_Info_03 - Step 14: Verify  field 'SIN Number' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_txtSINNo"));
		
		log.info("Employee_My_Info_03 - Step 15: Verify  field 'Date of Birth' is disabled");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"personal_DOB"));
		
		log.info("Employee_My_Info_03 - Step 16: Enter New Value in Field 'First Name'");
		myInfoPage.inputToTextboxByID(driver, "personal_txtEmpFirstName", EmployeeTestData.PersonalDetails.EDIT_FIRSTNAME);
		
		log.info("Employee_My_Info_03 - Step 17: Enter New Value in Field 'Last Name'");
		myInfoPage.inputToTextboxByID(driver, "personal_txtEmpLastName", EmployeeTestData.PersonalDetails.EDIT_LASTNAME);
		
		log.info("Employee_My_Info_03 - Step 18: Enter New Value in Field 'Other Id'");
		myInfoPage.inputToTextboxByID(driver, "personal_txtOtherID", EmployeeTestData.PersonalDetails.OTHER_ID);
		
		log.info("Employee_My_Info_03 - Step 19: Enter New Value in Field 'License Expiry Date'");
		myInfoPage.inputToTextboxByID(driver, "personal_txtLicExpDate", EmployeeTestData.PersonalDetails.LICENSE_EXPIRYDATE);
		
		log.info("Employee_My_Info_03 - Step 20: Select 'Male' in Field Gender");
		myInfoPage.clickToRadioButtonByLabel(driver, EmployeeTestData.PersonalDetails.GENDER);
		
		log.info("Employee_My_Info_03 - Step 21: Select 'VietNamese' in Field Dropdown 'Nationality' ");
		myInfoPage.selectDropdownByID(driver, "personal_cmbNation", EmployeeTestData.PersonalDetails.NATIONALITY);
		
		log.info("Employee_My_Info_03 - Step 22: Select 'Single' in Field Dropdown 'Marital Status' ");
		myInfoPage.selectDropdownByID(driver, "personal_cmbMarital", EmployeeTestData.PersonalDetails.MARITAL_STATUS);
		
		log.info("Employee_My_Info_03 - Step 23: Check 'Smoker' in Field checkbox 'Smoker'");
		myInfoPage.clickToCheckboxByLabel(driver, "Smoker");
		
		log.info("Employee_My_Info_03 - Step 24: Click To 'Save' Button");
		myInfoPage.clickToButtonById(driver, "btnSave");
		
		log.info("Employee_My_Info_03 - Step 24: Verify display message updated is successfull");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Saved"));
		
		log.info("Employee_My_Info_03 - Step 25: Verify Value Field 'First Name' After Edit");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "personal_txtEmpFirstName"), EmployeeTestData.PersonalDetails.EDIT_FIRSTNAME);
		
		log.info("Employee_My_Info_03 - Step 26: Verify Value Field 'Last Name' After Edit");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "personal_txtEmpLastName"), EmployeeTestData.PersonalDetails.EDIT_LASTNAME);
		
		log.info("Employee_My_Info_03 - Step 27: Verify Value Field 'Other Id' After Input");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "personal_txtOtherID"), EmployeeTestData.PersonalDetails.OTHER_ID);
		
		log.info("Employee_My_Info_03 - Step 28: Verify Value Field 'License Expiry Date' After Input ");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "personal_txtLicExpDate"), EmployeeTestData.PersonalDetails.LICENSE_EXPIRYDATE);
		
		log.info("Employee_My_Info_03 - Step 29: Verify 'Male' in Field Gender After Select");
		verifyTrue(myInfoPage.isRadioButtonByLabel(driver, EmployeeTestData.PersonalDetails.GENDER));

		
		log.info("Employee_My_Info_03 - Step 30: Verify 'VietNamese' in Field Dropdown 'Nationality' After Select ");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "personal_cmbNation"), EmployeeTestData.PersonalDetails.NATIONALITY);
		
		log.info("Employee_My_Info_03 - Step 31: Verify 'Single' in Field Dropdown 'Marital Status' After Select ");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "personal_cmbMarital"), EmployeeTestData.PersonalDetails.MARITAL_STATUS);
		
		
		log.info("Employee_My_Info_03 - Step 32: Verify 'Smoker' in Field checkbox 'Smoker' After Check ");
		verifyTrue(myInfoPage.isCheckboxByLabel(driver, "Smoker"));
		
		

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
