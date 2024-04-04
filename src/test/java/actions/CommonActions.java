package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.LogsConfig;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static steps.Hooks.driver;

public class CommonActions {
    private static final Wait<WebDriver> waiter = new FluentWait<>(driver)
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

    public static void clickOnWebElementWoWaiters(WebElement webElement) {
        webElement.click();
    }

    public static void sendKeys(WebElement field, String inputData) {
        waiter.until(ExpectedConditions.visibilityOf(field));
        waiter.until(ExpectedConditions.elementToBeClickable(field));
        field.clear();
        field.sendKeys(inputData);
        logger.info(inputData + " was inserted into " + field.getTagName());
    }

    public static void sendKeysWithOutClearField(WebElement field, String inputData) {
        waiter.until(ExpectedConditions.visibilityOf(field));
        waiter.until(ExpectedConditions.elementToBeClickable(field));
        field.sendKeys(inputData);
    }

    public static void waitUntilVisible(WebElement webElement) {
        waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static boolean webElementContainsText(String text, WebElement webElement) {
        waiter.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText().contains(text);
    }

    public static void clickOnAllFromList(List<WebElement> listOfWebElements) throws InterruptedException {
        waitUntilVisible(listOfWebElements.get(listOfWebElements.size() - 1));
        for (int i = listOfWebElements.size() - 1; i >= 0; i--) {
            clickOnWebElement(listOfWebElements.get(i));
        }
    }

    public static void scrollToElementAndClickOnIt(WebElement webElement) throws InterruptedException {
        Thread.sleep(3000);
        webElement.click();
    }
}
