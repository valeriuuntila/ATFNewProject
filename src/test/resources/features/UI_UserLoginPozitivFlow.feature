Feature: User Login Pozitiv Flow

  Background: User already has a created Account
    Given User is on the Login page:"https://ecommerce-playground.lambdatest.io/index.php?route=account/login"


  Scenario Outline: Successful Login User

    When user logs in by entering the email:"horia.t@yahoo.com"
    And user logs in by entering the password:"Test_01!"
    And the User click on Login button
    Then the User is redirected to the Account page
    And the User's login is successful
