package steps;

import actions.CommonActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import scenariocontext.ScenarioContext;
import utils.GenerateData;
import utils.LogsConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {
    private final static Logger logger = LogsConfig.getLogger();

    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    LoginPage loginPage = new LoginPage(((WebDriver) scenarioContext.getContext("DRIVER")));
    GenerateData generateData = new GenerateData();

    @Given("User is on the Login page")
    public void userIsOnTheLoginPage() {
        assertThat(loginPage.getEmailInput().isDisplayed())
                .as("Email should be displayed on email field/login page");
        logger.info(" User is on Login Page");
    }

    @When("user logs in by entering the email: {string}")
    public void userLogsInByEnteringTheEmail(String email) {
        CommonActions.sendKeys(loginPage.getEmailInput(), email);
    }

    @And("user logs in by entering the password: {string}")
    public void userLogsInByEnteringThePassword(String password) {
        CommonActions.sendKeys(loginPage.getPasswordInput(), password);
    }

    @And("the User click on Login button")
    public void theUserClickOnLoginButton() throws InterruptedException {
        CommonActions.clickOnWebElement(loginPage.getSubmitLogin());

    }

    //The second scenario (TC) User Login. Negative Flow
    @When("the User enters for the {} time generated invalid credentials")
    public void theUserLoginWithTheFollowingInvalidDetailsAnd(String attempt) {
        String generateEmail = generateData.generateEmail();
        String generatePassword = generateData.generateAlphaNumericValues();
        userLogsInByEnteringTheEmail(generateEmail);
        userLogsInByEnteringThePassword(generatePassword);
    }


    @Then("Error message:{string} is displayed")
    public void errorMessageIsDisplayed(String errorMessage) {
        assertThat(loginPage.getAlertMessage())
                .as("Alert error message should be displayed on Account page")
                .isEqualTo(errorMessage);
        logger.info("Alert message is displayed: " + loginPage.getAlertMessage() + " for login attempts with invalid credentials");
    }


    @When("the User enters for the {string} time the following invalid credentials: {} and {}")
    public void theUserEntersForTheTimeTheFollowingInvalidCredentialsAtempt(String attempt, String email, String password) {
        userLogsInByEnteringTheEmail(email);
        userLogsInByEnteringThePassword(password);
    }
}
