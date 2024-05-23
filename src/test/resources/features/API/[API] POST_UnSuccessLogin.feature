@UnSuccessLogin @API
Feature: POST<UnSuccessLogin>

  @PostUnSuccessLogin @API
  Scenario: Validate error message when User can't login without password via API with Response = 400
    Given  Specifications have expected response code 400
    When A POST request is sent with the endpoint: LOGIN
    Then The User can't login And error message with text "Missing password" is displayed