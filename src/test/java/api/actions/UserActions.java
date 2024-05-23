package api.actions;

import api.dtos.responses.DataAttributes;
import api.dtos.responses.UnSuccessLogin;
import api.dtos.responses.UserCreate;
import api.dtos.responses.UserUpdate;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.assertj.core.api.SoftAssertions;
import scenario.context.ContextKeys;
import scenario.context.ScenarioContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

public class UserActions {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @Then("All Resource have color code that matches this regex: {string}")
    public void checkColorsCode(String regex) {
        List<DataAttributes> objectsAttributes = ((Response) scenarioContext.getContext(ContextKeys.RESPONSE))
                .body().jsonPath().getList("data", DataAttributes.class);

        List<String> colors = objectsAttributes.stream()
                .map(DataAttributes::getColor)
                .toList();

        SoftAssertions.assertSoftly(softly ->
                colors.forEach(color ->
                        softly.assertThat(color)
                                .as("Each color code number must correspond to this regex:^#[0-9A-Z]{6}$")
                                .matches(regex)
                )
        );

        LogManager.getLogger().info("All Resources that have color code numbers: " + colors + " corresponding to this regex: " + regex);
    }

    @Then("The updatedAt field is not empty")
    public void updatedAtFieldIsNotEmpty() {
        UserUpdate response = ((Response) scenarioContext.getContext(ContextKeys.RESPONSE))
                .as(UserUpdate.class);
        assertThat(response.getUpdatedAt()).isNotEmpty()
                .as("Field updatedAt should not be empty");

        LogManager.getLogger().info("Field updatedAt is not empty and is equal: \"" + response.getUpdatedAt() + "\"");
    }

    @Then("The User can't login And error message with text {string} is displayed")
    public void verifyLoginFailureWithErrorMessageDisplayed(String expectedError) {
        UnSuccessLogin response = ((Response) scenarioContext.getContext(ContextKeys.RESPONSE))
                .as(UnSuccessLogin.class);
        String actualError = response.getError();

        assertThat(actualError)
                .as("The error message should have the following text:'Missing password'")
                .isEqualTo(expectedError);

        LogManager.getLogger().info("Actual Error message: " + actualError + "." + " Expected Error message: " + expectedError + ".");
    }

    @Then("The time for user creation is less than {int} seconds")
    public void verifyCreatedAtTimestampIsBeforeCurrentTimePlusSeconds(int sec) {
        UserCreate createResponse = ((Response) scenarioContext.getContext(ContextKeys.RESPONSE))
                .as(UserCreate.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime expectedTime = LocalDateTime.now(UTC).plusSeconds(sec);
        LocalDateTime actualTime = LocalDateTime.parse(createResponse.getCreatedAt(), formatter);

        assertThat(actualTime)
                .as("True If Actual Time is before Expected Time + " + sec + "sec.")
                .isBefore(expectedTime);

        LogManager.getLogger().info("Actual Time: " + actualTime + " + " + sec + " sec. is before Expected Time: " + expectedTime);

    }
}
