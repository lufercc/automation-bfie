Feature: I login SauceDemo
  @soucedemo @functional @login
  Scenario: Login test
    Given I login user "standard_user" with PW "secret_sauce"
    Then I verify I logged PO
