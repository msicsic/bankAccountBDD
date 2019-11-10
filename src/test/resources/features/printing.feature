Feature: Statement printing
  In order to check my operations
  As a bank client
  I want to see the history (operation, date, amount, balance) of my operations

  Background: I have a provisioned account
    Given I have an empty account

  Scenario: make one deposit on my account and print statement
    Given make the following operations
      | operation | date       | amount |
      | DEPOSIT   | 2010-10-01 | 50     |
    When I ask for the statement
    Then I should see
      | operation | date       | amount | balance |
      | DEPOSIT   | 2010-10-01 | 50     | 50      |
