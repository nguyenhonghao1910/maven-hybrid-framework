package pageUIs.wordpress;

public class UserPostDetailPageUI {
	
	public static final String TITLE_POST = "xpath=//article//h1[@class='entry-title' and text()='%s']";
	public static final String BODY_POST = "xpath=//article//h1[@class='entry-title' and text()='%s']//ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String AUTHOR_POST = "xpath=//article//h1[@class='entry-title' and text()='%s']/following-sibling::div//span/a[text()='%s']";
	public static final String TIME_CREATE_POST = "xpath=//article//h1[@class='entry-title' and text()='%s']/following-sibling::div//span/a/time[text()='%s']";

}
