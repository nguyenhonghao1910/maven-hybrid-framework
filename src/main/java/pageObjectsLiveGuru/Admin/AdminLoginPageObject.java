package pageObjectsLiveGuru.Admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjectsLiveGuru.User.PageGeneratorManager;
import pageUIsLiveGuru.Admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver=driver;
    }

    public void inputToUsername(String userName) {
        waitForElementClickable(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX,userName);
    }

    public void inputToPassword(String passwordAdmin) {
        waitForElementClickable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX,passwordAdmin);
    }


    public AdminManageCustomerPageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.BUTTON_LOGIN);
        clickToElement(driver, AdminLoginPageUI.BUTTON_LOGIN);
        return PageGeneratorManager.getAdminManagerCustomerPage(driver);
    }

    public AdminManageCustomerPageObject loginIntoManageCustomer(String userName, String passwordAdmin) {
        inputToUsername(userName);
        inputToPassword(passwordAdmin);
        return clickToLoginButton();

    }
}
