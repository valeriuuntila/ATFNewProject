package api.actions;

import api.Specifications;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import scenarioContext.ScenarioContext;

import static io.restassured.RestAssured.given;

public class CommonActions {
    @Given("Specifications are instaled with expected responce code {int}")
    public void installSpecifications(int code) {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(code));
    }

    @When("a GET request is sent to the server with the endpoint {string}")
    public void getRequestIsSentTo(String endpoint) {
        ScenarioContext.response = given()
                .when()
                .get(endpoint)
                .then().log().all()
                .extract().response();
    }
}
