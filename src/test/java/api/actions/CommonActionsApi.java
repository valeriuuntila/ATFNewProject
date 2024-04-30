package api.actions;

import api.Specifications;
import api.dtos.CreateUserData;
import api.dtos.SuccessLogin;
import api.dtos.UpdateUserData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import scenario_context.ScenarioContext;
import utils.logs_config.LogsConfig;

import static io.restassured.RestAssured.given;

public class CommonActionsApi {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    UpdateUserData userUpdate = new UpdateUserData("morpheus", "zion resident");
    CreateUserData userCreate = new CreateUserData("morpheus", "leader");

    SuccessLogin userWithoutPassword = new SuccessLogin("peter@klaven", "");

    private final static Logger logger = LogsConfig.getLogger();



    @Given("Specifications are installed with expected response code {int}")
    public void installSpecifications(int code) {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(code));

        logger.info("Specifications installed with response code: " + code);
    }

    @When("a GET request is sent to the server with the endpoint {string}")
    public void getRequestIsSentTo(String endpoint) {
        Response response = given()
                .when()
                .get(endpoint)
                .then().log().all()
                .extract().response();
        scenarioContext.setContext("RESPONSE", response);
        logger.info("A GET request was sent to the server with the endpoint: " + endpoint);
    }

    @When("a PUT request is sent to the server with the endpoint {string}")
    public void putRequestIsSentTo(String endpoint) {
        Response response = given()
                .body(userUpdate)
                .when()
                .put(endpoint)
                .then().log().all()
                .extract().response();
        scenarioContext.setContext("RESPONSE", response);

        logger.info("A PUT request was sent to the server with the endpoint: " + endpoint);
    }

    @When("a POST request is sent to the server with the endpoint {string}")
    public void aPOSTRequestIsSentToTheServerWithTheEndpoint(String endpoint) {
        Response response = given()
                .body(userCreate)
                .when()
                .post(endpoint)
                .then().log().all()
                .extract().response();
        scenarioContext.setContext("RESPONSE", response);

        logger.info("A POST request was sent to the server with the endpoint: " + endpoint);
    }

    @When("A POST request is sent to the server with the endpoint {string}")
    public void aUnSuccessRequestIsSentToTheServerWithTheEndpoint(String endpoint) {
        Response response = given()
                .body(userWithoutPassword)
                .post(endpoint)
                .then().log().all()
                .extract().response();
        scenarioContext.setContext("RESPONSE", response);

        logger.info("A POST request was sent to the server with the endpoint: " + endpoint);
    }

}
