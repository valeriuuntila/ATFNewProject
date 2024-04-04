package steps;

import actions.CommonActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import pages.AccountPage;
import utils.LogsConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountSteps {
    private final static Logger logger = LogsConfig.getLogger();
    AccountPage accountPage = new AccountPage();
    @Then("the User is redirected to the Account page")
    public void theUserIsRedirectedToTheAccountPage() {
        assertThat(accountPage.getOpenAccountPageTitle().isDisplayed())
                .as("Account page should be displayed")
                .isTrue();
        logger.info("Account page is displayed");
        //Assert.assertTrue(accountPage.getOpenAccountPageTitle().isDisplayed());

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
    public void theUserGoesToEditAccountPage() throws InterruptedException {
        CommonActions.clickOnWebElement(accountPage.getEditAccountIcon());
    }


}
