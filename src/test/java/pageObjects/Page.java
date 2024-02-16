package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import scenarioContext.ScenarioContext;

import static stepDefinitions.Hooks.driver;

public abstract class Page {

    private final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private WebElement webElement;

    public Page() {
        PageFactory.initElements(driver, this);
        scenarioContext.setCurrentPage(this);
    }

}
