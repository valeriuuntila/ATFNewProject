package stepDefinitions;

import actions.CommonActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.AccountPage;
import pageObjects.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the Login page")
    public void userIsOnTheLoginPage() {
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @When("user logs in by entering the email:{string}")
    public void userLogsInByEnteringTheEmail(String email) {
        CommonActions.sendKeys(loginPage.getEmailInput(), email);
    }

    @And("user logs in by entering the password:{string}")
    public void userLogsInByEnteringThePassword(String password) {
        CommonActions.sendKeys(loginPage.getPasswordInput(), password);
    }

    @And("the User click on Login button")
    public void theUserClickOnLoginButton() {
        CommonActions.clickOnWebElement(loginPage.getSubmitLogin());

    }
    //The second scenario (TC) User Login. Negativ Flow
    @When("the User enters for the {} time the following invalid credentials: {} and {}")
    public void theUserLoginWithTheFollowingInvalidDetailsAnd(String attempt, String email, String password) {
        userLogsInByEnteringTheEmail(email);
        userLogsInByEnteringThePassword(password);
    }


    @Then("Error message:{string} is displayed")
    public void errorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.getAlertMessage());
    }


}
