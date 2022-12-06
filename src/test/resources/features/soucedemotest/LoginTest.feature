Feature: I want Login to Souce Demo app
  @soucedemo
  Scenario: I Login to souce Demo app
    Given I open Chome
    And I go to "https://www.saucedemo.com/"
    When I put userName "standard_user"
    And I put password "secret_sauce"
    Then I verify I logged
