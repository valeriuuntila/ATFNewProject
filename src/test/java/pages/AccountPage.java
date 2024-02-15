package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement OpenAccountPage;

}
