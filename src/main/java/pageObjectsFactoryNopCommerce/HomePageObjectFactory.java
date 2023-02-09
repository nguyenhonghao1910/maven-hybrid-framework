package pageObjectsFactoryNopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage_Factory;

public class HomePageObjectFactory extends BasePage_Factory {

		private WebDriver driver;
		
		public HomePageObjectFactory(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		@FindBy(xpath="//a[@class='ico-register']")
		private WebElement REGISTER_HOME;
		
		@FindBy(xpath="//a[@class='ico-login']")
		private WebElement LOGIN_HOME;
		
		@FindBy(xpath="//a[@class='ico-account']")
		private WebElement MY_ACCOUNT_HOME;
		
		public void clickToRegister() {
			waitForElementClickable(driver,REGISTER_HOME);
			clickToElement(driver, REGISTER_HOME);
		}

		public void clickToLoginLink() {
			waitForElementClickable(driver, LOGIN_HOME);
			clickToElement(driver, LOGIN_HOME);
		}

		public boolean isMyAccountDisplay() {
			waitForElementVisible(driver, MY_ACCOUNT_HOME);
			return isElementDisplay(driver, MY_ACCOUNT_HOME);
		}



	}

