Feature: withdraw money from account
  In order to retrieve some or all of my savings
  As a bank client
  I want to make a withdrawal from my account

  Background: I have a provisioned account
    Given I have an empty account
    And I deposit 100 Euros

  Scenario: I make one withdrawal from my account
    Given I withdraw 20 Euros
    When I ask for the statement
    Then My balance should be 80 Euros
