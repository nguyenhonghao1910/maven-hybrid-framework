package pageObjectsLiveGuru.Admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIsLiveGuru.Admin.AdminManagerCustomerPageUI;

public class AdminManageCustomerPageObject extends BasePage {

    WebDriver driver;

    public AdminManageCustomerPageObject(WebDriver driver) {
        this.driver=driver;
    }


    public void closePopup() {
        waitForElementClickable(driver, AdminManagerCustomerPageUI.BUTTON_CLOSE_POPUP);
        clickToElement(driver, AdminManagerCustomerPageUI.BUTTON_CLOSE_POPUP);
    }

    public void inputValueInTextbox(String columnname, String value) {
        waitForElementClickable(driver, AdminManagerCustomerPageUI.INPUT_TEXTBOX,columnname);
        sendkeyToElement(driver,AdminManagerCustomerPageUI.INPUT_TEXTBOX,value,columnname);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver,AdminManagerCustomerPageUI.BUTTON_SEARCH);
        clickToElement(driver,AdminManagerCustomerPageUI.BUTTON_SEARCH);
    }

    public boolean isDisplayResult(String nameValue, String emailAddress) {
        waitForElementVisible(driver,AdminManagerCustomerPageUI.VERIFY_VALUE,nameValue,emailAddress);
        return isElementDisplay(driver,AdminManagerCustomerPageUI.VERIFY_VALUE,nameValue,emailAddress);
    }
}
