package api;

import api.dtos.EmployeeData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DammyApiTest {
    private static final String URL = "https://dummy.restapiexample.com/api/v1/";

    @Test
    public void checkEmployeeDataTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec(200));
        List<EmployeeData> employees = given()
                .when()
                .get("/employees")
                .then().log().all()
                .extract().body().jsonPath().getList("data", EmployeeData.class);

        employees.forEach(employee -> Assert.assertTrue(employee.getEmployee_age()>=20 && employee.getEmployee_age()<=67));
}


}

