package scenarioContext;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Page;

import static stepDefinitions.Hooks.driver;

public class ScenarioContext {

    private static ScenarioContext instance = null;

    private static Page currentPage;
    private Scenario scenario;
    private static WebElement webElement;

    private ScenarioContext() {
    }

    public static ScenarioContext getInstance() {
        if (instance == null) {
            return new ScenarioContext();
        } else return instance;
    }


    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        ScenarioContext.webElement = webElement;
    }

    public void setCurrentPage(Page currentPage) {
        ScenarioContext.currentPage = currentPage;
        PageFactory.initElements(driver, currentPage);
    }

    public Page getCurrentPage() {
        return currentPage;
    }


    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return scenario;
    }
}