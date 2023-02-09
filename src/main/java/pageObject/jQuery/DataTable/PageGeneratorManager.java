package pageObject.jQuery.DataTable;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getQueryHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	

	

}
