@UpdateUser @API
Feature: PUT<Update>

  @PutUpdateUserDetails @API
  Scenario: Check the actual time for updated User via API with Response = 201
    Given  Specifications are installed with expected response code 200
    When a PUT request is sent to the server with the endpoint "/api/users/2"
    Then The time for updatedAt field corresponds to the actual time of this update

