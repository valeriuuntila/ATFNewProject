@Edit @UI
Feature: Edit User Account Information

  Scenario: Check If user is able to edit Account Information and alert-success message is displayed on account page

    Given user logs in with email: "horia.td@yahoo.com" and password: "Test_01!"
    And User clicks on the Edit Account page
    When The User enters following account information:
      | First Name | Tudorita  |
      | Last Name  | Horatiu   |
      | Telephone  | 079555005 |
    And The User click on Continue button
    Then Alert message:"Success: Your account has been successfully updated." is displayed on account page.
    When The User Goes to Edit Account page
    Then  The Account Information  contain the following:
      | First Name | Tudorita  |
      | Last Name  | Horatiu   |
      | Telephone  | 079555005 |

