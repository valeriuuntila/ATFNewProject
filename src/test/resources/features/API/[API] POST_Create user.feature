@CreateUser @API
Feature: POST<Create>

  @PostCreateUserDetails @API
  Scenario: Check the actual time for new created User via API with Response = 201
    Given  Specifications are installed with expected response code 201
    When a POST request is sent to the server with the endpoint "api/users"
    Then The time for createdAt field corresponds to the actual time of this create