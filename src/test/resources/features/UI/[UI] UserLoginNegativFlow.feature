@Negative @UI
Feature: User Login Negativ Flow

  Background: User already has a created Account
    Given User is on the Login page


  Scenario: Verify If user is not able to login with invalid credentials

    When the User enters for the "first" time generated invalid credentials
    And the User click on Login button
    Then Error message:"Warning: No match for E-Mail Address and/or Password." is displayed
