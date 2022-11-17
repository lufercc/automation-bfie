Feature: I login SauceDemo
  Scenario: Login test
    Given I login user "standard_user" with PW "secret_sauc"
    Then I verify I logged PO
