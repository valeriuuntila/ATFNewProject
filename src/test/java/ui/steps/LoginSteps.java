package ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import scenario.context.ContextKeys;
import scenario.context.ScenarioContext;
import ui.pages.LoginPage;
import utils.faker.FakeGenerateData;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    LoginPage loginPage = new LoginPage(((WebDriver) scenarioContext.getContext(ContextKeys.DRIVER)));
    FakeGenerateData generateData = new FakeGenerateData();

    @Given("user is on the Login page")
    public void loadLoginPage() {
        LogManager.getLogger().info(" User is on Login Page");
    }

    @Then("Error message:{string} is displayed")
    public void showErrorMessage(String errorMessage) {
        assertThat(loginPage.getAlertMessage())
                .as("Alert error message should be equal to: " + errorMessage)
                .isEqualTo(errorMessage);
        LogManager.getLogger().info("Alert message is displayed: " + loginPage.getAlertMessage() + " for login attempts with wrong credentials");
    }

    @Given("user is logged in with valid credentials email: {string} and password: {string}")
    @When("user logs in with valid credentials email: {string} and password: {string}")
    public void loginUser(String email, String password) {
        loginPage.userLogin(email, password);
        LogManager.getLogger().info("The user has successfully logged in");
    }

    @When("Wrong credentials are generated")
    public void generateFakeData() {
        String generateEmail = generateData.generateEmail();
        String generatePassword = generateData.generateAlphaNumericValues();
        loginPage.userLogin(generateEmail, generatePassword);
    }

    @When("the user try to enter {} the following credentials: {} and {}")
    public void attemptsInvalidLogins(int times, String email, String password) {
        loginPage.userSameLoginNTimes(email, password, times);
        LogManager.getLogger().info("Login with credentials, email: " + email
                + " and password: " + password
                + " was performed for " + times + " times");
    }
}
