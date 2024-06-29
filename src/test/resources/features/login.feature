@Login
Feature: Login feature
  User should be able to login into NopCommerce with valid credentials
  User should be prompted to enter valid credentials when invalid credentials are used

  Background:
    Given User is on the NopCommerce homepage
    When User clicks on the login menu

  Scenario Outline: User login with <username> and <password>
    Given User is on the NopCommerce login page
    When User enters "<username>" and "<password>"
    And User clicks on the login button
    Then User should be logged in successfully
    Examples:
      | username        | password  |
      | user1@gmail.com | password1 |
      | user2@gmail.com | password2 |

  Scenario Outline: User login with invalid <username> and <password>
    Given User is on the NopCommerce login page
    When User enters "<username>" and "<password>"
    And User clicks on the login button
    Then User should see an error message "<error_message>"
    Examples:
      | username              | password    | error_message                                                    |
      | invaliduser@gmail.com | invalidpass | Login was unsuccessful. Please correct the errors and try again. |
      | fakeuser@gmail.com    | fakepass    | Login was unsuccessful. Please correct the errors and try again. |

