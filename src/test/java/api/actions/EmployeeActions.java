package api.actions;

import api.dtos.EmployeeData;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import scenarioContext.ScenarioContext;

import java.util.List;

public class EmployeeActions {
    @Then("All Employees have their age value between {int} and {int}")
    public void checkEmploeeAge(int minAge, int maxAge) {
        List<EmployeeData> employees = ScenarioContext.response
                        .body().jsonPath().getList("data", EmployeeData.class);

        employees.forEach(employee ->
                Assert.assertTrue(employee.getEmployee_age()>=minAge && employee.getEmployee_age()<=maxAge));
    }

}
