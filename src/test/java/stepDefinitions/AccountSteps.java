package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.AccountPage;

public class AccountSteps {
    AccountPage accountPage = new AccountPage();
    @Then("the User is redirected to the Account page")
    public void theUserIsRedirectedToTheAccountPage() {
        Assert.assertTrue(accountPage.getOpenAccountPage().isDisplayed());

    }

    @And("the User's login is successful")
    public void theUserSLoginIsSuccessful() {
    }
}
