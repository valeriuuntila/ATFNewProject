@Edit @UI
Feature: Edit User Account Information

  Scenario: Check If user is able to edit Account Information

    Given user is logged in with valid credentials email: "horia.td@yahoo.com" and password: "Test_01!"
    And User has opened Edit Account page
    When The User submits following account information:
      | First Name | Tudorita  |
      | Last Name  | Horatiu   |
      | Telephone  | 079555005 |
    And User opens Edit Account page
    Then The Account Information contain updated account information:
      | First Name | Tudorita  |
      | Last Name  | Horatiu   |
      | Telephone  | 079555005 |
