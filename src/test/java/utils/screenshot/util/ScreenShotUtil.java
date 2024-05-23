package utils.screenshot.util;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import scenario.context.ContextKeys;
import scenario.context.ScenarioContext;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static utils.property.configurator.PropertyConfigurator.getProperty;

public class ScreenShotUtil {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private static Scenario scenario;
    public static void setScenario(Scenario scenario) {
        ScreenShotUtil.scenario = scenario;
    }
    public static void takeScreenShot()   {
        TakesScreenshot scrShot = ((TakesScreenshot) (scenarioContext.getContext(ContextKeys.DRIVER)));
        byte[] srcFile = scrShot.getScreenshotAs(OutputType.BYTES);
        //String reportTimeStamp = new SimpleDateFormat(getProperty("DATE.FORMAT")).format(new Date());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(getProperty("DATE.FORMAT.SCREENSHOT"));
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(formatter);
        scenario.attach(srcFile, getProperty("MEDIA.TYPE"), "SCREENSHOT_"+formattedDate);
        try {
            FileUtils.writeByteArrayToFile(new File(
                    getProperty("PATH.TO.SCREENSHOTS.FOLDER")
                            + LocalDateTime.now().format(DateTimeFormatter.ofPattern(getProperty("DATE.FORMAT.RUN")))
                            +"/"
                            +scenario.getName()
                            +"/"
                            + new SimpleDateFormat(getProperty("DATE.FORMAT")
                            + " "
                            + scenario.getName()
                            + getProperty("FORMAT.OF.SCREENSHOT")).format(new Date())), srcFile);
        } catch (IOException e) {
            LogManager.getLogger().error("Screenshot con not be created, failed to take screenshot: " + e.getMessage());
        }
    }
}
