package ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.general.actions.CommonActions;


//@Getter
public class LoginPage extends Page {
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement alertMessageContainer;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertMessage() {
        return alertMessageContainer.getText();
    }

    public void userLogin(String email, String password) {
        CommonActions.sendKeys(emailInput, email);
        CommonActions.sendKeys(passwordInput, password);
        CommonActions.clickOnWebElement(submit);
    }

    public void userSameLoginNTimes(String email, String password, int times) {
        for (int i = 0; i < times; i++) {
            userLogin(email, password);
        }
    }

}

