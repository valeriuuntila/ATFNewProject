import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/testResources/features"},
        glue = {"stepDefinitions"},
        //tags = "@Edit",
        //tags = "@Login",
        tags = "@Negative",
        //tags = "@Login, @Negative, @Edit",
        plugin = {"pretty", "html:target/cucumber-reports/report.html"})
public class Runner {

}