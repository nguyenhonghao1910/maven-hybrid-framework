package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.hrm.DashboardPO;
import pageObject.hrm.LoginPO;
import pageObject.hrm.PageGenerator;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.UserHomePO;
import pageObjects.NopCommerce.User.UserAddressPageObject;
import pageObjects.NopCommerce.User.UserCustomerPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserOrdersPageObject;
import pageObjects.NopCommerce.User.UserRewardpointsPageObject;
import pageObjects.NopCommerce.admin.AdminLoginPageObject;
import pageUIs.NopCommerce.User.BasePageNopCommerceUI;
import pageUIs.hrm.BasePageHrmUI;
import pageUIs.hrm.MyInfoPageUI;


//Common class
/**
 * @author NguyenHongHao
 *
 */
/**
 * @author NguyenHongHao
 *
 */
public class BasePage {
	
	public static BasePage getBasePageObject(){
		return new  BasePage();
	}
	
	public void openPageUrl (WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();	
	}
	
	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();	
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();;
	}
	
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();;
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitForAlertorAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	protected void acceptAlert(WebDriver driver) {
		waitForAlertorAlertPresence(driver).accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		waitForAlertorAlertPresence(driver).dismiss();
	}
	
	protected String getAlertText(WebDriver driver) {
		return waitForAlertorAlertPresence(driver).getText();
	}
	
	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertorAlertPresence(driver).sendKeys(textValue);
		
	}
	
	protected void switchToWindowById(WebDriver driver,String WindowID) {
		Set<String> allwindow = driver.getWindowHandles();
		for (String id : allwindow) {
			if (!id.equals(WindowID)) {
				driver.switchTo().window(id);	
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver,String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(tabTitle)) {
				break;
			} 	
		}
		}
	
	protected void closeAllTabWithoutParent(WebDriver driver, String parentId) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentId)) {
				driver.switchTo().window(id);
				driver.close();
			}	
		}
		driver.switchTo().window(parentId);
	}
	
	protected void scrollToButtomPage(WebDriver driver){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void sleepinsecond (long timeoutsecond) {

		try {Thread.sleep(timeoutsecond * 1000);}
		catch (InterruptedException e) {e.printStackTrace();}		
	}
	
	/*
	 * private By getByXpath(String locatorType ) { return By.xpath(locatorType);
	 * }
	 */
	
	
	public By getByLocator(String locatorType) {
		By by = null;
			if (locatorType.startsWith("id=")||locatorType.startsWith("ID=")) {
				by = By.id(locatorType.substring(3));
			} else if (locatorType.startsWith("class=")) {
				by = By.className(locatorType.substring(6));	
			} else if (locatorType.startsWith("name=")) {
				by = By.name(locatorType.substring(5));	
			} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=")) {
				by = By.cssSelector(locatorType.substring(4));	
			} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=")) {
				by = By.xpath(locatorType.substring(6));	
			} else {
				throw new RuntimeException("Locator type is not support");
			}
	
		return by;
				
	}
	
	public String  getDynamicXpath(String locatorType,String...dynamicValue) {
		if (locatorType.startsWith("xpath")|| locatorType.startsWith("Xpath=")) {
		locatorType = String.format(locatorType, (Object[]) dynamicValue);
		}
		return locatorType;
	}
	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
	
	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	
	public void clickToElement(WebDriver driver, String locatorType ,String...dynamicValue) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String value) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(value);
	}
	
	public void clearValueInElementByDeleteKey(WebDriver driver, String locatorType ) {
		WebElement element = getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		
	}
	
	public void sendkeyToElement(WebDriver driver, String locatorType, String value,String...dynamicValue ) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		element.clear();
		element.sendKeys(value);
	}
	
	public String getElementText(WebDriver driver, String locatorType){
		return getWebElement(driver, locatorType).getText();
	}
	public String getElementText(WebDriver driver, String locatorType,String...dynamicValue){
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).getText();
	}
	
	public void selecItemInDefaultDropdown(WebDriver driver, String locatorType , String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	
	public void selecItemInDefaultDropdown(WebDriver driver, String locatorType , String textItem,String...dynamicValue ) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
		select.selectByVisibleText(textItem);
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType,String...dynamicValue ) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
		return select.getFirstSelectedOption().getText();
	}
	
	public Boolean isDropdownMutilple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}
	
	public Boolean isDropdownMutilple(WebDriver driver, String locatorType,String...dynamicValue) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
		return select.isMultiple();
	}
	
	public void selectItemincustomdropdown (WebDriver driver, String locatorType, String childXpath, String ExpectedTextItem ){
		getWebElement(driver, locatorType).click();;
		sleepinsecond(3);
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		List<WebElement> allitems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		System.out.println(allitems.size());
		for (WebElement item : allitems) {
			if (item.getText().trim().equals(ExpectedTextItem)) {
				if (!item.isDisplayed()) {
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
					sleepinsecond(1);
				}
				item.click();
				break;
			}
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName,String...dynamicValue) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).getAttribute(attributeName);
	}
	
	public String getTextElement(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	
	public String getTextElement(WebDriver driver, String locatorType,String...dynamicValue) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).getText();
	}
	
	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}
	
	public String getHexaColorFromGRBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}
	
	public int getElementSize(WebDriver driver, String locatorType, String...dynamicValue) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).size();
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
		element.click();	
		}
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType,String...dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		if (!element.isSelected()) {
		element.click();
		}
	}


	protected void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
		element.click();
		}
	}
	protected void uncheckToDefaultCheckbox(WebDriver driver, String locatorType,String...dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		if (element.isSelected()) {
		element.click();
		}
	}


	protected Boolean isElementDisplay(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}
	
	protected Boolean isElementDisplay(WebDriver driver, String locatorType,String...dynamicValue) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).isDisplayed();
	}
	public void overrideImplicitTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overrideImplicitTimeout(driver, longTimeout);
		if (elements.size()==0) {
			return true;
		}else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		}else {
			return false;
		}	
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType,String...dynamicValue) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		overrideImplicitTimeout(driver, longTimeout);
		if (elements.size()==0) {
			return true;
		}else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		}else {
			return false;
		}	
	}
	
	
	protected Boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	
	protected Boolean isElementSelected(WebDriver driver, String locatorType,String...dynamicValue) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).isSelected();
	}
	
	protected Boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	protected Boolean isElementEnable(WebDriver driver, String locatorType,String...dynamicValue) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).isEnabled();
	}
	
	
	protected void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	protected void switchToFrameIframe(WebDriver driver, String locatorType,String...dynamicValue) {
		driver.switchTo().frame(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
	}
	
	protected void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions (driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String locatorType,String...dynamicValue) {
		Actions action = new Actions (driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue))).perform();
	}
	
	protected void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions (driver);
		action.sendKeys(getWebElement(driver, locatorType),key).perform();
	}
	
	protected void pressKeyToElement(WebDriver driver, String locatorType, Keys key,String...dynamicValue ) {
		Actions action = new Actions (driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)),key).perform();
	}
	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void hightlightElement(WebDriver driver,String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepinsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	protected void hightlightElement(WebDriver driver,String locatorType,String...dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepinsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();",getWebElement(driver, locatorType));
	}
	
	protected void clickToElementByJS(WebDriver driver,String locatorType,String...dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();",getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
	}

	protected void scrollToElement(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}
	
	protected String getElementByJsXpath(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", "");
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	protected void removeAttributeInDOM(WebDriver driver,String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}
	
	public boolean isJQueryAjaxLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	protected boolean isImageLoaded(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" "
				+ "&& arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
	    if (status) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	protected boolean isImageLoaded(WebDriver driver,String locatorType,String...dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" "
				+ "&& arguments[0].naturalWidth > 0", getWebElement(driver,getDynamicXpath(locatorType, dynamicValue)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementVisible(WebDriver driver,String locatorType,String...dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}
	/*
	 * wait for element undisplayed in DOM or not in DOM and override implicit timeout*/
	public void waitForElementUndisplayed(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver , shortTimeout);
		overrideImplicitTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(driver, longTimeout);
	}

	
	public void waitForAllElementVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForAllElementVisible(WebDriver driver,String locatorType,String...dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}
	
	public void waitForElemenInVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	public void waitForElemenInVisible(WebDriver driver,String locatorType,String...dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}
	
	public void waitForAllElementInVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}
	
	public void waitForAllElementInVisible(WebDriver driver,String locatorType,String...dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValue))));
	}
	
	public void waitForElementClickable(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public void waitForElementClickable(WebDriver driver,String locatorType,String...dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}
	
	
	public void uploadMultipleFiles(WebDriver driver ,String... fileNames){
		String filePath = GlobalConstants.UPLOADFILES;
		String fullFileName="";
		for (String file: fileNames){
			fullFileName= fullFileName + filePath +file + "\n";
		}
		fullFileName=fullFileName.trim();
		getWebElement(driver, BasePageUI.UPLOAD_FILE).sendKeys(fullFileName);
	}
	
	public Set<Cookie> getAllCookie(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepinsecond(3);
	}
	
	public UserOrdersPageObject openOrdersPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.OPEN_ORDERS);
		clickToElement(driver, BasePageNopCommerceUI.OPEN_ORDERS);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}
	
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.OPEN_ADDRESS);
		clickToElement(driver, BasePageNopCommerceUI.OPEN_ADDRESS);
		return PageGeneratorManager.getUserAddressPage(driver) ;
	}
	
	public UserRewardpointsPageObject openRewardpointsPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.OPEN_REWARD_POINTS);
		clickToElement(driver, BasePageNopCommerceUI.OPEN_REWARD_POINTS);
		return PageGeneratorManager.getUserRewardpointsPage(driver);
	}
	
	public UserCustomerPageObject openCustomerinfoPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.OPEN_CUSTOMER_INFO);
		clickToElement(driver, BasePageNopCommerceUI.OPEN_CUSTOMER_INFO);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}

	public BasePage openPagesAtMyAccountByName(WebDriver driver,  String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver,  BasePageNopCommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerPage(driver);	
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);	
		case "Orders":
			return PageGeneratorManager.getUserOrdersPage(driver);	
		case "Reward points":;
		    return PageGeneratorManager.getUserRewardpointsPage(driver);
		default:
			throw new RuntimeException("Invalid page name");
		}
	}
	
	public void openPagesAtMyAccountByPageName(WebDriver driver,  String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver,  BasePageNopCommerceUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	}
	
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGOUT_BUTTON_USER_PAGE);
		clickToElement(driver, BasePageNopCommerceUI.LOGOUT_BUTTON_USER_PAGE);
		return PageGeneratorManager.getUserHomePage(driver);
	}
		
	public AdminLoginPageObject clickToLogoutLinkAdminPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGOUT_BUTTON_ADMIN_PAGE);
		clickToElement(driver, BasePageNopCommerceUI.LOGOUT_BUTTON_ADMIN_PAGE);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	
//	/**
////	 * Enter to dynamic Textbox by ID
////	 * <ul>
////	 * <li>Rest Parameter</li>
////	 * <li>Textbox by ID</li>
////	 * </ul>
////	 * @param driver
////	 * @param textboxID
////	 * @param value
////	 */
////	public void inputToTextboxByID(WebDriver driver,String textboxID, String value) {
////		waitForElemenIntVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
////		sendkeyToElement(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
////		
////	}
////	
////	/**
////	 * * Enter to button by text
////	 * <ul>
////	 * <li>Rest Parameter</li>
////	 * <li>Button by text</li>
////	 * </ul>
////	 * @param driver
////	 * @param buttonText
////	 */
////	public void clickToButtonByText(WebDriver driver,String buttonText) {
////		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
////		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
////	}
////	
////	/**
////	 * * * Dropdown by name
////	 * <ul>
////	 * <li>Rest Parameter</li>
////	 * <li>Button by text</li>
////	 * </ul>
////	 * @param driver
////	 * @param dropdownAttributeName
////	 * @param itemValue
////	 */
////	public void selectToDropdownByName(WebDriver driver,String dropdownAttributeName, String itemValue) {
////		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
////		selecItemInDefaultDropdown(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownAttributeName);
////		
////	}
////	
////	/**
////	 * Click to dynamic radio by label name
////	 * @param driver
////	 * @param radioLabelName
////	 */
////	public void clickToRadioButtonByLabel(WebDriver driver,String radioButtonLabelName) {
////		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
////		checkToDefaultCheckboxRadio(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
////		
////	}
////	
////
////	/**
////	 * Click to dynamic checkboox by label name
////	 * @param driver
////	 * @param checkboxLabelName
////	 */
////	public void clickToCheckboxByLabel(WebDriver driver, String checkboxLabelName) {
////		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
////		checkToDefaultCheckboxRadio(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
////		
////	}
////	
////	/**
////	 * Get value in textbox by ID
////	 * @param driver
////	 * @param textboxID
////	 * @return
////	 */
////	public String getTextboxValueById(WebDriver driver, String textboxID) {
////		waitForElemenIntVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
////		return getElementAttribute(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
////	}
////	
////	/**
////	 * Get value in dropdown by name
////	 * @param driver
////	 * @param dropdownAttributeName
////	 * @return
////	 */
////	public String getDropdownValueByName(WebDriver driver, String dropdownAttributeName) {
////		waitForElemenIntVisible(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
////		return getSelectedItemDefaultDropdown(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
////	}
////	
////	/**
////	 * Check to checkbox is selected
////	 * @param driver
////	 * @param checkboxLabelName
////	 * @return
////	 */
////	public boolean isCheckboxByLabel(WebDriver driver, String checkboxLabelName) {
////		waitForElemenIntVisible(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
////		return isElementSelected(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
////	}
////	
////
////	/**
////	 * check to radio is selected
////	 * @param driver
////	 * @param radioButtonLabelName
////	 * @return
////	 */
////	public boolean checkToRadioButtonByLabel(WebDriver driver, String radioButtonLabelName) {
////		waitForElemenIntVisible(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
////		return isElementSelected(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
////	}
////	
	//HRM
	
	/**
	 * Open Menu Page by name
	 * @param driver
	 * @param menuPageName
	 */
	public void openMenuPage(WebDriver driver, String menuPageName) {
		waitForElementClickable(driver,BasePageHrmUI.MENU_PAGE_NAME,menuPageName);
		clickToElement(driver,BasePageHrmUI.MENU_PAGE_NAME,menuPageName);
		isJQueryAjaxLoadedSuccess(driver);
	}
	
	/**
	 * Open sub menu page by name
	 * @param driver
	 * @param menuPageName
	 * @param menuSubPageName
	 */
	public void openSubMenuPage(WebDriver driver, String menuPageName,String menuSubPageName ) {
		waitForElementClickable(driver,BasePageHrmUI.MENU_PAGE_NAME,menuPageName);
		clickToElement(driver,BasePageHrmUI.MENU_PAGE_NAME,menuPageName);
		
		waitForElementClickable(driver,BasePageHrmUI.MENU_PAGE_NAME,menuSubPageName);
		clickToElement(driver,BasePageHrmUI.MENU_PAGE_NAME,menuSubPageName);
		
		isJQueryAjaxLoadedSuccess(driver);
	}
	
	/**
	 * Open child sub menu by name
	 * @param driver
	 * @param menuPageName
	 * @param menuSubPageName
	 * @param menuChildSubPageName
	 */
	public void openChildSubMenuPage(WebDriver driver, String menuPageName,String menuSubPageName,String menuChildSubPageName) {
		waitForElementClickable(driver,BasePageHrmUI.MENU_PAGE_NAME,menuPageName);
		clickToElement(driver,BasePageHrmUI.MENU_PAGE_NAME,menuPageName);
		
		waitForElementVisible(driver,BasePageHrmUI.MENU_PAGE_NAME,menuSubPageName);
		hoverMouseToElement(driver,BasePageHrmUI.MENU_PAGE_NAME,menuSubPageName);
		
		waitForElementClickable(driver,BasePageHrmUI.MENU_PAGE_NAME,menuChildSubPageName);
		clickToElement(driver,BasePageHrmUI.MENU_PAGE_NAME,menuChildSubPageName);
		
		isJQueryAjaxLoadedSuccess(driver);
	}
	

	/**
	 * Enter to Textbox by ID
	 * <ul>
	 * <li>Rest Parameter</li>
	 * <li>Textbox by ID</li>
	 * </ul>
	 * @param driver
	 * @param textboxID
	 * @param value
	 */
	public void inputToTextboxByID(WebDriver driver,String textboxID, String value) {
		waitForElementVisible(driver, BasePageHrmUI.TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BasePageHrmUI.TEXTBOX_BY_ID, value, textboxID);
	
	}
	
	/**
	 * Click to Button by ID
	 * @param driver
	 * @param buttonID
	 */
	public void clickToButtonById(WebDriver driver,String buttonID) {
		waitForElementClickable(driver, BasePageHrmUI.BUTTON_BY_ID, buttonID);
		clickToElement(driver, BasePageHrmUI.BUTTON_BY_ID, buttonID);
		
	}
	
	/**
	 * click to checkbox by label name
	 * @param driver
	 * @param CheckboxByName
	 */
	public void clickToCheckboxByLabel(WebDriver driver,String checkboxByLabelName) {
		waitForElementClickable(driver, BasePageHrmUI.CHECKBOX_BY_NAME, checkboxByLabelName);
		checkToDefaultCheckboxRadio(driver, BasePageHrmUI.CHECKBOX_BY_NAME, checkboxByLabelName);
		
	}
	
	/**
	 * click to radio by label name
	 * @param driver
	 * @param radioByLabelName
	 */
	public void clickToRadioButtonByLabel(WebDriver driver,String radioByLabelName) {
		waitForElementClickable(driver, BasePageHrmUI.RADIO_BY_NAME, radioByLabelName);
		checkToDefaultCheckboxRadio(driver, BasePageHrmUI.RADIO_BY_NAME, radioByLabelName);
	}
	
	
	/**
	 * select dropdown by id
	 * @param driver
	 * @param dropdownByID
	 * @param valueItem
	 */
	public void selectDropdownByID (WebDriver driver,String dropdownByID, String valueItem) {
		waitForElementClickable(driver, BasePageHrmUI.DROPDOWN_BY_ID, dropdownByID);
		selecItemInDefaultDropdown(driver, BasePageHrmUI.DROPDOWN_BY_ID, valueItem, dropdownByID);
	}
	
	/**
	 * get value from Textbox by Id
	 * @param driver
	 * @param textboxID
	 * @return
	 */
	public String getValueTextboxByID(WebDriver driver,String textboxID) {
		waitForElementVisible(driver, BasePageHrmUI.TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BasePageHrmUI.TEXTBOX_BY_ID, "value", textboxID);
		
	}
	
	/**
	 * get value from dropdown
	 * @param driver
	 * @param dropdownAttributeName
	 * @return
	 */
	public String getValueDropdownByID(WebDriver driver,String dropdownAttributeName) {
		waitForElementVisible(driver, BasePageHrmUI.DROPDOWN_BY_ID, dropdownAttributeName);
		return getSelectedItemDefaultDropdown(driver, BasePageHrmUI.DROPDOWN_BY_ID, dropdownAttributeName);
	}
	
	/**
	 * Check to Checkbox is select
	 * @param driver
	 * @param checkboxByLabelName
	 * @return
	 */
	public boolean isCheckboxByLabel(WebDriver driver,String checkboxByLabelName) {
		waitForElementVisible(driver, BasePageHrmUI.CHECKBOX_BY_NAME, checkboxByLabelName);
		return isElementSelected(driver, BasePageHrmUI.CHECKBOX_BY_NAME, checkboxByLabelName);
		
	}
	
	/**
	 * Check to Radio is select
	 * @param driver
	 * @param radioByLabelName
	 * @return
	 */
	public boolean isRadioButtonByLabel(WebDriver driver,String radioByLabelName) {
		waitForElementVisible(driver, BasePageHrmUI.RADIO_BY_NAME, radioByLabelName);
		return isElementSelected(driver, BasePageHrmUI.RADIO_BY_NAME, radioByLabelName);
		
	}

	/**
	 * get value from tabble by row
	 * @param driver
	 * @param tableID
	 * @param headerName
	 * @param rowIndex
	 * @return
	 */
	public String getValueInTableIDAtColumnNameAndRowIndex(WebDriver driver,String tableID,String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageHrmUI.TABLE_HEADER_BY_ID_BY_NAME, tableID,headerName) + 1;
		waitForElementVisible(driver, BasePageHrmUI.TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX, tableID,rowIndex,String.valueOf(columnIndex));
		return getTextElement(driver, BasePageHrmUI.TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX, tableID,rowIndex,String.valueOf(columnIndex));
			
	}
	
	public DashboardPO loginToSystem(WebDriver driver,String username, String password) {
		waitForElementVisible(driver, BasePageHrmUI.USERNAME_BY_ID);
		sendkeyToElement(driver, BasePageHrmUI.USERNAME_BY_ID, username);
		sendkeyToElement(driver, BasePageHrmUI.PASSWORD_BY_ID, password);
		clickToElement(driver, BasePageHrmUI.BUTTON_BY_LOGIN_ID);
		return PageGenerator.getDashboardPage(driver);
	}
	
	public LoginPO logoutToSystem(WebDriver driver) {
		waitForElementClickable(driver, BasePageHrmUI.ICON_LOGOUT_BY_ID);
		clickToElement(driver, BasePageHrmUI.ICON_LOGOUT_BY_ID);
		waitForElementClickable(driver, BasePageHrmUI.LOGOUT_BUTTON_BY_NAME);
		clickToElement(driver, BasePageHrmUI.LOGOUT_BUTTON_BY_NAME);
		return PageGenerator.getLoginPage(driver);
	}
	
	public boolean isDisplayMessageUpdatedSuccess(WebDriver driver , String valueResult) {
		waitForElementVisible(driver, BasePageHrmUI.UPDATE_INFO_SUCCESS, valueResult);
		return isElementDisplay(driver, BasePageHrmUI.UPDATE_INFO_SUCCESS, valueResult);
	}
	
	public void clickToCheckboxAtRowIndex(WebDriver driver, String tableID, String rowIndex) {
		waitForElementVisible(driver, BasePageHrmUI.SELECT_CHECKBOX_ROW_INDEX, tableID,rowIndex);
		checkToDefaultCheckboxRadio(driver, BasePageHrmUI.SELECT_CHECKBOX_ROW_INDEX, tableID,rowIndex);	
	}
	
	public void selectAllAtTable(WebDriver driver, String tableID) {
		waitForElementVisible(driver, BasePageHrmUI.SELECT_ALL_CHECKBOX, tableID);
		checkToDefaultCheckboxRadio(driver, BasePageHrmUI.SELECT_ALL_CHECKBOX, tableID);	
		
	}
	

	public String returnMessagenotDefinedLabelByID(WebDriver driver, String labelValue, String idName) {
		waitForElementVisible(driver, BasePageHrmUI.LABEL_NOT_DEFINED, labelValue,idName);
		return getTextElement(driver, BasePageHrmUI.LABEL_NOT_DEFINED, labelValue,idName);
	}

	public void clickToValueInTableIDAtColumnNameAndRowIndex(WebDriver driver, String tableID,String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageHrmUI.TABLE_HEADER_BY_ID_BY_NAME, tableID,headerName) + 1;
		waitForElementVisible(driver, BasePageHrmUI.TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX, tableID,rowIndex,String.valueOf(columnIndex));
		clickToElement(driver, BasePageHrmUI.TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX, tableID,rowIndex,String.valueOf(columnIndex));
	}
	
	public void openAtSideBarTabByName(WebDriver driver, String tabName) {
		waitForElementClickable(driver, MyInfoPageUI.TAB_SIDE_BAR_BY_NAME, tabName);
		clickToElement(driver, MyInfoPageUI.TAB_SIDE_BAR_BY_NAME, tabName);
		
	}
	
	public void clickToCheckboxInTableIDAtColumnNameAndRowIndex(WebDriver driver, String tableID, String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageHrmUI.TABLE_HEADER_BY_ID_BY_NAME, tableID,headerName) + 1;
		waitForElementVisible(driver, BasePageHrmUI.CHECKBOX_TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX, tableID,rowIndex,String.valueOf(columnIndex));
		clickToElement(driver, BasePageHrmUI.CHECKBOX_TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX, tableID,rowIndex,String.valueOf(columnIndex));
		
	}
	
	public String getValueInTableIDAtColumnNameAndRowIndexInside(WebDriver driver, String tableID, String tableIndex, String valueName) {
		waitForElementVisible(driver, BasePageHrmUI.TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX_INSIDE_TABLE, tableID,tableIndex,valueName);
		return getTextElement(driver, BasePageHrmUI.TABLE_ROW_BY_COLOMN_INDEX_AND_ROW_INDEX_INSIDE_TABLE, tableID,tableIndex,valueName);
	}
	
	public UserHomePO openEndUserUrl(WebDriver driver,String urlUser) {
		openPageUrl(driver, urlUser);
		return pageObject.wordpress.PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminDashboardPO openAdminUrl(WebDriver driver, String urlAdmin) {
		openPageUrl(driver, urlAdmin);
		return pageObject.wordpress.PageGeneratorManager.getAdminDashboardPage(driver);
	}

	
	private long longTimeout=GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout=GlobalConstants.SHORT_TIMEOUT;
	
	
	
}
