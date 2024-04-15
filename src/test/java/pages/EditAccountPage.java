package pages;

import actions.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditAccountPage extends Page {


    @FindBy(xpath = "//h1[text()='My Account Information']")
    WebElement EditAccountPage;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitContinue;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement alertSuccessMessageContainer;

    @FindBy(xpath = "//label/following-sibling::div/input")
    private List<WebElement> inputFields;

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEditAccountPage() {
        return EditAccountPage;
    }

    public WebElement getSubmitContinue() {
        return submitContinue;
    }

    public void setInput(String inputName, String value) {
        CommonActions.sendKeys(getInputByName(inputName), value);
    }

    public WebElement getInputByName(String name) {
        return inputFields.stream()
                .filter(element -> element.getAttribute("placeholder").equals(name))
                .findFirst()
                .orElseThrow();
    }

}
