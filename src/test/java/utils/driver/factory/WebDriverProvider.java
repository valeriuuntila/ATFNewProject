package utils.driver.factory;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utils.property.configurator.PropertyConfigurator.getProperty;

public class WebDriverProvider {
    private static WebDriver driver;

    public static WebDriver getDriver()  {
        if (driver == null) {
            LogManager.getLogger().info("WebDriver has not been initialized. Call initializeDriver() first.");
            return initializeDriver();
        }
        return driver;
    }

    private static String getBrowserName()  {
        return getProperty("BROWSER").toLowerCase();
    }

    public static WebDriver initializeDriver()   {
        switch (getBrowserName()) {
            case "firefox" -> driver = initFirefoxDriver();
            case "edge" -> driver = initEdgeDriver();
            default -> driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        LogManager.getLogger().info("Chrome Driver is initializing");
        return new ChromeDriver();
    }

    private static WebDriver initFirefoxDriver() {
        LogManager.getLogger().info("FireFox Driver is initializing");
        return new FirefoxDriver();
    }

    private static WebDriver initEdgeDriver() {
        LogManager.getLogger().info("Edge Driver is initializing");
        return new EdgeDriver();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
