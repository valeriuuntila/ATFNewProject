package utils.screenshot_util;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import scenario_context.ScenarioContext;
import utils.logs_config.LogsConfig;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.property_configurator.PropertyConfigurator.getProperty;

public class ScreenShotUtil {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private static Scenario scenario;

    public static void setScenario(Scenario scenario) {
        ScreenShotUtil.scenario = scenario;
    }

    private final static Logger logger = LogsConfig.getLogger();

    public static void takeScreenShot() {
        TakesScreenshot scrShot = ((TakesScreenshot) (scenarioContext.getContext("DRIVER")));
        byte[] srcFile = scrShot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(srcFile, "image/png", "SCREENSHOT");
        try {
            FileUtils.writeByteArrayToFile(new File(
                    getProperty("PATH.TO.SCREENSHOTS.FOLDER")
                            + new SimpleDateFormat(getProperty("DATE.FORMAT")
                            + " "
                            + scenario.getName()
                            + getProperty("FORMAT.OF.SCREENSHOT")).format(new Date())), srcFile);
        } catch (IOException e) {
            logger.error("Screenshot con not be created, failed to take screenshot: " + e.getMessage());
        }

    }

}
