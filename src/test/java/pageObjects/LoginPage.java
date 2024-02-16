package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class LoginPage extends Page{

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitLogin;

    public LoginPage() {
        super();

    }

}

