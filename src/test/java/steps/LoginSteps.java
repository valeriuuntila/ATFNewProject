package steps;

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


    @Given("user is on the Login page")
    public void userIsOnTheLoginPage() {
        logger.info(" User is on Login Page");
    }

    @Then("Error message:{string} is displayed")
    public void errorMessageIsDisplayed(String errorMessage) {
        assertThat(loginPage.getAlertMessage())
                .as("Alert error message should be displayed on Account page")
                .isEqualTo(errorMessage);
        logger.info("Alert message is displayed: " + loginPage.getAlertMessage() + " for login attempts with wrong credentials");
    }

    @When("user logs in with valid credentials email: {string} and password: {string}")
    public void userLogsInWithValidCredentialsEmailAndPassword(String email, String password) {
        loginPage.loginWithCredentials(email, password);
        logger.info("The user has successfully logged in");
    }

    @When("Wrong credentials are generated")
    public void fakeDataIsGenerated() {
        String generateEmail = generateData.generateEmail();
        String generatePassword = generateData.generateAlphaNumericValues();
        loginPage.loginWithCredentials(generateEmail, generatePassword);
    }

    @When("the user try to enter {} the following credentials: {} and {}")
    public void theUserTryToEnterTimesTheFollowingInvalidCredentialsAnd(int times, String email, String password) {
        loginPage.loginWithSameCredentialsForNTimes(email, password, times);
        logger.info("Login with credentials, email: " + email
                + " and password: " + password
                + " was performed for " + times + " times");
    }
}
