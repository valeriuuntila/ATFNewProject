package api;

import api.dtos.ColorsData;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ColorApiTest {
    private static final String URL = "https://reqres.in/";

    @Test
    public void checkColorsDataTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(200));
        List<ColorsData> employees = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
    }


}

