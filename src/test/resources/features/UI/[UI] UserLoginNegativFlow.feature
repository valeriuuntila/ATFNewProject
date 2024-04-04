@Negative @UI
Feature: User Login Negativ Flow

  Background: User already has a created Account
    Given User is on the Login page


  Scenario Outline: Verify If user is not able to login with invalid credentials and the corresponding errors are displayed

    When the User enters for the "first" time the following invalid credentials: <email> and <password>
    And the User click on Login button
    Then Error message:"Warning: No match for E-Mail Address and/or Password." is displayed

    When the User enters for the "second" time the following invalid credentials: <email> and <password>
    And the User click on Login button
    Then Error message:"Warning: No match for E-Mail Address and/or Password." is displayed

    When the User enters for the "third" time the following invalid credentials: <email> and <password>
    And the User click on Login button
    Then Error message:"Warning: No match for E-Mail Address and/or Password." is displayed

    When the User enters for the "fourth" time the following invalid credentials: <email> and <password>
    And the User click on Login button
    Then Error message:"Warning: No match for E-Mail Address and/or Password." is displayed

    When the User enters for the "fifth" time the following invalid credentials: <email> and <password>
    And the User click on Login button
    Then Error message:"Warning: No match for E-Mail Address and/or Password." is displayed

    When the User enters for the "sixth" time the following invalid credentials: <email> and <password>
    And the User click on Login button
    Then Error message:"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour." is displayed
    And User is on the Login page

    Examples:
      | email                | password  |
      | horia.tdz@yahoo.com  | test_01!  |
      | horia.taz@yahoo.com  | Test-01!  |
      | horia.tdz&yahoo.com  | Test_01!! |
      | horria.tdz@yahoo.com | Test_01!  |
      | horia.tz@gmail.com   | Test_01!  |
      | horia_tz@yahoo.com   | Test_01!  |



