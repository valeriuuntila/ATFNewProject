@Edit @UI
Feature: Edit User Account Information

  Background: User already has a created Account and is logged in
    Given user logs in by entering the email:"horia.td@yahoo.com"
    And user logs in by entering the password:"Test_01!"
    And the User click on Login button
    And the User is redirected to the Account page
    And The User Goes to Edit Account page
    And User is on the Edit Account page


  Scenario: Check If user is able to edit Account Information and alert-success message is displayed on account page

    Given User is on the Edit Account page
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

