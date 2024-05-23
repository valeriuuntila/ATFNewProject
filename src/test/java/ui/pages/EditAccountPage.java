package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.general.actions.CommonActions;

import java.util.List;

public class EditAccountPage extends Page {
    @FindBy(xpath = "//h1[text()='My Account Information']")
    WebElement editAccountPage;
    //    @FindBy(xpath = "//input[@type='submit']")
//    private WebElement submit;
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement alertSuccessMessageContainer;
    @FindBy(xpath = "//label/following-sibling::div/input")
    private List<WebElement> inputFields;

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEditAccountPage() {
        return editAccountPage;
    }

    public void setInput(String inputName, String value) {
        CommonActions.sendKeys(getInputByName(inputName), value);
    }

    public WebElement getInputByName(String field) {
        return inputFields.stream()
                .filter(element -> element.getAttribute("placeholder").equals(field))
                .findFirst()
                .orElseThrow();
    }
}
