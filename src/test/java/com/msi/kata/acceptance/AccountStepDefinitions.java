package com.msi.kata.acceptance;

import com.msi.kata.Helpers;
import com.msi.kata.bankaccount.Account;
import com.msi.kata.bankaccount.Money;
import com.msi.kata.bankaccount.OperationHistory;
import com.msi.kata.bankaccount.OperationHistoryMemory;
import cucumber.api.java8.En;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

@SuppressWarnings("ALL")
public class AccountStepDefinitions implements En {
    private LocalDate now = LocalDate.now();
    private OperationHistory history = new OperationHistoryMemory();
    private FakePrinter printer = new FakePrinter();
    private Account account;

    public AccountStepDefinitions() {
        Given("^I have an empty account$", () -> {
            account = new Account(history);
        });

        Given("^I deposit (\\d+) Euros$", (Integer amount) -> {
            account.deposit(new Money(100), now);
        });

        When("^I ask for the statement$", () -> {
            account.printStatement(printer);
        });

        Then("^My balance should be (\\d+) Euros$", (Integer amount) -> {
            Assertions.assertEquals(new Money(amount), Helpers.getBalance(printer.statement));
        });

    }

}
