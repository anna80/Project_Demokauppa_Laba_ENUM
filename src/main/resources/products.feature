Feature: Work with products
  As a user
  I want to verify to work with products
  So that I can be sure that the site with products work correctly and can add to cart

  Scenario: Verify that the product has specific price
    Given User opens 'Home' page
    And User verify the visibility list of the 6 products
    Then User checks that there are products with a price of 20.0


  Scenario: Verify that the product is added to the cart
    Given User opens 'Home' page
    And User verify the visibility list of the 6 products
    And User clicks on the first product
    And User clicks 'Add to cart' button
    And User clicks by the shopping cart icon
    Then User verifies that the product is added to the cart











