@ItemManage
Feature: Dashboard Item management feature
  User should be able to search, check availability, and view item details on the e-commerce site

  Background:
    Given User is on the e-commerce account homepage

  Scenario: Search for Items
    When User enters "lenovo" in the search bar
    And User clicks on the search button
    Then User should see search results for "lenovo"

  Scenario: Check Availability of Items
    Given User is on the search results page
    When User checks the availability of an item
    Then User should see if the item is available

  Scenario: Display Item Details
    Given User is on the search results page
    When User clicks on an item
    Then User should see the item details page