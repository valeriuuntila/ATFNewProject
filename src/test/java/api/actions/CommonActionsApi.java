package api.actions;

import api.Specifications;
import api.dtos.requests.CreateUserData;
import api.dtos.requests.SuccessLogin;
import api.dtos.requests.UpdateUserData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import scenario.context.ContextKeys;
import scenario.context.ScenarioContext;
import utils.endpoints.EndPoints;


import static io.restassured.RestAssured.given;

public class CommonActionsApi {
    private static final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    //TODO: de intrebat daca e ok sa punem in metode?
    UpdateUserData userUpdate = new UpdateUserData("morpheus", "zion resident");
    CreateUserData userCreate = new CreateUserData("morpheus", "leader");

    SuccessLogin userWithoutPassword = new SuccessLogin("peter@klaven", "");

    @Given("Specifications have expected response code {int}")
    public void installSpecifications(int code) {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(code));

        LogManager.getLogger().info("Specifications installed with response code: " + code);
    }

    @When("a GET request is sent with the endpoint: {endpoints}")
    public void getRequestIsSentTo(EndPoints endpoints) {
        Response response = given()
                .when()
                .get(endpoints.getValue())
                .then().log().all()
                .extract().response();
        scenarioContext.setContext(ContextKeys.RESPONSE, response);
        LogManager.getLogger().info("A GET request was sent   with the endpoint: " + endpoints);
    }

    @When("a PUT request is sent with the endpoint: {endpoints}")
    public void sendPUTRequestTo(EndPoints endpoints) {
        Response response = given()
                .body(userUpdate)
                .when()
                .put(endpoints.getValue())
                .then().log().all()
                .extract().response();
        scenarioContext.setContext(ContextKeys.RESPONSE, response);

        LogManager.getLogger().info("A PUT request was sent   with the endpoint: " + endpoints);
    }

    @When("a POST request is sent with the endpoint: {endpoints}")
    public void sendPOSTRequest(EndPoints endpoints) {
        Response response = given()
                .body(userCreate)
                .when()
                .post(endpoints.getValue())
                .then().log().all()
                .extract().response();
        scenarioContext.setContext(ContextKeys.RESPONSE, response);

        LogManager.getLogger().info("A POST request was sent   with the endpoint: " + endpoints);
    }

    @When("A POST request is sent with the endpoint: {endpoints}")
    public void sendUnsuccessfuPOSTRequest(EndPoints endpoints) {
        Response response = given()
                .body(userWithoutPassword)
                .post(endpoints.getValue())
                .then().log().all()
                .extract().response();
        scenarioContext.setContext(ContextKeys.RESPONSE, response);

        LogManager.getLogger().info("A POST request was sent   with the endpoint: " + endpoints);
    }

}
