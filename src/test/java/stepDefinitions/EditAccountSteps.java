package stepDefinitions;

import actions.CommonActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.AccountPage;
import pageObjects.EditAccountPage;

import java.util.Map;

public class EditAccountSteps {
    EditAccountPage editAccountPage = new EditAccountPage();


    @Given("User is on the Edit Account page")
    public void userIsOnTheEditAccountPage() {
        Assert.assertTrue(editAccountPage.getEditAccountPage().isDisplayed());
    }

    @When("The User enters following account information:")
    public void theUserEntersFollowingAccountInformation(DataTable table) {
        Map<String, String>inputFieldParameters = table.asMap();

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
            Assert.assertEquals(value, editAccountPage.getInputByName(field).getAttribute("value"));
        });
    }


}
