@Login @UI
Feature: User Login Positive Flow

  Scenario: Successful Login User

    Given user is on the Login page
    When user logs in with valid credentials email: "horia.td@yahoo.com" and password: "Test_01!"
    Then the User is redirected to the Account page