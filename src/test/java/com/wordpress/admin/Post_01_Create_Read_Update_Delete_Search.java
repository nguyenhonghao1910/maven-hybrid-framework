package com.wordpress.admin;

import commons.BaseTest;
import pageObject.wordpress.AdminCreatePostNewPO;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;
import pageObject.wordpress.UserPostSearchPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	String userName,password,titlePost,bodyPost,author,getDay,editTitlePost,editBodyPost;
	String postUrl ,urlAdmin,urlUser;
	@Parameters({"browser","urlAdmin","urlUser"})
	@BeforeClass
	public void beforeClass(String browsername, String urlAdmin,String urlUser) {
		this.urlAdmin=urlAdmin;
		this.urlUser=urlUser;
		driver = getBrowserDriverUrl(browsername,this.urlAdmin);
		adminLoginPage=PageGeneratorManager.getAdminLoginPage(driver);
		getDay=getCurrentDay();
		
		userName="seleniumfr";
		password="seleniumfr";
		titlePost="Automation" + randomNumber();
		bodyPost="Selenium WebDriver" + randomNumber();
		editTitlePost="Automation" + randomNumber();
		editBodyPost="Selenium WebDriver" + randomNumber();
		author="seleniumfr";
		
		log.info("Login_01 - Step 01: Input Value in UserName Textbox" + userName);
		adminLoginPage.inputValueUserNameTextbox(userName);
		
		log.info("Login_01 - Step 02: Input Value in Password Textbox" + password);
		adminLoginPage.inputValuePasswordTextbox(password);
		
		log.info("Login_01 - Step 03: Click to Button Login");
		adminDashboardPage=adminLoginPage.clickToButtonLogin();

	}

  @Test
  public void Post_01_Create_Post () {
	  log.info("Create_Post_01 - Step 01: Open 'Posts' Page");
	  adminPostSearchPage=adminDashboardPage.clickToPostSearchPage();
	  postUrl=adminPostSearchPage.getPageUrl(driver);
	  
	  log.info("Create_Post_01 - Step 02: Click to 'Add New' Button");
	  adminCreatePostNewPage=adminPostSearchPage.clickToAddNewButton();
	  
	  log.info("Create_Post_01 - Step 03: Close Popup When Open Create  Post New Page");
	  adminCreatePostNewPage.clickToPopup();
	  
	  log.info("Create_Post_01 - Step 03: Input Value in Title Post");
	  adminCreatePostNewPage.inputValueInTitlePost(titlePost);
	  
	  log.info("Create_Post_01 - Step 04: Input Value in Body Post");
	  adminCreatePostNewPage.inputValueInBodyPost(bodyPost);
	  
	  log.info("Create_Post_01 - Step 05: Click to 'Pre-Publish' Button");
	  adminCreatePostNewPage.clickToButtonPrePublish();
	  
	  log.info("Create_Post_01 - Step 06: Click to 'Publish' Button");
	  adminCreatePostNewPage.clickToButtonPublish();
	  
	  log.info("Create_Post_01 - Step 07: Click to 'Add New' Button");
	  verifyTrue(adminCreatePostNewPage.isDisplayCreatePostSuccess("Post published."));
  
  }
  
  @Test
  public void Post_02_Search_Post_And_View_Post () {
	  log.info("Search_Post_02 - Step 01: Open 'Search Post' Page");
	  adminCreatePostNewPage.openPageUrl(driver, postUrl);
	  adminPostSearchPage=PageGeneratorManager.getAdminPostSearchPage(driver);
	  
	  log.info("Search_View_Post_02 - Step 02: Input Value '" + titlePost +"' into Search Textbox ");
	  adminPostSearchPage.inputTitlePostIntoSearchTextbox(titlePost);
	  
	  log.info("Search_View_Post_02 - Step 03: Click to 'Search' Button");
	  adminPostSearchPage.clickToSearchButton();
	  
	  log.info("Search_View_Post_02 - Step 04: Verify Value Display in Column 'Title' of Table ");
	  verifyTrue(adminPostSearchPage.isDisplayValueBySearchTextbox("title",titlePost));
	  
	  log.info("Search_View_Post_02 - Step 04: Verify Value Display in Column 'Author' of Table ");
	  verifyTrue(adminPostSearchPage.isDisplayValueBySearchTextbox("author",author));
	  
	  log.info("Search_View_Post_02 - Step 01: Open 'EndUser' Url");
	  userHomePage=adminPostSearchPage.openEndUserUrl(driver, this.urlUser);
	  
	  log.info("Search_View_Post_02 - Step 01: Verify Post Info Display at Home Page");
	  verifyTrue(userHomePage.isPostInforDisplayTitlePost(titlePost));
	  verifyTrue(userHomePage.isPostInforDisplayBodyPost(titlePost,bodyPost));
	  verifyTrue(userHomePage.isPostInforDisplayAuthor(titlePost,author));
	  verifyTrue(userHomePage.isPostInforDisplayGetCurrentDay(titlePost,getDay));
	  
	  log.info("Search_View_Post_02 - Step 01: Click to Post Title");
	  userPostDetailPage=userHomePage.clickToPostTitle(titlePost);
	  
	  log.info("Search_View_Post_02 - Step 01: Verify Info Display at Post Detail Page");
	  verifyTrue(userPostDetailPage.isDetailPostInforDisplayTitlePost(titlePost));
	  verifyTrue(userPostDetailPage.isDetailPostInforDisplayBodyPost(titlePost,bodyPost));
	  verifyTrue(userPostDetailPage.isDetailPostInforDisplayAuthor(titlePost,author));
	  verifyTrue(userPostDetailPage.isDetailPostInforDisplayGetCurrentDay(titlePost,getDay));  
	  
  }
  
  @Test
  public void Post_03_Edit_Post () {
	  log.info("Edit_Post_03 - Step 01: Open 'Admin' Url");
	  adminDashboardPage=userPostDetailPage.openAdminUrl(driver, this.urlAdmin);
	  
	  log.info("Edit_Post_03 - Step 02: Open Post Search Page");
	  adminPostSearchPage=adminDashboardPage.clickToPostSearchPage();
	  
	  log.info("Edit_Post_03 - Step 03: Input Value '" + titlePost +"' into Search Textbox");
	  adminPostSearchPage.inputTitlePostIntoSearchTextbox(titlePost);
	  
	  log.info("Edit_Post_03 - Step 04: Click to 'Search' Button");
	  adminPostSearchPage.clickToSearchButton();
	  
	  log.info("Edit_Post_03 - Step 05: Click to Title Post");
	  adminCreatePostNewPage=adminPostSearchPage.clickToTitlePost("title",titlePost);
	  
	  log.info("Edit_Post_03 - Step 06: Edit '"+ editTitlePost +"' in Create Post New Page ");
	  adminCreatePostNewPage.inputValueInTitlePost(editTitlePost);
	  
	  
	  log.info("Edit_Post_03 - Step 07: Edit '"+ editBodyPost +"' in Create Post New Page ");
	  adminCreatePostNewPage.editValueInBodyPost(editBodyPost);
	  
	  log.info("Edit_Post_03 - Step 08: Click to 'Pre-Publish' Button ");
	  adminCreatePostNewPage.clickToButtonPrePublish();
	  
	  log.info("Edit_Post_03 - Step 09: Verify edit value Post successfull");
	  verifyTrue(adminCreatePostNewPage.isDisplayCreatePostSuccess("Post updated."));
	  
	  log.info("Edit_Post_03 - Step 10: Open 'Search Post' Page");
	  adminCreatePostNewPage.openPageUrl(driver, postUrl);
	  adminPostSearchPage=PageGeneratorManager.getAdminPostSearchPage(driver);
	  
	  log.info("Edit_Post_03 - Step 11: Input Value '" + editTitlePost +"' into Search Textbox ");
	  adminPostSearchPage.inputTitlePostIntoSearchTextbox(editTitlePost);
	  
	  log.info("Edit_Post_03 - Step 12: Click to 'Search' Button");
	  adminPostSearchPage.clickToSearchButton();
	  
	  log.info("Edit_Post_03 - Step 13: Verify Value Display in Column 'Title' of Table ");
	  verifyTrue(adminPostSearchPage.isDisplayValueBySearchTextbox("title",editTitlePost));
	  
	  log.info("Edit_Post_03 - Step 14: Verify Value Display in Column 'Author' of Table ");
	  verifyTrue(adminPostSearchPage.isDisplayValueBySearchTextbox("author",author));
	  
	  log.info("Edit_Post_03 - Step 15: Open 'EndUser' Url");
	  userHomePage=adminPostSearchPage.openEndUserUrl(driver, this.urlUser);
	  
	  log.info("Edit_Post_03 - Step 16: Verify Post Info Display at Home Page");
	  verifyTrue(userHomePage.isPostInforDisplayTitlePost(editTitlePost));
	  verifyTrue(userHomePage.isPostInforDisplayBodyPost(editTitlePost,editBodyPost));
	  verifyTrue(userHomePage.isPostInforDisplayAuthor(editTitlePost,author));
	  verifyTrue(userHomePage.isPostInforDisplayGetCurrentDay(editTitlePost,getDay));
	  
	  log.info("Edit_Post_03 - Step 17: Click to Post Title");
	  userPostDetailPage=userHomePage.clickToPostTitle(editTitlePost);
	  
	  log.info("Edit_Post_03 - Step 18: Verify Info Display at Post Detail Page");
	  verifyTrue(userPostDetailPage.isDetailPostInforDisplayTitlePost(editTitlePost));
	  verifyTrue(userPostDetailPage.isDetailPostInforDisplayBodyPost(editTitlePost,editBodyPost));
	  verifyTrue(userPostDetailPage.isDetailPostInforDisplayAuthor(editTitlePost,author));
	  verifyTrue(userPostDetailPage.isDetailPostInforDisplayGetCurrentDay(editTitlePost,getDay));    
	  
  }
  
  @Test
  public void Post_04_Delete_Post () {
	  
	  log.info("Delete_Post_04 - Step 01: Open 'Admin' Url");
	  adminDashboardPage=userPostDetailPage.openAdminUrl(driver, this.urlAdmin);
	  
	  log.info("Delete_Post_04 - Step 02: Open Post Search Page");
	  adminPostSearchPage=adminDashboardPage.clickToPostSearchPage();
	  
	  log.info("Delete_Post_04 - Step 03: Input Value '" + editBodyPost +"' into Search Textbox");
	  adminPostSearchPage.inputTitlePostIntoSearchTextbox(editBodyPost);
	  
	  log.info("Delete_Post_04 - Step 04: Click to 'Search' Button");
	  adminPostSearchPage.clickToSearchButton();
	  
	  log.info("Delete_Post_04 - Step 05: Select to checkbox Post Detail");
	  adminPostSearchPage.clickToCheckboxPost(editTitlePost);
	
	  log.info("Delete_Post_04 - Step 06: Click Move to Trash Item in Dropdown ");
	  adminPostSearchPage.clickToItemInDropdown("Move to Trash");
	  
	  log.info("Delete_Post_04 - Step 07: Click Apply Button ");
	  adminPostSearchPage.clickToApplyButton();
	  
	  log.info("Delete_Post_04 - Step 08: Verify '1 post moved to the Trash.' message is displayed");
	  verifyTrue(adminPostSearchPage.isDisplayDeleteMessageSuccess("1 post moved to the Trash."));
	  
	  log.info("Delete_Post_04 - Step 09: Input Value '" + editTitlePost +"' into Search Textbox ");
	  adminPostSearchPage.inputTitlePostIntoSearchTextbox(editTitlePost);
	  
	  log.info("Delete_Post_04 - Step 10: Click to 'Search' Button");
	  adminPostSearchPage.clickToSearchButton();
	  
	  log.info("Delete_Post_04 - Step 11: Verify 'No posts found.' message is displayed");
	  verifyTrue(adminPostSearchPage.isDisplayMessageAfterDeletePost("No posts found."));
	  
	  log.info("Delete_Post_04 - Step 12: Open 'EndUser' Url");
	  userHomePage=adminPostSearchPage.openEndUserUrl(driver, this.urlUser);
	  
	  log.info("Delete_Post_04 - Step 13: Verify Post Info Undisplay at Home Page");
	  verifyTrue(userHomePage.isPostInforUndisplayTitlePost(editTitlePost));
	  
	  log.info("Delete_Post_04 - Step 14: SendKey 'Title Post' value in Search TextBox");
	  userHomePage.sendkeyToSearchTextbox(editTitlePost);
	  
	  log.info("Delete_Post_04 - Step 15: Click To Search Button");
	  userPostSearch=userHomePage.clickToSearchButton();
	  
	  
	  log.info("Delete_Post_04 - Step 16: Verify 'Nothing Found' message is displayed");
	  verifyTrue(userPostSearch.isDisplayDeleteSuccess("Nothing Found"));
	    
  }
  

@AfterClass (alwaysRun = true)
  public void afterClass() {
	  closeBrowserAndDriver();
  }
	private WebDriver driver;
	AdminDashboardPO adminDashboardPage;
	AdminLoginPO adminLoginPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminCreatePostNewPO adminCreatePostNewPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserPostSearchPO userPostSearch;

}
