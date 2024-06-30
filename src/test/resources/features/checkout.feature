Feature: E-commerce Shopping Cart checkout and order details

  Scenario: Check out the Shopping Cart
    Given User is on e-commerce account homepage
    And User has items in the shopping cart
    When User proceeds to checkout
#    And User enters shipping and payment details
#    And User confirms the order
#    Then User should see the order confirmation page
#
#  Scenario: Check Order Status
#    Given User is on the e-commerce account homepage
#    And User is logged in with valid credentials
#    When User navigates to the order history page
#    And User selects an order to view details
#    Then User should see the order status
#
#
#  Scenario: Display Item Details
#    Given User is on the e-commerce account homepage
#    And User is logged in with valid credentials
#    When User searches for an item by name
#    And User clicks on an item from the search results
#    Then User should see the item details page