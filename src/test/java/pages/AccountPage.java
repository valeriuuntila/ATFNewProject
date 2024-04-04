package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class AccountPage extends Page {
    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement openAccountPageTitle;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitContinue;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement alertSuccessMessageContainer;

    @FindBy(xpath = "//a[text()=' Edit your account information']")
    private WebElement editAccountIcon;

    public AccountPage() {
        super();
    }

    public WebElement getOpenAccountPageTitle() {
        return openAccountPageTitle;
    }
    public WebElement getSubmitContinue() {
        return submitContinue;
    }
    public WebElement getAlertSuccessMessageContainer() {
        return alertSuccessMessageContainer;
    }
    public WebElement getEditAccountIcon() {
        return editAccountIcon;
    }

}
