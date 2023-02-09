package commons;

import java.io.File;

public class GlobalConstants {
	
	public static final String USER_PAGE_NOPCOMMERCE_URL_TESTING="https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_NOPCOMMERCE_URL_TESTING="https://admin-demo.nopcommerce.com/";
	public static final String USER_PAGE_URL_STAGING="https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL_STAGING="https://admin-demo.nopcommerce.com/";
	
	public static final String PAGE_HRM_URL_TESTING="https://opensource-demo.orangehrmlive.com/";
	
	public static final String PAGE_SAUCELAB_URL_TESTING="https://www.saucedemo.com/";
	
	public static final String USER_PAGE_WORDPRESS_URL_TESTING="https://localhost/";
	public static final String ADMIN_PAGE_WORDPRESS_URL_TESTING="https://localhost/wp-admin/";
	
	public static final String PROJECT_PATH=System.getProperty("user.dir");
	public static final String UPLOADFILES = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOADFILES = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSERLOGS = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "Drap_And_Drop";
	public static final String AUTOIT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
	public static final String OS_NAME=System.getProperty("os.name");
	public static final String JAVA_VERSION=System.getProperty("java.version");
	public static final long  LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 5;
	public static final long RETRY_TEST_FAIL = 3;
	public static final String BD_TEST_URL = "192.168.1.24:9080";
	public static final String BD_TEST_USER = "TESTER";
	public static final String BD_TEST_PASSWORD = "P@SSW0RD123!@#";
	
	
	
	// Username (app)
	// Password (app)
	// User/ Pass (DB)
	// Server/ Environment
	//Timeout
	//Folder download/ upload
	//...

}
