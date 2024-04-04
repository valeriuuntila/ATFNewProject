package api.actions;

import api.Specifications;
import api.UpdateUserData;
import api.dtos.CreateUserData;
import api.dtos.SuccessLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import scenariocontext.ScenarioContext;
import utils.LogsConfig;

import static io.restassured.RestAssured.given;

public class CommonActions {
    UpdateUserData userUpdate = new UpdateUserData("morpheus", "zion resident");
    CreateUserData userCreate = new CreateUserData("morpheus", "leader", "676");

    SuccessLogin userWithoutPassword = new SuccessLogin("peter@klaven", "");

    private final static Logger logger = LogsConfig.getLogger();



    @Given("Specifications are installed with expected response code {int}")
    public void installSpecifications(int code) {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(code));
//        String responseCode = Specifications.responseSpec(code).response();

        logger.info("Specifications installed with response code: " + code);
    }

    @When("a GET request is sent to the server with the endpoint {string}")
    public void getRequestIsSentTo(String endpoint1) {
        ScenarioContext.response = given()
                .when()
                .get(endpoint1)
                .then().log().all()
                .extract().response();

        logger.info("A GET request was sent to the server with the endpoint: " + endpoint1);
    }

    @When("a PUT request is sent to the server with the endpoint {string}")
    public void putRequestIsSentTo(String endpoint2) {
        ScenarioContext.response = given()
                .body(userUpdate)
                .when()
                .put(endpoint2)
                .then().log().all()
                .extract().response();
        logger.info("A PUT request was sent to the server with the endpoint: " + endpoint2);
    }

    @When("a POST request is sent to the server with the endpoint {string}")
    public void aPOSTRequestIsSentToTheServerWithTheEndpoint(String endpoint3) {
        ScenarioContext.response = given()
                .body(userCreate)
                .when()
                .post(endpoint3)
                .then().log().all()
                .extract().response();

        logger.info("A POST request was sent to the server with the endpoint: " + endpoint3);
    }

    @When("A POST request is sent to the server with the endpoint {string}")
    public void aUnSuccessRequestIsSentToTheServerWithTheEndpoint(String endpoint4) {
        ScenarioContext.response = given()
                .body(userWithoutPassword)
                .post(endpoint4)
                .then().log().all()
                .extract().response();

        logger.info("A POST request was sent to the server with the endpoint: " + endpoint4);
    }

}
