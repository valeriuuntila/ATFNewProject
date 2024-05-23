@CreateUser @API
Feature: POST<Create>

  @PostCreateUserDetails @API
  Scenario: Check the actual time for new created User via API with Response = 201
    Given  Specifications have expected response code 201
    When a POST request is sent with the endpoint: USERS
    Then The time for user creation is less than 5 seconds