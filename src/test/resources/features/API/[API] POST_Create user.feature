@CreateUser @API
Feature: POST<Create>
  Background:
#    Given the base URI is set to  "https://reqres.in/"

  @PostCreateUserDetails @API
  Scenario: Validate that the User is able to create new User via API with Response = 201
    Given  Specifications are installed with expected response code 201
    When a POST request is sent to the server with the endpoint "api/users"
    Then The time for createdAt field corresponds to the actual time of this create