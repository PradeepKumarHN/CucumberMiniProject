@Logout
Feature: Logout from the application

  Scenario: User logs out from the application
    Given User is on the e-commerce account homepage
    When the user clicks on the logout button
    Then the user should be logged out