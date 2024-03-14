package stepDefinitions;

import actions.CommonActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.AccountPage;

import java.util.Map;

public class AccountSteps {
    AccountPage accountPage = new AccountPage();
    @Then("the User is redirected to the Account page")
    public void theUserIsRedirectedToTheAccountPage() {
        Assert.assertTrue(accountPage.getOpenAccountPageTitle().isDisplayed());

    }

    @And("the User's login is successful")
    public void theUserSLoginIsSuccessful() {
    }

    @Then("Alert message:{string} is displayed on account page.")
    public void alertMessageIsDisplayedOnAccountPage(String SuccessEditMessage) {
        Assert.assertEquals(SuccessEditMessage, accountPage.getAlertSuccessMessageContainer().getText());
    }

    @When("The User Goes to Edit Account page")
    public void theUserGoesToEditAccountPage() {
        CommonActions.clickOnWebElement(accountPage.getEditAccountIcon());
    }


}
