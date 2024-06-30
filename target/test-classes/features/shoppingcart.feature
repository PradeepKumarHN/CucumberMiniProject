Feature: Managing items in the shopping cart

Scenario: User adds an item to the shopping cart
Given the user has searched for items
When the user selects an item from the search results
And the user clicks on the Add to Cart button
Then the item should be added to the shopping cart
#
#Scenario: User views the shopping cart
#Given the user has added items to the shopping cart
#When the user clicks on the "Shopping Cart" button
#Then the user should see the items in the shopping cart
#
#Scenario: User edits the quantity of an item in the shopping cart
#Given the user is viewing the shopping cart
#When the user changes the quantity of an item
#And the user clicks on the "Update Cart" button
#Then the shopping cart should be updated with the new quantity
#
#Scenario: User removes an item from the shopping cart
#Given the user is viewing the shopping cart
#When the user clicks on the "Remove" button for an item
#Then the item should be removed from the shopping cart