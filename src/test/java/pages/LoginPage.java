package pages;

//import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


//@Getter
public class LoginPage extends Page{

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitLogin;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement alertMessageContainer;

    public LoginPage() {
        super();
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSubmitLogin() {
        return submitLogin;
    }

    public WebElement getAlertMessageContainer() {
        return alertMessageContainer;
    }

    public String getAlertMessage() {
        return alertMessageContainer.getText();
    }

}

