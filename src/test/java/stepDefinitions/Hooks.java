package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.Log;
import utils.ScreenShotUtil;
import utils.driverFactory.WebDriverProvider;

import static utils.PropertyConfigurator.getProperty;


public class Hooks {
    public static WebDriver driver;
    private final WebDriverProvider webDriverProvider = new WebDriverProvider();
    public static Scenario currentScenario;

    @Before
    public void before(Scenario scenario) {
        Log.startTestCase("Testing started");
        ScreenShotUtil.setScenario(scenario);
        currentScenario = scenario;
        webDriverProvider.initializeDriver("chrome");
        driver = webDriverProvider.getDriver();
        Log.info("New driver instantiated");
        driver.get(getProperty("URL"));
        Log.info("Web application launched");
        driver.manage().window().maximize();
        Log.info("Window maximized");
        Log.info("Starting scenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws Exception {
        currentScenario = scenario;
        ScreenShotUtil.takeScreenShot(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @After
    public void after(Scenario scenario) {
        currentScenario = scenario;
        Log.info("Finished scenario: " + scenario.getName());
        driver.manage().deleteAllCookies();
        Log.info("Deleting Cookies");
        webDriverProvider.quitDriver();
        Log.info("Driver closed");
    }
}