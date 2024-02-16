package utils.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider {

    private WebDriver driver;

    public WebDriver initializeDriver(String browser) {
        switch (browser) {
            case "chrome" -> driver = initChromeDriver();
            case "firefox" -> driver = initFirefoxDriver();
            case "edge" -> driver = initEdgeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        return driver;
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
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been initialized. Call initializeDriver() first.");
        }
        return driver;
    }
}