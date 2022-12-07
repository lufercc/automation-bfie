Feature: I add to the cart

  Background:
    Given I login user "standard_user" with PW "secret_sauce"

  @soucedemo @functional @compras
  Scenario: Add Items to the cart33
    When I add to the cart item "Sauce Labs Onesie"
    And I add to the cart item "Sauce Labs Bike Light"
    And I add to the cart item "Fleece Jacket"
    Then I verify the cart has 3 item

  @soucedemo @functional @compras @only
  Scenario Outline: Add Items to the cart
    And I add to the cart item "<item>"
    Then I verify the cart has 1 item
    Examples:
      | item                  |
      | Sauce Labs Onesie     |
      | Sauce Labs Bike Light |

  @soucedemo @functional @compras
  Scenario: Add Items to the cart22
    And I add to the cart item "Sauce Labs Onesie"
    And I add to the cart item "Sauce Labs Bike Light"
    Then I verify the cart has 2 item
