@Login
Feature: User Login Pozitiv Flow

  Background: User already has a created Account
    Given User is on the Login page


  Scenario: Successful Login User

    When user logs in by entering the email:"horia.td@yahoo.com"
    And user logs in by entering the password:"Test_01!"
    And the User click on Login button
    Then the User is redirected to the Account page