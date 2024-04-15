package steps;

import actions.CommonActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import scenariocontext.ScenarioContext;
import utils.LogsConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountSteps {
    private static final Logger logger = LogsConfig.getLogger();

    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    AccountPage accountPage = new AccountPage(((WebDriver) scenarioContext.getContext("DRIVER")));
    @Then("the User is redirected to the Account page")
    public void theUserIsRedirectedToTheAccountPage() {
        assertThat(accountPage.getOpenAccountPageTitle().isDisplayed())
                .as("Account page should be displayed");
        logger.info("Account page is displayed");

    }

    @And("the User's login is successful")
    public void theUserSLoginIsSuccessful() {
    }

    @Then("Alert message:{string} is displayed on account page.")
    public void alertMessageIsDisplayedOnAccountPage(String SuccessEditMessage) {
        assertThat(accountPage.getAlertSuccessMessageContainer().getText())
                .as("Alert Success Message should be displayed on Account page")
                .isEqualToIgnoringWhitespace(SuccessEditMessage);
        logger.info("Alert Success Message is displayed: " + accountPage.getAlertSuccessMessageContainer().getText());
    }

    @When("The User Goes to Edit Account page")
    public void theUserGoesToEditAccountPage() {
        CommonActions.clickOnWebElement(accountPage.getEditAccountIcon());
    }

    @And("User clicks on the Edit Account page")
    public void userClicksOnTheEditAccountPage() {
        CommonActions.clickOnWebElement(accountPage.getEditAccountIcon());
    }
}
