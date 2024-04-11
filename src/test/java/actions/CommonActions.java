package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import scenariocontext.ScenarioContext;
import utils.LogsConfig;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CommonActions {

    private final static ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private static final Wait<WebDriver> waiter = new FluentWait<>(((WebDriver) scenarioContext.getContext("DRIVER")))
            .withTimeout(Duration.of(30, ChronoUnit.SECONDS))
            .pollingEvery(Duration.of(2, ChronoUnit.SECONDS))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

    private final static Logger logger = LogsConfig.getLogger();

    public static void clickOnWebElement(WebElement webElement) throws InterruptedException {
        waiter.until(ExpectedConditions.visibilityOf(webElement));
        waiter.until(ExpectedConditions.elementToBeClickable(webElement));

        //Ternary operator. It’s a one-liner replacement for the if-then-else statement.
        String tagName = webElement.getText().isBlank() ? webElement.getAccessibleName() : webElement.getText();
        webElement.click();

        logger.info("Click on element: " + tagName);
        //logger.info("Click on element: " + webElement.getTagName());
    }

    public static void sendKeys(WebElement field, String inputData) {
        waiter.until(ExpectedConditions.visibilityOf(field));
        waiter.until(ExpectedConditions.elementToBeClickable(field));
        field.clear();
        field.sendKeys(inputData);
        logger.info(inputData + " was inserted into " + field.getTagName());
    }

}
