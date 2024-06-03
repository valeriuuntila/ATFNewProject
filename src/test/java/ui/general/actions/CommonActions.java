package ui.general.actions;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.waiter.Waiter;

public class CommonActions {
    public static void clickOnWebElement(WebElement webElement) {
        Waiter.waiter.until(ExpectedConditions.visibilityOf(webElement));
        Waiter.waiter.until(ExpectedConditions.elementToBeClickable(webElement));
        //Ternary operator. It’s a one-liner replacement for the if-then-else statement.
        String tagName = webElement.getText().isBlank() ? webElement.getAccessibleName() : webElement.getText();
        webElement.click();
        LogManager.getLogger().info("Click on element: " + tagName);
    }

    public static void sendKeys(WebElement field, String inputData) {
        Waiter.waiter.until(ExpectedConditions.visibilityOf(field));
        Waiter.waiter.until(ExpectedConditions.elementToBeClickable(field));
        field.clear();
        field.sendKeys(inputData);
        LogManager.getLogger().info(inputData + " was inserted into " + field.getTagName());
    }
}
