package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import scenariocontext.ScenarioContext;
import steps.Hooks;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.PropertyConfigurator.getProperty;

public class ScreenShotUtil {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private static Scenario scenario;

    public static void setScenario(Scenario scenario) {
        ScreenShotUtil.scenario = scenario;
    }

    public static void takeScreenShot(String fileName) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) ((WebDriver) scenarioContext.getContext("DRIVER")));
        byte[] srcFile = scrShot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(srcFile, "image/png", "SCREENSHOT");
        FileUtils.writeByteArrayToFile(new File(
                getProperty("PATH.TO.SCREENSHOTS.FOLDER")
                        + new SimpleDateFormat(getProperty("DATE.FORMAT")
                        + " "
                        + scenario.getName()
                        + getProperty("FORMAT.OF.SCREENSHOT")).format(new Date())), srcFile);

    }

}
