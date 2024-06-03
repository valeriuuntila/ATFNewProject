package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.waiter.Waiter;

public class AccountPage extends Page {
    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement openAccountPageTitle;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement alertSuccessMessageContainer;
    @FindBy(xpath = "//a[text()=' Edit your account information']")
    private WebElement editAccountIcon;

    public AccountPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getOpenAccountPageTitle() {
        return openAccountPageTitle;
    }
    public WebElement getAlertSuccessMessageContainer() {
        return alertSuccessMessageContainer;
    }
    public WebElement getEditAccountIcon() {
        return editAccountIcon;
    }
}
