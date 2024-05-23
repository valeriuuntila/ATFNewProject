package ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import scenario.context.ContextKeys;
import scenario.context.ScenarioContext;
import ui.general.actions.CommonActions;
import ui.pages.AccountPage;

import static org.assertj.core.api.Assertions.assertThat;
import static scenario.context.ContextKeys.DRIVER;

public class AccountSteps {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    AccountPage accountPage = new AccountPage(((WebDriver) scenarioContext.getContext(ContextKeys.DRIVER)));
    @Then("the User is redirected to the Account page")
    public void redirectToAccountPage() {
        assertThat(accountPage.getOpenAccountPageTitle().isDisplayed())
                .as("Account page should be displayed");
        LogManager.getLogger().info("Account page is displayed");
    }
    @Then("Alert message:{string} is displayed on account page.")
    public void showAccountPageAlertMessage(String SuccessEditMessage) {
        assertThat(accountPage.getAlertSuccessMessageContainer().getText())
                .as("Alert Success Message should be displayed on Account page")
                .isEqualToIgnoringWhitespace(SuccessEditMessage);
        LogManager.getLogger().info("Alert Success Message is displayed: " + accountPage.getAlertSuccessMessageContainer().getText());
    }
    @Given("User has opened Edit Account page")
    @When("User opens Edit Account page")
    public void navigateToEditAccountPage() {
        CommonActions.clickOnWebElement(accountPage.getEditAccountIcon());
    }
}
