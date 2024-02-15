package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    WebDriver driver;

    @Before
    public void getDriver() {
        driver = new ChromeDriver();

    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
