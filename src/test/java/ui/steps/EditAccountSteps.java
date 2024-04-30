package ui.steps;

import ui.general_actions.CommonActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ui.pages.AccountPage;
import ui.pages.EditAccountPage;
import ui.pages.LoginPage;
import scenario_context.ScenarioContext;
import utils.logs_config.LogsConfig;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EditAccountSteps {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    EditAccountPage editAccountPage = new EditAccountPage(((WebDriver) scenarioContext.getContext("DRIVER")));
    private final static Logger logger = LogsConfig.getLogger();

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
        CommonActions.clickOnWebElement(editAccountPage.getSubmitContinue());
    }

    @Then("The Account Information  contain updated account information:")
    public void theAccountInformationContainUpdatedAccountInformation(DataTable table) {
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


