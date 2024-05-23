package ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import scenario.context.ContextKeys;
import scenario.context.ScenarioContext;
import ui.general.actions.CommonActions;
import ui.pages.EditAccountPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EditAccountSteps {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    EditAccountPage editAccountPage = new EditAccountPage(((WebDriver) scenarioContext.getContext(ContextKeys.DRIVER)));
    @When("The User submits following account information:")
    public void updateAccountInformation(DataTable table) {
        Map<String, String> inputFieldParameters = table.asMap();
        inputFieldParameters.forEach((field, value) -> {
            editAccountPage.setInput(field, value);
        });
        CommonActions.clickOnWebElement(editAccountPage.getSubmit());
    }
    @Then("The Account Information contain updated account information:")
    public void updatedAccountInfo(DataTable table) {
        Map<String, String> expectedParameters = table.asMap();
        expectedParameters.forEach((field, value) -> {
            assertThat(editAccountPage.getInputByName(field))
                    .extracting(element -> element.getAttribute("value"))
                    .as("Edit account page should be contains values of the followings account information" +
                            "'First Name', ''Last Name, 'Telephone'")
                    .isEqualTo(value);
            LogManager.getLogger().info("Edit account page contains values of the followings account information: "
                    + expectedParameters.get(field));
        });
    }
}


