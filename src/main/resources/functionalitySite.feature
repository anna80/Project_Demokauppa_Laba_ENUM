Feature: FunctionalitySite
  As a user
  I want to verify a shopping cart functionality
  So that I can be sure that a shopping cart on the site works correctly

  Scenario Outline: Verify that the cart popup is opened after clicking by shopping cart icon
    Given User opens 'Home' page
    And User verify the visibility of the cart icon
    When User clicks by the shopping cart icon
    Then Cart page with '<shoppingCartPage>' url is opened
    Examples:
      | shoppingCartPage                         |
      | http://kuopassa.net/litecart/en/checkout |

  Scenario: Verify that the link is opened after clicking by link
    Given User opens 'Home' page
    And User verify the visibility of the link new customer
    When User clicks by the link new customer
    Then Cart page with 'SignIn' url is opened


  Scenario: Verify that the link is opened after clicking by link
    Given User opens 'Home' page
    And User verify the visibility of the link button Sign In
    And Anonymous user sets data with following values:
      | fieldName | fieldValue            |
      | email     | gisof96388@meidir.com |
      | password  | DashaMasha2022        |
    Then User click by the button Sign In


  Scenario Outline: Search products by keyword
    Given User opens 'Home' page
    And User verify search field visibility
    When User searches products by '<keyword>' keyword
    Examples:
      | keyword  |
      | Red Duck |
