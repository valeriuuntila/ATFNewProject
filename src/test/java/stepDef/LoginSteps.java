package stepDef;

import browser.ChromeDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

public class LoginSteps {
    @Given("User is on the Login page:{string}")
    public void userIsOnTheLoginPage(String url) {
        ChromeDriverManager driverManager = new ChromeDriverManager();
        driverManager.createDriver().get(url);

    }

    @When("user logs in by entering the email:{string}")
    public void userLogsInByEnteringTheEmail(String arg0) {
    }

    @And("user logs in by entering the password:{string}")
    public void userLogsInByEnteringThePassword(String arg0) {
    }

    @And("the User click on Login button")
    public void theUserClickOnLoginButton() {
        
    }

    @Then("the User is redirected to the Account page")
    public void theUserIsRedirectedToTheAccountPage() {
        
    }

    @And("the User's login is successful")
    public void theUserSLoginIsSuccessful() {
    }
}
