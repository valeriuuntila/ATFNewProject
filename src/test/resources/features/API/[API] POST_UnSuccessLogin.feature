@UnSuccessLogin @API
Feature: POST<UnSuccessLogin>
  Background:
#    Given the base URI is set to  "https://reqres.in/"

  @PostUnSuccessLogin @API
  Scenario: Validate that the User can't login without password via API with Response = 400
    Given  Specifications are installed with expected response code 400
    When A POST request is sent to the server with the endpoint "api/login"
    Then The User can't login And error message with text "Missing password" is displayed