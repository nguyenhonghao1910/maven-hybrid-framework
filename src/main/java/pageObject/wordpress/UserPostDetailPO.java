package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {
	
	WebDriver driver;
	
	public UserPostDetailPO (WebDriver driver) {
		this.driver=driver;
		
	}

	public boolean isDetailPostInforDisplayTitlePost(String titlePost) {
		waitForElementVisible(driver,UserPostDetailPageUI.TITLE_POST,titlePost);
		return isElementDisplay(driver,UserPostDetailPageUI.TITLE_POST,titlePost);
	}

	public boolean isDetailPostInforDisplayBodyPost(String titlePost, String bodyPostValue) {
		waitForElementVisible(driver, UserPostDetailPageUI.BODY_POST, titlePost,bodyPostValue);
		return isElementDisplay(driver, UserPostDetailPageUI.BODY_POST, titlePost,bodyPostValue);
	}

	public boolean isDetailPostInforDisplayAuthor(String titlePost, String authorValue) {
		waitForElementVisible(driver, UserPostDetailPageUI.AUTHOR_POST, titlePost,authorValue);
		return isElementDisplay(driver, UserPostDetailPageUI.AUTHOR_POST, titlePost,authorValue);
	}

	public boolean isDetailPostInforDisplayGetCurrentDay(String titlePost, String getDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.TIME_CREATE_POST, titlePost,getDay);
		return isElementDisplay(driver, UserPostDetailPageUI.TIME_CREATE_POST, titlePost,getDay);
	}


}
