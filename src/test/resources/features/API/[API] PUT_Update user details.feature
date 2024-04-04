@UpdateUser @API
Feature: PUT<Update>
  Background:
#    Given the base URI is set to  "https://reqres.in/"

  @PutUpdateUserDetails @API
  Scenario: Validate that the User is able to update User's details via API with Response = 200
    Given  Specifications are installed with expected response code 200
    When a PUT request is sent to the server with the endpoint "/api/users/2"
    Then The time for updatedAt field corresponds to the actual time of this update

