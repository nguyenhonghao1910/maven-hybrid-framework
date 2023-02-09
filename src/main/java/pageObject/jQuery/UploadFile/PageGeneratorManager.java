package pageObject.jQuery.UploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePageUploadFile(WebDriver driver) {
		return new HomePageObject(driver);
	}
	

	

}
