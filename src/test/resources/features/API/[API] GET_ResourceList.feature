@ResourceData @API
Feature: List<Resource>
  @GetResourceList @API

  Scenario: Validate that User can retrieve Data according to the regex via API with Response = 200
    Given  Specifications have expected response code 200
    When a GET request is sent with the endpoint: UNKNOWN
    Then All Resource have color code that matches this regex: "^#[0-9A-Z]{6}$"

