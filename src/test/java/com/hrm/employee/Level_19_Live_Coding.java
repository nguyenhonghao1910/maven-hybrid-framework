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

public class Level_19_Live_Coding extends BaseTest {
	String employeeID, statusValue,usernameAdmin, passwordAdmin,empFirstname,empLastnameUser,empUsername,empPasswod;
	String fullnameUser, avatar,empFirstnameEdit,empLastnameEdit,OtherId,Gender,Nationality,MaritalStatus,LicenseExpiryDate;
	String address_1,address_2,city,province,postalCode,country,mobile,workEmail;
	String nameContact,relationship, homeTelephone, mobileContact, telephoneWork;
	String nameContact1,relationship1, homeTelephone1, mobileContact1, telephoneWork1;
	String nameDep,relationshipDep,dayOfBirthDep;
	String nameDep1,relationshipDep1,dayOfBirthDep1, pleaseSpecify;
	String numberImmigration,issuedDate,issuedBy,comments;
	String jobTitle,employmentStatus,joinedDate,startDate;
	String payGrade,salaryComponent,currency,amountSalary,accountNumber,accountType,routingNumber,amount; 
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browsername) {
		log.info("Pre-condition - Step 01: Open browser '" + browsername + "' ");
		driver = getBrowserDriver(browsername);
		loginPage=PageGenerator.getLoginPage(driver);
		
		statusValue = "Enabled";
		usernameAdmin = "Admin";
		passwordAdmin = "admin123";
		empFirstname = "Thememo";
		empLastnameUser = "Tester";
		empUsername = "AutoGene";
		empPasswod = "automationtest";
		fullnameUser = empFirstname + " " + empLastnameUser;
		avatar="Avatar.png";
		
		empFirstnameEdit="Aladingo";
		empLastnameEdit="Jameno";
		OtherId="12345678";
		Gender="Male";
		Nationality="Vietnamese";
		MaritalStatus="Single";
		LicenseExpiryDate="2022-04-12";
		
		address_1="123 Wall Street";
		address_2="Dai lo danh vong";
		city="LA";
		province="Chicago";
		postalCode="01";
		country="United States";
		mobile="012345678";
		workEmail="HaoJamecamaron@clever.com";
		
		nameContact ="Tifany Nguyen";
		relationship ="Wife"; 
		homeTelephone="0812345678"; 
		mobileContact ="0987654321"; 
		telephoneWork ="0887654321";
		
		nameContact1 ="Emily Nguyen";
		relationship1 ="Wife"; 
		homeTelephone1="08123456781"; 
		mobileContact1 ="09876543211"; 
		telephoneWork1 ="08876543211";
		
		nameDep ="Alice";
		relationshipDep ="Child";
		dayOfBirthDep ="2020-04-12";
		
		nameDep1 ="Elly";
		relationshipDep1 ="Other";
		pleaseSpecify="Other";
		dayOfBirthDep1 ="1994-04-12";
		
		numberImmigration="12345678";
		issuedDate="2015-08-24";
		issuedBy="Finland";
		comments="Hard lean is'nt more than smart hard";
		
		jobTitle="Automation Tester";
		employmentStatus="Full-Time Contract";
		joinedDate="2020-02-04";
		startDate="2020-02-04";
		
		payGrade="Grade 14";
		salaryComponent="Full Salary";
		currency="United States Dollar";
		amountSalary="10000";
		accountNumber="7658";
		accountType="Savings";
		routingNumber="2";
		amount="1000";
		
		log.info("Pre-condition - Step 02: Login with Admin role");
		dashboardPage=loginPage.loginToSystem(driver, usernameAdmin,passwordAdmin);

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

	@Test
	public void Employee_02_Upload_Avatar() {
		
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
		myInfoPage.inputToTextboxByID(driver, "personal_txtEmpFirstName", empFirstnameEdit);
		
		log.info("Employee_My_Info_03 - Step 17: Enter New Value in Field 'Last Name'");
		myInfoPage.inputToTextboxByID(driver, "personal_txtEmpLastName", empLastnameEdit);
		
		log.info("Employee_My_Info_03 - Step 18: Enter New Value in Field 'Other Id'");
		myInfoPage.inputToTextboxByID(driver, "personal_txtOtherID", OtherId);
		
		log.info("Employee_My_Info_03 - Step 19: Enter New Value in Field 'License Expiry Date'");
		myInfoPage.inputToTextboxByID(driver, "personal_txtLicExpDate", LicenseExpiryDate);
		
		log.info("Employee_My_Info_03 - Step 20: Select 'Male' in Field Gender");
		myInfoPage.clickToRadioButtonByLabel(driver, Gender);
		
		log.info("Employee_My_Info_03 - Step 21: Select 'VietNamese' in Field Dropdown 'Nationality' ");
		myInfoPage.selectDropdownByID(driver, "personal_cmbNation", Nationality);
		
		log.info("Employee_My_Info_03 - Step 22: Select 'Single' in Field Dropdown 'Marital Status' ");
		myInfoPage.selectDropdownByID(driver, "personal_cmbMarital", MaritalStatus);
		
		log.info("Employee_My_Info_03 - Step 23: Check 'Smoker' in Field checkbox 'Smoker'");
		myInfoPage.clickToCheckboxByLabel(driver, "Smoker");
		
		log.info("Employee_My_Info_03 - Step 24: Click To 'Save' Button");
		myInfoPage.clickToButtonById(driver, "btnSave");
		
		log.info("Employee_My_Info_03 - Step 24: Verify display message updated is successfull");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Saved"));
		
		log.info("Employee_My_Info_03 - Step 25: Verify Value Field 'First Name' After Edit");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "personal_txtEmpFirstName"), empFirstnameEdit);
		
		log.info("Employee_My_Info_03 - Step 26: Verify Value Field 'Last Name' After Edit");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "personal_txtEmpLastName"), empLastnameEdit);
		
		log.info("Employee_My_Info_03 - Step 27: Verify Value Field 'Other Id' After Input");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "personal_txtOtherID"), OtherId);
		
		log.info("Employee_My_Info_03 - Step 28: Verify Value Field 'License Expiry Date' After Input ");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "personal_txtLicExpDate"), LicenseExpiryDate);
		
		log.info("Employee_My_Info_03 - Step 29: Verify 'Male' in Field Gender After Select");
		verifyTrue(myInfoPage.isRadioButtonByLabel(driver, Gender));

		
		log.info("Employee_My_Info_03 - Step 30: Verify 'VietNamese' in Field Dropdown 'Nationality' After Select ");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "personal_cmbNation"), Nationality);
		
		log.info("Employee_My_Info_03 - Step 31: Verify 'Single' in Field Dropdown 'Marital Status' After Select ");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "personal_cmbMarital"), MaritalStatus);
		
		
		log.info("Employee_My_Info_03 - Step 32: Verify 'Smoker' in Field checkbox 'Smoker' After Check ");
		verifyTrue(myInfoPage.isCheckboxByLabel(driver, "Smoker"));
		
		

	}

	@Test
	public void Employee_04_Contact_Details() {
		
		log.info("Contact_Details_04 - Step 1: Open side bar 'Contact Details'");
		myInfoPage.openAtSideBarTabByName(driver, "Contact Details");
		
		log.info("Contact_Details_04 - Step 2: Verify Field 'Contact Details' form is disable");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_street1"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_street2"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_city"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_province"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_emp_zipcode"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_country"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_emp_hm_telephone"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_emp_mobile"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_emp_work_telephone"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_emp_work_email"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"contact_emp_oth_email"));
		
		log.info("Contact_Details_04 - Step 3: Click To 'Edit' Button");
		myInfoPage.clickToButtonById(driver, "btnSave");
		
		log.info("Contact_Details_04 - Step 4: Input New Value in Field 'Address Street 1'");
		myInfoPage.inputToTextboxByID(driver, "contact_street1", address_1);
		
		log.info("Contact_Details_04 - Step 5: Input New Value in Field 'Address Street 2'");
		myInfoPage.inputToTextboxByID(driver, "contact_street2", address_2);
		
		log.info("Contact_Details_04 - Step 6: Input New Value in Field 'City'");
		myInfoPage.inputToTextboxByID(driver, "contact_city", city);
		
		log.info("Contact_Details_04 - Step 7: Input New Value in Field 'State/Province'");
		myInfoPage.inputToTextboxByID(driver, "contact_province", province);
		
		log.info("Contact_Details_04 - Step 8: Input New Value in Field 'Zip/Postal Code'");
		myInfoPage.inputToTextboxByID(driver, "contact_emp_zipcode", postalCode);
		
		log.info("Contact_Details_04 - Step 9: Input New Value in Field 'Country'");
		myInfoPage.selectDropdownByID(driver, "contact_country", country);
		
		log.info("Contact_Details_04 - Step 10: Input New Value in Field 'Mobil'");
		myInfoPage.inputToTextboxByID(driver, "contact_emp_mobile", mobile);
		
		log.info("Contact_Details_04 - Step 11: Input New Value in Field 'Work Email'");
		myInfoPage.inputToTextboxByID(driver, "contact_emp_work_email", workEmail);
		
		log.info("Contact_Details_04 - Step 12: Click to 'Save' button");
		myInfoPage.clickToButtonById(driver, "btnSave");
		
		log.info("Contact_Details_04 - Step 13: Verify return message is successful");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Saved"));
		
		log.info("Contact_Details_04 - Step 14: Verify New Value in Field 'Address Street 1'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "contact_street1"), address_1);
		
		log.info("Contact_Details_04 - Step 15: Verify New Value in Field 'Address Street 2'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "contact_street2"), address_2);
		
		log.info("Contact_Details_04 - Step 16: Verify New Value in Field 'City'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "contact_city"), city);
		
		log.info("Contact_Details_04 - Step 17: Verify New Value in Field 'State/Province'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "contact_province"), province);
	
		log.info("Contact_Details_04 - Step 18: Verify New Value in Field 'Zip/Postal Code'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "contact_emp_zipcode"), postalCode);
		
		log.info("Contact_Details_04 - Step 19: Verify 'United States' in Field Dropdown 'Country' After Select ");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "contact_country"), country);
		
		log.info("Contact_Details_04 - Step 20: Verify New Value in Field 'Mobil'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "contact_emp_mobile"), mobile);
		
		log.info("Contact_Details_04 - Step 21: Verify New Value in Field 'Work Email'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "contact_emp_work_email"), workEmail);

	}

	@Test
	public void Employee_05_Emergency_Details() {
		
		log.info("Emergency_Details_05 - Step 1: Open side bar 'Emergency_Details'");
		myInfoPage.openAtSideBarTabByName(driver, "Emergency Contacts");
		
		log.info("Emergency_Details_05 - Step 3: Click To 'Add' Button");
		myInfoPage.clickToButtonById(driver, "btnAddContact");
		
		log.info("Emergency_Details_05 - Step 4: Input New Value in Field 'Name'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_name", nameContact);
		
		log.info("Emergency_Details_05 - Step 5: Input New Value in Field 'Relationship'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_relationship", relationship);
		
		log.info("Emergency_Details_05 - Step 6: Input New Value in Field 'Home Telephone'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_homePhone", homeTelephone);
		
		log.info("Emergency_Details_05 - Step 7: Input New Value in Field 'Mobile'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_mobilePhone", mobileContact);
		
		log.info("Emergency_Details_05 - Step 8: Input New Value in Field 'Work Telephone'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_workPhone", telephoneWork);
		
		log.info("Emergency_Details_05 - Step 9: Click to 'Save' button");
		myInfoPage.clickToButtonById(driver, "btnSaveEContact");
		
		log.info("Emergency_Details_05 - Step 10: Verify Employee Infomation is display at 'Result Table'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Name", "1"), nameContact);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Relationship", "1"), relationship);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Home Telephone", "1"), homeTelephone);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Mobile", "1"), mobileContact);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Work Telephone", "1"), telephoneWork);
		
		log.info("Emergency_Details_05 - Step 3: Click To 'Add' Button");
		myInfoPage.clickToButtonById(driver, "btnAddContact");
		
		log.info("Emergency_Details_05 - Step 4: Input New Value 2 in Field 'Name'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_name", nameContact1);
		
		log.info("Emergency_Details_05 - Step 5: Input New Value 2 in Field 'Relationship'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_relationship", relationship1);
		
		log.info("Emergency_Details_05 - Step 6: Input New Value 2 in Field 'Home Telephone'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_homePhone", homeTelephone1);
		
		log.info("Emergency_Details_05 - Step 7: Input New Value 2 in Field 'Mobile'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_mobilePhone", mobileContact1);
		
		log.info("Emergency_Details_05 - Step 8: Input New Value 2 in Field 'Work Telephone'");
		myInfoPage.inputToTextboxByID(driver, "emgcontacts_workPhone", telephoneWork1);
		
		log.info("Emergency_Details_05 - Step 9: Click to 'Save' button");
		myInfoPage.clickToButtonById(driver, "btnSaveEContact");
		
		log.info("Emergency_Details_05 - Step 15: Verify Employee Infomation is display at 'Result Table'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Name", "2"), nameContact);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Relationship", "2"), relationship);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Home Telephone", "2"), homeTelephone);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Mobile", "2"), mobileContact);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Work Telephone", "2"), telephoneWork);
		
		log.info("Emergency_Details_05 - Step 15: Verify Employee Infomation is display at 'Result Table'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Name", "1"), nameContact1);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Relationship", "1"), relationship1);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Home Telephone", "1"), homeTelephone1);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Mobile", "1"), mobileContact1);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "emgcontact_list", "Work Telephone", "1"), telephoneWork1);
		
		log.info("Emergency_Details_05 - Step 16: Select Checkbox to deleted the Each Row at 'Result Table'  ");
		myInfoPage.clickToCheckboxAtRowIndex(driver,"emgcontact_list", "1");
		
		log.info("Emergency_Details_05 - Step 17: Click To 'Delete' Button ");
		myInfoPage.clickToButtonById(driver, "delContactsBtn");
		
		log.info("Emergency_Details_05 - Step 18: Select Checkbox to deleted the All Row at 'Result Table'  ");
		myInfoPage.selectAllAtTable(driver,"emgcontact_list");
		
		log.info("Emergency_Details_05 - Step 19: Click To 'Delete' Button");
		myInfoPage.clickToButtonById(driver, "delContactsBtn");
		
	}

	@Test
	public void Employee_06_Assigned_Dependents() {
		
		log.info("Dependents_06 - Step 1: Open side bar 'Dependents'");
		myInfoPage.openAtSideBarTabByName(driver, "Dependents");
		
		log.info("Dependents_06 - Step 2: Click to 'Add' Button");
		myInfoPage.clickToButtonById(driver, "btnAddDependent");
		
		log.info("Dependents_06 - Step 3: Input New Value in Field 'Name'");
		myInfoPage.inputToTextboxByID(driver, "dependent_name", nameDep);
		
		log.info("Dependents_06 - Step 4: Input New Value in Field 'Relationship'");
		myInfoPage.selectDropdownByID(driver, "dependent_relationshipType", relationshipDep);
		
		log.info("Dependents_06 - Step 5: Input New Value in Field 'Date of Birth' of Dependents");
		myInfoPage.inputToTextboxByID(driver, "dependent_dateOfBirth", dayOfBirthDep);
		
		log.info("Dependents_06 - Step 6: Click to 'Save' button");
		myInfoPage.clickToButtonById(driver, "btnSaveDependent");
		
		log.info("Dependents_06 - Step 7: Verify return message is successful");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Saved"));
		
		log.info("Dependents_06 - Step 8: Verify Employee Infomation is display at 'dependent_list'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Name", "1"), nameDep);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Relationship", "1"), relationshipDep);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Date of Birth", "1"), dayOfBirthDep);
		
		log.info("Dependents_06 - Step 9: Click to 'Add' button");
		myInfoPage.clickToButtonById(driver, "btnAddDependent");
		
		log.info("Dependents_06 - Step 10: Input New Value in Field 'Name' to Add Dependent");
		myInfoPage.inputToTextboxByID(driver, "dependent_name", nameDep1);
		
		log.info("Dependents_06 - Step 11: Input New Value in Field 'Relationship' to Add Dependent");
		myInfoPage.selectDropdownByID(driver, "dependent_relationshipType", relationshipDep1);
		
		log.info("Dependents_06 - Step 12: Input New Value in Field 'Please Specify' to Add Dependent");
		myInfoPage.inputToTextboxByID(driver, "dependent_relationship", pleaseSpecify);
		
		log.info("Dependents_06 - Step 13: Input New Value in Field 'Date of Birth' to Add Dependent");
		myInfoPage.inputToTextboxByID(driver, "dependent_dateOfBirth", dayOfBirthDep1);
		
		log.info("Dependents_06 - Step 14: Click to 'Save' button");
		myInfoPage.clickToButtonById(driver, "btnSaveDependent");
		
		log.info("Dependents_06 - Step 15: Verify return message is successful");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Saved"));
		
		log.info("Dependents_06 - Step 16: Verify Employee Infomation is display at 'dependent_list'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Name", "1"), nameDep1);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Relationship", "1"), relationshipDep1);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Date of Birth", "1"), dayOfBirthDep1);
		
		log.info("Dependents_06 - Step 17: Verify Employee Infomation is display at 'dependent_list'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Name", "2"), nameDep);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Relationship", "2"), relationshipDep);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "dependent_list", "Date of Birth", "2"), dayOfBirthDep);

		log.info("Dependents_06 - Step 18: Select Checkbox to deleted the Each Row at 'Result Table'  ");
		myInfoPage.clickToCheckboxAtRowIndex(driver,"dependent_list", "1");
		
		log.info("Dependents_06 - Step 19: Click To 'Delete' Button ");
		myInfoPage.clickToButtonById(driver, "delDependentBtn");
		
		log.info("Dependents_06 - Step 20: Select Checkbox to deleted the All Row at 'Result Table'  ");
		myInfoPage.selectAllAtTable(driver,"dependent_list");
		
		log.info("Dependents_06 - Step 21: Click To 'Delete' Button");
		myInfoPage.clickToButtonById(driver, "delDependentBtn");

	}
	
	@Test
	public void Employee_07_Update_Immigration() {
		
		log.info("Update_Immigration_07 - Step 1: Open side bar 'Immigration'");
		myInfoPage.openAtSideBarTabByName(driver, "Immigration");
		
		log.info("Update_Immigration_07 - Step 2: Click to 'Add' button");
		myInfoPage.clickToButtonById(driver, "btnAdd");;
		
		log.info("Update_Immigration_07 - Step 3: Select Field 'Passport'");
		myInfoPage.clickToRadioButtonByLabel(driver, "Passport");
		
		log.info("Update_Immigration_07 - Step 4: Input New Value in Field 'Number'");
		myInfoPage.inputToTextboxByID(driver, "immigration_number", numberImmigration);
		
		log.info("Update_Immigration_07 - Step 5: Input New Value in Field 'Issued Date' of Immigration");
		myInfoPage.inputToTextboxByID(driver, "immigration_passport_issue_date", issuedDate);
		
		log.info("Update_Immigration_07 - Step 6: Select 'Finland' Value in Field 'Issued By' of Immigration");
		myInfoPage.selectDropdownByID(driver, "immigration_country", issuedBy);
		
		log.info("Update_Immigration_07 - Step 7: Input New Value in Field 'Comments' of Immigration");
		myInfoPage.inputToTextboxByID(driver, "immigration_comments", comments);
		
		log.info("Update_Immigration_07 - Step 8: Click to 'Save' button");
		myInfoPage.clickToButtonById(driver, "btnSave");
		
		log.info("Update_Immigration_07 - Step 9: Verify return message is successful");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Saved"));
		
		log.info("Update_Immigration_07 - Step 10: Verify Employee Infomation is display at 'Assigned Immigration Records'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Document", "1"), "Passport");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Number", "1"), numberImmigration);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Issued By", "1"), issuedBy);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "", "Issued Date", "1"), issuedDate);
	
	}

	@Test
	public void Employee_08_Edit_View_Job() {
		
		log.info("Edit_View_Job_08 - Step 01: Open side bar 'Job'");
		myInfoPage.openAtSideBarTabByName(driver, "Job");
		
		log.info("Edit_View_Job_08 - Step 02: Verify Field 'Job' form is disable");
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"job_job_title"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"job_emp_status"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"job_joined_date"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"job_sub_unit"));
		verifyFalse(myInfoPage.isFieldEnableByName(driver,"job_contract_start_date"));
		verifyEquals(myInfoPage.returnMessagenotDefinedLabelByID(driver,"Job Specification","notDefinedLabel"), "Not Defined");
		verifyEquals(myInfoPage.returnMessagenotDefinedLabelByID(driver,"Contract Details","notDefinedLabel"), "Not Defined");
		
		log.info("Edit_View_Job_08 - Step 03: Logout page");
		loginPage=employeeListPage.logoutToSystem(driver);
		
		log.info("Edit_View_Job_08 - Step 04: Login with Admin role");
		dashboardPage=loginPage.loginToSystem(driver, usernameAdmin,passwordAdmin);
		
		log.info("Edit_View_Job_08 - Step 05: Open 'Employee List' Page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		
		log.info("Edit_View_Job_08 - Step 06: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.inputToTextboxByID(driver, "empsearch_employee_name_empName",fullnameUser);
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Edit_View_Job_08 - Step 07: Click to 'Search' button");
		employeeListPage.clickToButtonById(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Edit_View_Job_08 - Step 08: Verify Employee Infomation is display at 'Result Table'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), empFirstname);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), empLastnameUser);
		
		log.info("Edit_View_Job_08 - Step 09: Click to 'Id' of Value in Table");
		employeeListPage.clickToValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1");
		
		log.info("Edit_View_Job_08 - Step 10: Open side bar 'Job'");
		employeeListPage.openAtSideBarTabByName(driver, "Job");
		
		log.info("Edit_View_Job_08 - Step 11: Click To 'Edit' Button");
		employeeListPage.clickToButtonById(driver, "btnSave");
		
		log.info("Edit_View_Job_08 - Step 12: Select 'Automation Tester' Value into Field 'Job Title'");
		employeeListPage.selectDropdownByID(driver, "job_job_title", jobTitle);
		
		log.info("Edit_View_Job_08 - Step 13: Select 'Full-Time Contract' Value into Field 'Employment Status'");
		employeeListPage.selectDropdownByID(driver, "job_emp_status", employmentStatus);
		
		log.info("Edit_View_Job_08 - Step 14: Input Time Into Field 'Joined Date'");
		employeeListPage.inputToTextboxByID(driver, "job_joined_date", joinedDate);
		
		log.info("Edit_View_Job_08 - Step 15: Input Time Into Field 'Start Date'");
		employeeListPage.inputToTextboxByID(driver, "job_contract_start_date", startDate);
		
		log.info("Edit_View_Job_08 - Step 16: Click To 'Save' Button");
		employeeListPage.clickToButtonById(driver, "btnSave");
		
		log.info("Edit_View_Job_08 - Step 17: Verify return message is successful");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Updated"));
		
		
		log.info("Edit_View_Job_08 - Step 18: Verify 'Automation Tester' Value into Field Dropdown 'Job Title'");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "job_job_title"), jobTitle);
		
		log.info("Edit_View_Job_08 - Step 19: Verify 'Full-Time Contract' Value into Field Dropdown 'Employment Status'");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "job_emp_status"), employmentStatus);
		
		
		log.info("Edit_View_Job_08 - Step 20: Verify  Time Into Field 'Joined Date'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "job_joined_date"), joinedDate);
		
		log.info("Edit_View_Job_08 - Step 21: Verify Time Into Field 'Start Date'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "job_contract_start_date"), startDate);
		
		verifyEquals(myInfoPage.returnMessagenotDefinedLabelByID(driver,"Job Specification","notDefinedLabel"), "Not Defined");
		verifyEquals(myInfoPage.returnMessagenotDefinedLabelByID(driver,"Contract Details","notDefinedLabel"), "Not Defined");
		
		log.info("Edit_View_Job_08 - Step 22: Logout page");
		loginPage=employeeListPage.logoutToSystem(driver);
		
		log.info("Edit_View_Job_08 - Step 23: Login with User role");
		dashboardPage=loginPage.loginToSystem(driver, empUsername,empPasswod);
		
		log.info("Edit_View_Job_08 - Step 24: Click to 'My Info'");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage= PageGenerator.getMyInfoPage(driver);
		
		log.info("Edit_View_Job_08 - Step 25: Open side bar 'Job'");
		myInfoPage.openAtSideBarTabByName(driver, "Job");
		
		log.info("Edit_View_Job_08 - Step 26: Verify 'Automation Tester' Value into Field Dropdown 'Job Title'");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "job_job_title"), jobTitle);
		
		log.info("Edit_View_Job_08 - Step 27: Verify 'Full-Time Contract' Value into Field Dropdown 'Employment Status'");
		verifyEquals(myInfoPage.getValueDropdownByID(driver, "job_emp_status"), employmentStatus);
		
		
		log.info("Edit_View_Job_08 - Step 28: Verify  Time Into Field 'Joined Date'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "job_joined_date"), joinedDate);
		
		log.info("Edit_View_Job_08 - Step 29: Verify Time Into Field 'Start Date'");
		verifyEquals(myInfoPage.getValueTextboxByID(driver, "job_contract_start_date"), startDate);
		
		verifyEquals(myInfoPage.returnMessagenotDefinedLabelByID(driver,"Job Specification","notDefinedLabel"), "Not Defined");
		verifyEquals(myInfoPage.returnMessagenotDefinedLabelByID(driver,"Contract Details","notDefinedLabel"), "Not Defined");
		
		
	}

	@Test
	public void Employee_09_Edit_View_Salary() {
	
		log.info("Edit_View_Salary_09 - Step 01: Logout page");
		loginPage=employeeListPage.logoutToSystem(driver);
		
		log.info("Edit_View_Salary_09 - Step 02: Login with Admin role");
		dashboardPage=loginPage.loginToSystem(driver, usernameAdmin,passwordAdmin);
		
		log.info("Edit_View_Salary_09 - Step 03: Open 'Employee List' Page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage=PageGenerator.getEmployeeListPage(driver);
		
		
		log.info("Edit_View_Salary_09 - Step 04: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.inputToTextboxByID(driver, "empsearch_employee_name_empName",fullnameUser);
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Edit_View_Salary_09 - Step 05: Click to 'Search' button");
		employeeListPage.clickToButtonById(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		
		log.info("Edit_View_Salary_09 - Step 06: Click to 'Id' of Value in Table");
		employeeListPage.clickToValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1");
	
		log.info("Edit_View_Salary_09 - Step 07: Open side bar 'Salary'");
		employeeListPage.openAtSideBarTabByName(driver, "Salary");
		
		log.info("Edit_View_Salary_09 - Step 08: Click To 'Add' Button");
		employeeListPage.clickToButtonById(driver, "addSalary");
		
		log.info("Edit_View_Salary_09 - Step 09: Select Value 'Grade 14' in Field 'Pay Grade'");
		employeeListPage.selectDropdownByID(driver, "salary_sal_grd_code", payGrade);
		
		log.info("Edit_View_Salary_09 - Step 10: Input New Value in Field 'Salary Component'");
		employeeListPage.inputToTextboxByID(driver, "salary_salary_component", salaryComponent);
		
		log.info("Edit_View_Salary_09 - Step 11: Select Value 'United States Dollar' in Field 'Currency'");
		employeeListPage.selectDropdownByID(driver, "salary_currency_id", currency);
		
		log.info("Edit_View_Salary_09 - Step 12: Input New Value in Field 'Amount'");
		employeeListPage.inputToTextboxByID(driver, "salary_basic_salary", amountSalary);
		
		log.info("Edit_View_Salary_09 - Step 13: Click to 'Add Direct Deposit Details' Checkbox");
		employeeListPage.clickToCheckboxByLabel(driver, "Add Direct Deposit Details");
		
		log.info("Edit_View_Salary_09 - Step 14: Input New Value in Field 'Account Number'in Add Direct Deposit Details' Checkbox");
		employeeListPage.inputToTextboxByID(driver, "directdeposit_account", accountNumber);
		
		log.info("Edit_View_Salary_09 - Step 15: Select Value 'SAVINGS' in Field 'Account Type' in Add Direct Deposit Details' Checkbox");
		employeeListPage.selectDropdownByID(driver, "directdeposit_account_type", accountType);
		
		log.info("Edit_View_Salary_09 - Step 16: Input New Value in Field 'Routing Number'in Add Direct Deposit Details' Checkbox");
		employeeListPage.inputToTextboxByID(driver, "directdeposit_routing_num", routingNumber);
		
		log.info("Edit_View_Salary_09 - Step 17: Input New Value in Field 'Amount' in Add Direct Deposit Details' Checkbox");
		employeeListPage.inputToTextboxByID(driver, "directdeposit_amount", amount);
		
		log.info("Edit_View_Salary_09 - Step 18: Click to 'Save' Button");
		employeeListPage.clickToButtonById(driver, "btnSalarySave");
		
		log.info("Edit_View_Salary_09 - Step 19: Verify return message is successful");
		verifyTrue(myInfoPage.isDisplayMessageUpdatedSuccess(driver, "Successfully Saved"));
		
		log.info("Edit_View_Salary_09 - Step 20: Verify Salary Infomation is display at 'tblSalary'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "tblSalary", "Salary Component", "1"), salaryComponent);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "tblSalary", "Currency", "1"), currency);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "tblSalary", "Amount", "1"), amountSalary);
		
		
		log.info("Edit_View_Salary_09 - Step 21: Click to Checkbox of column 'Show Direct Deposit Details' in Table 'tblSalary'");
		employeeListPage.clickToCheckboxInTableIDAtColumnNameAndRowIndex(driver, "tblSalary", "Show Direct Deposit Details", "1");
		
		log.info("Edit_View_Salary_09 - Step 22: Verify Direct Deposit Details Infomation is display at 'tblSalary'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndexInside(driver, "tblSalary", "2", "1"), accountNumber);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndexInside(driver, "tblSalary","2", "2"), accountType);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndexInside(driver, "tblSalary","2", "3"), routingNumber);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndexInside(driver, "tblSalary","2", "4"), amount);
	
		
		log.info("Edit_View_Salary_09 - Step 23: Logout page");
		loginPage=employeeListPage.logoutToSystem(driver);
		
		log.info("Edit_View_Salary_09 - Step 24: Login with User role");
		dashboardPage=loginPage.loginToSystem(driver, empUsername,empPasswod);
		
		log.info("Edit_View_Salary_09 - Step 25: Click to 'My Info'");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage= PageGenerator.getMyInfoPage(driver);
		
		log.info("Edit_View_Salary_09 - Step 26: Open side bar 'Salary'");
		myInfoPage.openAtSideBarTabByName(driver, "Salary");
		
		log.info("Edit_View_Salary_09 - Step 27: Verify Salary Infomation is display at 'tblSalary'");
		verifyEquals(employeeListPage.getValueInMainTableIDAtColumnSalaryComponentRowIndexUserPage(driver, "tblSalary", "1"), salaryComponent);
		verifyEquals(employeeListPage.getValueInMainTableIDWithRowIndexAtColumnNameUserPage(driver,"tblSalary","1","currency"), currency);
		verifyEquals(employeeListPage.getValueInMainTableIDWithRowIndexAtColumnNameUserPage(driver,"tblSalary","1","amount"), amountSalary);

		log.info("Edit_View_Salary_09 - Step 28: Click to Checkbox of column 'Show Direct Deposit Details' in Table 'tblSalary'");
		employeeListPage.clickToCheckboxInMainTableByRowIndexUserPage(driver,"tblSalary","1");
		
		
		log.info("Edit_View_Salary_09 - Step 29: Verify Direct Deposit Details Infomation is display at 'tblSalary'");
		verifyEquals(employeeListPage.getValueInSubTableIDAtRowIndexAndColumnIndexUserPage(driver, "tblSalary", "2", "1"), accountNumber);
		verifyEquals(employeeListPage.getValueInSubTableIDAtRowIndexAndColumnIndexUserPage(driver, "tblSalary","2", "2"), accountType);
		verifyEquals(employeeListPage.getValueInSubTableIDAtRowIndexAndColumnIndexUserPage(driver, "tblSalary","2", "3"), routingNumber);
		verifyEquals(employeeListPage.getValueInSubTableIDAtRowIndexAndColumnIndexUserPage(driver, "tblSalary","2", "4"), amount);

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
