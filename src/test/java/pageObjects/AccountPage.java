package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class AccountPage extends Page {
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement OpenAccountPage;

    public AccountPage() {
        super();
    }
}
