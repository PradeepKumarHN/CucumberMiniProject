@Register
  Feature: Register to NopCommerce


    Scenario Outline: Create a new login
      Given I am on the NopCommerce registration page
      When I enter user first name <firstname> and last name <lastname>
      And I enter the email "<email>" the password "<password>"
      And I click on the register button
      Then I should see a registration success message

      Examples:
        | firstname | lastname | email           | password  |
        | user1     | last     | user1@gmail.com | password1 |
        | user2     | last     | user2@gmail.com | password2 |
