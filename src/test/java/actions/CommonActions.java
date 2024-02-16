package actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static stepDefinitions.Hooks.driver;

public class CommonActions {
    private static final Wait waiter = new FluentWait<>(driver)
            .withTimeout(Duration.of(30, ChronoUnit.SECONDS))
            .pollingEvery(Duration.of(2, ChronoUnit.SECONDS))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

    public static void clickOnWebElement(WebElement webElement) {
        waiter.until(ExpectedConditions.visibilityOf(webElement));
        waiter.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void clickOnWebElementWoWaiters(WebElement webElement) {
        webElement.click();
    }

    public static void sendKeys(WebElement field, String inputData) {
        waiter.until(ExpectedConditions.visibilityOf(field));
        waiter.until(ExpectedConditions.elementToBeClickable(field));
        field.clear();
        field.sendKeys(inputData);
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

    public static void clickOnAllFromList(List<WebElement> listOfWebElements) {
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
