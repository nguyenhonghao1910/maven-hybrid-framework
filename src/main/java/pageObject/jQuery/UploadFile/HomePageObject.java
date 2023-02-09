package pageObject.jQuery.UploadFile;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.UploadFile.HomePageUI;

import java.util.List;

public class HomePageObject extends BasePage {
	
	WebDriver driver;

	public HomePageObject (WebDriver driver) {
		this.driver=driver;
	}


	public boolean isLoadFile(String valueName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED,valueName);
		return isElementDisplay(driver, HomePageUI.FILE_NAME_LOADED,valueName);

	}

	public void clickToStartButton() {
		List<WebElement> startButtons=getListWebElement(driver,HomePageUI.START_BUTTON);
		for (WebElement startButton: startButtons ){
			startButton.click();
			sleepinsecond(2);
		}
	}

	public boolean isUpLoadFile(String valueName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED,valueName);
		return isElementDisplay(driver, HomePageUI.FILE_NAME_UPLOADED,valueName);
	}

	public boolean isUpLoadImageFile(String valueName) {
		waitForElementVisible(driver, HomePageUI.IMAGE_FILE_NAME_UPLOADED,valueName);
		return isImageLoaded(driver, HomePageUI.IMAGE_FILE_NAME_UPLOADED,valueName);
	}
}


