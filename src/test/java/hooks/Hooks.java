package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import scenario.context.ContextKeys;
import scenario.context.ScenarioContext;
import utils.driver.factory.WebDriverProvider;
import utils.screenshot.util.ScreenShotUtil;

import static utils.property.configurator.PropertyConfigurator.getProperty;


public class Hooks {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    @Before("@UI")
    public void before(Scenario scenario) {
        ScreenShotUtil.setScenario(scenario);
        String scenarioName = scenario.getName().trim().replaceAll(" ", "_");
        ThreadContext.put("scenarioName", scenarioName);
        Configurator.reconfigure();
        WebDriver driver =WebDriverProvider.getDriver();
//        webDriverProvider.initializeDriver();
        LogManager.getLogger().info("New driver instantiated");
        driver.get(getProperty("URL"));
        LogManager.getLogger().info("Web application launched");
        driver.manage().window().maximize();
        LogManager.getLogger().info("Window maximized");
        LogManager.getLogger().info("Starting scenario: " + scenario.getName());
        scenarioContext.setContext(ContextKeys.DRIVER, driver);
    }

    @Before("@API")
    public void beforeApi(Scenario scenario) {
        String scenarioName = scenario.getName().trim().replaceAll(" ", "_");
        ThreadContext.put("scenarioName", scenarioName);
        Configurator.reconfigure();
    }

    @AfterStep("@UI")
    public void afterStep(Scenario scenario)   {
        //validate if scenario has failed
        if (scenario.isFailed()) {
        ScreenShotUtil.takeScreenShot();
      }
    }

    @After("@UI")
    public void after(Scenario scenario) {
        LogManager.getLogger().info("Finished scenario: " + scenario.getName());
        ((WebDriver) scenarioContext.getContext(ContextKeys.DRIVER)).manage().deleteAllCookies();
        LogManager.getLogger().info("Deleting Cookies");
        WebDriverProvider.quitDriver();
        LogManager.getLogger().info("Driver closed");
        ScenarioContext.clearContext();
        LogManager.getLogger().info("Context cleared");
    }

}