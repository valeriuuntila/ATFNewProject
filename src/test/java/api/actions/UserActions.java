package api.actions;

import api.ColorsData;
import api.UserUpdateResponse;
import api.dtos.UnSuccessLogin;
import api.dtos.UserCreateResponse;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import scenariocontext.ScenarioContext;
import utils.LogsConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;

public class UserActions {

    private final static Logger logger = LogsConfig.getLogger();

    @Then("All Resource have color code that matches this regex: {string}")
    public void checkColorsCode(String regex) {
        List<ColorsData> colors = ScenarioContext.response
                .body().jsonPath().getList("data", ColorsData.class);

        List<String> colorsAsStrings = colors.stream()
                .map(ColorsData::getColor)
                .toList();

        SoftAssertions.assertSoftly(softly ->
                colorsAsStrings.forEach(color ->
                        softly.assertThat(color)
                                .as("Each color code number must correspond to this regex:^#[0-9A-Z]{6}$")
                                .matches(regex)
                )
        );

        logger.info("All Resources that have color code numbers: " + colorsAsStrings + " corresponding to this regex: " + regex);

    }

    @Then("The time for updatedAt field corresponds to the actual time of this update")
    public void theTimeForUpdatedAtFieldCorrespondsToTheActualTimeOfThisUpdate() {
        UserUpdateResponse response = ScenarioContext.response
                .as(UserUpdateResponse.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime expectedTime = LocalDateTime.now(UTC);
        LocalDateTime actualTime = LocalDateTime.parse(response.getUpdatedAt(), formatter);

        assertThat(actualTime)
                .as("True If Actual Time is before Expected Time + 5 sec.")
                .isBefore(expectedTime.plusSeconds(5));

        logger.info("Actual Time: " + actualTime + " + 5 sec. is before Expected Time: " + expectedTime);
    }


    @Then("The User can't login And error message with text {string} is displayed")
    public void theUserCanTLoginAndErrorMessageIsDisplayed(String expectedError) {
        UnSuccessLogin response = ScenarioContext.response
                .as(UnSuccessLogin.class);
        String actualError = response.getError();

        assertThat(actualError)
                .as("The error message should have the following text:'Missing password'")
                .isEqualTo(expectedError);

        logger.info("Actual Error message: " + actualError + "." + " Expected Error message: " + expectedError + ".");
    }

    @Then("The time for createdAt field corresponds to the actual time of this create")
    public void theTimeForCreatedAtFieldCorrespondsToTheActualTimeOfThisCreate() {
        UserCreateResponse createResponse = ScenarioContext.response
                .as(UserCreateResponse.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime expectedTime = LocalDateTime.now(UTC);
        LocalDateTime actualTime = LocalDateTime.parse(createResponse.getCreatedAt(), formatter);

        assertThat(actualTime)
                .as("True If Actual Time is before Expected Time + 5 sec.")
                .isBefore(expectedTime.plusSeconds(5));

        logger.info("Actual Time: " + actualTime + " + 5 sec. is before Expected Time: " + expectedTime);

    }
}
