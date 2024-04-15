package steps;

import actions.CommonActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.EditAccountPage;
import pages.LoginPage;
import scenariocontext.ScenarioContext;
import utils.LogsConfig;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EditAccountSteps {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    EditAccountPage editAccountPage = new EditAccountPage(((WebDriver) scenarioContext.getContext("DRIVER")));
    AccountPage accountPage = new AccountPage(((WebDriver) scenarioContext.getContext("DRIVER")));
    LoginPage loginPage = new LoginPage(((WebDriver) scenarioContext.getContext("DRIVER")));
    LoginSteps loginSteps = new LoginSteps();
    private final static Logger logger = LogsConfig.getLogger();
    //GenerateData generateData = new GenerateData();

    @Given("User is on the Edit Account page")
    public void userIsOnTheEditAccountPage() {
        assertThat(editAccountPage.getEditAccountPage().isDisplayed())
                .as("User should be on Edit Account page");
        logger.info("User is on Edit Account page");
    }

    @When("The User enters following account information:")
    public void theUserEntersFollowingAccountInformation(DataTable table) {
        Map<String, String> inputFieldParameters = table.asMap();

        inputFieldParameters.forEach((field, value) -> {
            editAccountPage.setInput(field, value);
        });

    }

    @And("The User click on Continue button")
    public void theUserClickOnContinueButton() {
        CommonActions.clickOnWebElement(editAccountPage.getSubmitContinue());

    }


    @Then("The Account Information  contain the following:")
    public void theAccountInformationContainTheFollowing(DataTable table) {
        Map<String, String> expectedParameters = table.asMap();

        expectedParameters.forEach((field, value) -> {
            assertThat(editAccountPage.getInputByName(field))
                    .extracting(element -> element.getAttribute("value"))
                    .as("Edit account page should be contains values of the followings account information" +
                            "'First Name', ''Last Name, 'Telephone'")
                    .isEqualTo(value);
            logger.info("Edit account page contains values of the followings account information: " + expectedParameters.get(field));

        });
    }

}


