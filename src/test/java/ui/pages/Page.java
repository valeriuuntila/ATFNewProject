package ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public abstract class Page {
    @FindBy(xpath = "//input[@type='submit']")
    protected WebElement submit;
    public WebElement getSubmit() {
        return submit;
    }
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
