package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.LogsConfig;
import utils.ScreenShotUtil;
import utils.driverFactory.WebDriverProvider;

import static utils.PropertyConfigurator.getProperty;


public class Hooks {
    public static WebDriver driver;
    private final WebDriverProvider webDriverProvider = new WebDriverProvider();
    public static Scenario currentScenario;
    private static Logger logger = LogsConfig.getLogger();


    @Before("@UI")
    public void before(Scenario scenario) {
        ScreenShotUtil.setScenario(scenario);
        currentScenario = scenario;
        webDriverProvider.initializeDriver("chrome");
        driver = webDriverProvider.getDriver();
        logger.info("New driver instantiated");
        driver.get(getProperty("URL"));
        logger.info("Web application launched");
        driver.manage().window().maximize();
        logger.info("Window maximized");
        logger.info("Starting scenario: " + scenario.getName());
    }

    @AfterStep("@UI")
    public void afterStep(Scenario scenario) throws Exception {
        currentScenario = scenario;
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @After("@UI")
    public void after(Scenario scenario) {
        currentScenario = scenario;
        logger.info("Finished scenario: " + scenario.getName());
        driver.manage().deleteAllCookies();
        logger.info("Deleting Cookies");
        webDriverProvider.quitDriver();
        logger.info("Driver closed");
    }
}