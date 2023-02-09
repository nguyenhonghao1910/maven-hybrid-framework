package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {

	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver=driver;
	}


	public boolean isPostInforDisplayTitlePost(String titlePostValue) {
		waitForElementVisible(driver, UserHomePageUI.TITLE_POST, titlePostValue);
		return isElementDisplay(driver, UserHomePageUI.TITLE_POST, titlePostValue);
	}


	public boolean isPostInforDisplayBodyPost(String titlePost, String bodyPostValue) {
		waitForElementVisible(driver, UserHomePageUI.BOBY_POST, titlePost,bodyPostValue);
		return isElementDisplay(driver, UserHomePageUI.BOBY_POST, titlePost,bodyPostValue);
	}


	public boolean isPostInforDisplayAuthor(String titlePost, String authorValue) {
		waitForElementVisible(driver, UserHomePageUI.AUTHOR_POST, titlePost,authorValue);
		return isElementDisplay(driver, UserHomePageUI.AUTHOR_POST, titlePost,authorValue);
	}


	public boolean isPostInforDisplayGetCurrentDay(String titlePost, String getDayValue) {
		waitForElementVisible(driver, UserHomePageUI.TIME_CREATE_POST, titlePost,getDayValue);
		return isElementDisplay(driver, UserHomePageUI.TIME_CREATE_POST, titlePost,getDayValue);
	}


	public UserPostDetailPO clickToPostTitle(String titlePost) {
		waitForElementClickable(driver, UserHomePageUI.TITLE_POST,titlePost);
		clickToElement(driver, UserHomePageUI.TITLE_POST,titlePost);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}


	public boolean isPostInforUndisplayTitlePost(String editTitlePost) {
		return isElementUndisplayed(driver, UserHomePageUI.TITLE_POST, editTitlePost);
	}


	public void sendkeyToSearchTextbox(String editTitlePost) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, editTitlePost);
		
	}


	public UserPostSearchPO clickToSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserPostSearchPage(driver);
	}

}
