import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/API", "src/test/resources/features/UI"},
        stepNotifications = true,
        glue = {"steps", "api"},
        //tags = "@UI",
        //tags = "@API",
        //tags = "@Edit",

        plugin = {"pretty", "html:reports/cucumber-reports/cucumber-report.html"})
public class TestRunner {

}