package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import stepDefinitions.Hooks;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.PropertyConfigurator.getProperty;

public class ScreenShotUtil {
    private static Scenario scenario;

    public static void setScenario(Scenario scenario) {
        ScreenShotUtil.scenario = scenario;
    }

    public static void takeScreenShot(String fileName) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) Hooks.driver);
        byte[] srcFile = scrShot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(srcFile, "image/png", "Screenshot");
        FileUtils.writeByteArrayToFile(new File(
                getProperty("PATH.TO.SCREENSHOTS.FOLDER")
                        + new SimpleDateFormat(getProperty("DATE.FORMAT")
                        + " "
                        + fileName
                        + getProperty("FORMAT.OF.SCREENSHOT")).format(new Date())), srcFile);

    }
}