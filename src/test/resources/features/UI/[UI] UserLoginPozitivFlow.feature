@Login @UI
Feature: User Login Positive Flow

  Background: User already has a created Account
    Given User is on the Login page


  Scenario: Successful Login User

    When user logs in with valid credentials email: "horia.td@yahoo.com" and password: "Test_01!"
    Then the User is redirected to the Account page