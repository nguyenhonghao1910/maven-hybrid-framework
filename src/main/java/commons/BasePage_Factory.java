package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//Common class
public class BasePage_Factory {
	
	public static BasePage_Factory getBasePageObject(){
		return new  BasePage_Factory();
	}
	
	protected void openPageUrl (WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageUrl(WebDriver driver) {
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
	
	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitFAlertorAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	protected void acceptAlert(WebDriver driver) {
		waitFAlertorAlertPresence(driver).accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		waitFAlertorAlertPresence(driver).dismiss();
	}
	
	protected String getAlertText(WebDriver driver) {
		return waitFAlertorAlertPresence(driver).getText();
	}
	
	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitFAlertorAlertPresence(driver).sendKeys(textValue);
		
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

	protected void sleepinsecond (long timeoutsecond) {

		try {Thread.sleep(timeoutsecond * 1000);}
		catch (InterruptedException e) {e.printStackTrace();}		
	}
	
	private By getByXpath(String xpathLocator ) {
		return By.xpath(xpathLocator);
	}
	
	private WebElement getWebElement(WebDriver driver, WebElement element) {
		return element;
	}
	
	private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(By.xpath(xpathLocator));
	}
	
	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	protected void sendkeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	protected String getElementText(WebDriver driver,  WebElement element){
		return element.getText();
	}
	
	protected void selecItemInDefaultDropdown(WebDriver driver, WebElement element , String textItem) {
		Select select = new Select(getWebElement(driver, element));
		select.selectByValue(textItem);
	}
	
	protected String getSelectedItemDefaultDropdown(WebDriver driver, WebElement element) {
		Select select = new Select(getWebElement(driver, element));
		return select.getFirstSelectedOption().getText();
	}
	
	protected Boolean isDropdownMutilple(WebDriver driver, WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}
	
	protected void selectItemincustomdropdown (WebDriver driver, WebElement element, String childXpath, String ExpectedTextItem ){
		element.click();;
		sleepinsecond(3);
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		List<WebElement> allitems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
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
	
	protected String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	protected String getTextElement(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	protected String getElementCssValue(WebDriver driver, WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}
	
	protected String getHexaColorFromGRBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	protected int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, WebElement element) {
		if (!element.isSelected());
		element.click();	
	}
	
	protected void uncheckToDefaultCheckbox(WebDriver driver, WebElement element) {
		if (element.isSelected());
		element.click();	
	}
	
	protected Boolean isElementDisplay(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	protected Boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}
	
	protected Boolean isElementEnable(WebDriver driver, WebElement element) {
		return element.isEnabled();
	}
	
	protected void switchToFrameIframe(WebDriver driver, WebElement element) {
		driver.switchTo().frame(getWebElement(driver, element));
	}
	
	protected void switchToDefaultContent(WebDriver driver, String xpathLocator) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions (driver);
		action.moveToElement(element).perform();
	}
	
	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void hightlightElement(WebDriver driver,WebElement element) {
		WebElement Element = getWebElement(driver, element);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String originalStyle = Element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", Element, "style", "border: 2px solid red; border-style: dashed;");
		sleepinsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", Element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();",getWebElement(driver, element));
	}

	protected void scrollToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, element));
	}

	protected void removeAttributeInDOM(WebDriver driver,WebElement element, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, element));
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

	protected String getElementValidationMessage(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, element));
	}

	protected boolean isImageLoaded(WebDriver driver,WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" "
				+ "&& arguments[0].naturalWidth > 0", getWebElement(driver,element));
	    if (status) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	protected void waitForElementVisible(WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForAllElementVisible(WebDriver driver,List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	protected void waitForElementInVisible(WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected void waitForAllElementInVisible(WebDriver driver,List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver , longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private long longTimeout=30;
	
}
