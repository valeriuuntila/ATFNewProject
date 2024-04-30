package utils.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utils.property_configurator.PropertyConfigurator.getProperty;

public class WebDriverProvider {
    private static final String BROWSER_NAME = getProperty("BROWSER").toLowerCase();
    private WebDriver driver;

    public void initializeDriver() {
        switch (BROWSER_NAME) {
            case "chrome" -> driver = initChromeDriver();
            case "firefox" -> driver = initFirefoxDriver();
            case "edge" -> driver = initEdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + BROWSER_NAME);
        }
    }

    private WebDriver initChromeDriver() {
        return new ChromeDriver();
    }

    private WebDriver initFirefoxDriver() {
        return new FirefoxDriver();
    }

    private WebDriver initEdgeDriver() {
        return new EdgeDriver();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been initialized. Call initializeDriver() first.");
        }
        return driver;
    }
}