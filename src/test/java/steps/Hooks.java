package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import scenariocontext.ScenarioContext;
import utils.LogsConfig;
import utils.ScreenShotUtil;
import utils.driverFactory.WebDriverProvider;

import static utils.PropertyConfigurator.getProperty;


public class Hooks {
    private final WebDriverProvider webDriverProvider = new WebDriverProvider();

    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private static Logger logger = LogsConfig.getLogger();


    @Before("@UI")
    public void before(Scenario scenario) {
        ScreenShotUtil.setScenario(scenario);
        webDriverProvider.initializeDriver("chrome");
        scenarioContext.setContext("DRIVER", webDriverProvider.getDriver());
        logger.info("New driver instantiated");
        ((WebDriver) scenarioContext.getContext("DRIVER")).get(getProperty("URL"));
        logger.info("Web application launched");
        ((WebDriver) scenarioContext.getContext("DRIVER")).manage().window().maximize();
        logger.info("Window maximized");
        logger.info("Starting scenario: " + scenario.getName());
    }

    @AfterStep("@UI")
    public void afterStep(Scenario scenario) throws Exception {
        //validate if scenario has failed
        if (scenario.isFailed()) {
            ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }

    @After("@UI")
    public void after(Scenario scenario) {
        logger.info("Finished scenario: " + scenario.getName());
        ((WebDriver) scenarioContext.getContext("DRIVER")).manage().deleteAllCookies();
        logger.info("Deleting Cookies");
        webDriverProvider.quitDriver();
        logger.info("Driver closed");
    }
}