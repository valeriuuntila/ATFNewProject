@UI @Negative
Feature: User Login Negative Flow

  Background: User already has a created Account
    Given user is on the Login page

  @NegativeBaseError
  Scenario: Verify that error message is displayed If user is not able to login with wrong credentials

    When Wrong credentials are generated
    Then Error message:"Warning: No match for E-Mail Address and/or Password." is displayed

  @NegativeDifferentError
  Scenario Outline: Verify that corresponding error is displayed If user login with wrong credentials for n times

    When the user try to enter <times> the following credentials: <email> and <password>
    Then Error message:"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour." is displayed

    Examples:
      | times | email                 | password |
      | 6     | horia.td1cs@yahoo.com | test_01! |
      | 6     | horia.t1rcs@gmail.com | Test_01! |
