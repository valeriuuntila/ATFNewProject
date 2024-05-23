package utils.waiter;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import scenario.context.ContextKeys;
import scenario.context.ScenarioContext;
import utils.property.configurator.PropertyConfigurator;

import java.time.Duration;

public class Waiter {
    private final static ScenarioContext scenarioContext = ScenarioContext.getInstance();
    public static Wait<WebDriver> waiter;
    static {
        try {
            waiter = new FluentWait<>(((WebDriver) scenarioContext.getContext(ContextKeys.DRIVER)))
                    .withTimeout(Duration.ofSeconds(Long.parseLong(PropertyConfigurator.getProperty("TIMEOUT.SECONDS"))))
                    .pollingEvery(Duration.ofSeconds(Long.parseLong(PropertyConfigurator.getProperty("POLLINGINTERVAL.SECONDS"))));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element was not displayed within the timeout period", e);
        }
    }
}
