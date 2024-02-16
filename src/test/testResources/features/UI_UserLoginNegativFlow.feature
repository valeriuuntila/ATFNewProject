Feature: User Login Pozitiv Flow

  Background: User already has a created Account
    Given User is on the Login page:"https://ecommerce-playground.lambdatest.io/index.php?route=account/login"


  Scenario Outline: Verify If user is not able to login with invalid credentials

    When the User login with the following invalid details:
      | email   | password    |
      | <email> | <password>> |
    And the User click on Login button
    Then Error message:"!Warning:no match for E-mail Addres and/or Password." is displayed
      Examples:
      | email              | password  |
      | horia.t@yahoo.com  | test_01!  |
      | horia.t@yahoo.com  | Test-01!  |
      | horia.t&yahoo.com  | Test_01!! |
      | horria.t@yahoo.com | Test_01!  |
      | horia.t@gmail.com  | Test_01!  |
      | horia_t@yahoo.com  | Test_01!  |



