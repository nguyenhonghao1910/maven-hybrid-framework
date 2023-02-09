package com.jquery;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.jQuery.UploadFile.HomePageObject;
import pageObject.jQuery.UploadFile.PageGeneratorManager;
import java.util.concurrent.TimeUnit;

public class Level_11_Upload_Files extends BaseTest {
	String upload_Hinh_1="Hinh_1.jpg";
	String upload_Hinh_2="Hinh_2.jpg";
	String upload_Hinh_3="Hinh_3.jpg";
	String[] mutilpleUploadFiles={ upload_Hinh_1,upload_Hinh_2,upload_Hinh_3};
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browsername, String urlname ) {
		driver = getBrowserDriverUrl (browsername,urlname);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		homePage = PageGeneratorManager.getHomePageUploadFile(driver);
	}
	@Test
	public void Upload_01_One_File_Per_Time () {
		homePage.uploadMultipleFiles(driver,upload_Hinh_1);
		Assert.assertTrue(homePage.isLoadFile(upload_Hinh_1));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isUpLoadFile(upload_Hinh_1));

		Assert.assertTrue(homePage.isUpLoadImageFile(upload_Hinh_1));



	}
	@Test
	public void Upload_02_Multi_File_Per_Time () {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver,mutilpleUploadFiles);
		Assert.assertTrue(homePage.isLoadFile(upload_Hinh_1));
		Assert.assertTrue(homePage.isLoadFile(upload_Hinh_2));
		Assert.assertTrue(homePage.isLoadFile(upload_Hinh_3));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isUpLoadFile(upload_Hinh_1));
		Assert.assertTrue(homePage.isUpLoadFile(upload_Hinh_2));
		Assert.assertTrue(homePage.isUpLoadFile(upload_Hinh_3));

		Assert.assertTrue(homePage.isUpLoadImageFile(upload_Hinh_1));
		Assert.assertTrue(homePage.isUpLoadImageFile(upload_Hinh_2));
		Assert.assertTrue(homePage.isUpLoadImageFile(upload_Hinh_3));

	}

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
	
	private WebDriver driver;
	private HomePageObject homePage;


}
