@EmployeeData
Feature: List<AllEmployeeData>
  Background:
#    Given the base URI is set to  "https://dummy.restapiexample.com/api/v1"

  @GetListOfAllEmployee
  Scenario: Validate that the User can retrieve Data from List of AllEmployeeData via API with Response = 200
    Given  Specifications are instaled with expected responce code 200
    When a GET request is sent to the server with the endpoint "/employees"
    Then All Employees have their age value between 18 and 67

