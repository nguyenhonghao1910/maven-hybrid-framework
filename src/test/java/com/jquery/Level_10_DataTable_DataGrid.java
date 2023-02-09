package com.jquery;



import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.GlobalConstants;

import pageObject.jQuery.DataTable.HomePageObject;
import pageObject.jQuery.DataTable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browsername, String urlname ) {
		driver = getBrowserDriverUrl (browsername,urlname);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		homePage = PageGeneratorManager.getQueryHomePage(driver);
	}
	//@Test
	public void Table_01_Paging () {
		homePage.movePageNumer("2");
		homePage.sleepinsecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("2"));
		
		homePage.movePageNumer("3");
		homePage.sleepinsecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("3"));
		
		homePage.movePageNumer("8");
		homePage.sleepinsecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("8"));
		
		homePage.movePageNumer("18");
		homePage.sleepinsecond(1);
		Assert.assertTrue(homePage.isPageNumberActive("18"));
	}
	
	//@Test
	public void Table_02_Search_By_Input_Header_TextBox () {
		homePage.getPageUrl(driver);
		homePage.movePageNumer("8");
		homePage.inputValueHeaderTextbox("Country", "Finland");
		homePage.inputValueHeaderTextbox("Females", "29156");
		homePage.inputValueHeaderTextbox("Males", "30446");
		homePage.inputValueHeaderTextbox("Total", "59603");
		homePage.sleepinsecond(3);	
	}
	//@Test
	public void Table_03_Verify_Value_Table () {
		acctualAllValue=homePage.getValueEachRowAtAllPage();		 
		Assert.assertEquals(acctualAllValue, expectedAllValue);
		
		}
	@Test
	public void Table_04_Input_Value_In_Each_Row () {

		homePage.openTableData();
		homePage.sleepinsecond(1);

		homePage.inputValueToEachRow("Album","1","Hao Nguyen");
		homePage.sleepinsecond(1);
		homePage.inputValueToEachRow("Artist","1","Tony Hao");
		homePage.sleepinsecond(1);
		homePage.inputValueToEachRow("Year","1","2020");
		homePage.sleepinsecond(1);
		homePage.inputValueToEachRow("Price","1","50");
		homePage.sleepinsecond(1);

		homePage.selectValueToEachRow("Origin","2","US");
		homePage.sleepinsecond(3);

		homePage.checkValueToEachRow("With Poster?","3");
		homePage.sleepinsecond(3);
		homePage.uncheckValueToEachRow("With Poster?","2");
		homePage.sleepinsecond(3);

		homePage.updateRowInTable("1","Insert Row Above");
		homePage.sleepinsecond(3);
		homePage.updateRowInTable("1","Remove Current Row");
		homePage.sleepinsecond(3);
		homePage.updateRowInTable("1","Move Up");
		homePage.sleepinsecond(3);
		homePage.updateRowInTable("1","Move Down");
		homePage.sleepinsecond(3);



	}

	  @AfterClass
	  public void afterClass() {
		  //driver.quit();
	  }
	
	private WebDriver driver;
	private HomePageObject homePage;
	List<String> acctualAllValue;
	List<String> expectedAllValue;

}
