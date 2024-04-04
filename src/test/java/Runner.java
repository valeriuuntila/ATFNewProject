import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/API", "src/test/resources/features/UI"},
        stepNotifications = true,
        glue = {"steps","api"},
        //tags = "@PostUnSuccessLogin",
        //tags = "@PostCreateUserDetails",
        //tags = "@GetResourceList",
        //tags = "@Edit",
        //tags = "@Login",
        //tags = "@Negative",
        //tags = "@PutUpdateUserDetails",
        //tags = "@GetResourceList",
        tags = "@Edit",
        //tags = "@Login",
        //tags = "@Negative",
        //tags = "@Login, @Negative, @Edit",
        plugin = {"pretty", "html:reports/cucumber-reports/cucumber-report.html"})
public class Runner {

}