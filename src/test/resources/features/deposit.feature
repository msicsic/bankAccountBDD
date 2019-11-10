Feature: deposit money to account
  In order to save money
  As a bank client
  I want to make a deposit in my account

  Background: I have a new empty account
    Given I have an empty account

  Scenario: I make one deposit on my account
    Given I deposit 100 Euros
    When I ask for the statement
    Then My balance should be 100 Euros
