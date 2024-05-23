@UpdateUser @API
Feature: PUT<Update>

  @PutUpdateUserDetails @API
  Scenario: Check the actual time for updated User via API with Response = 201
    Given  Specifications have expected response code 200
    When a PUT request is sent with the endpoint: UPDATE_USER
    Then The updatedAt field is not empty

