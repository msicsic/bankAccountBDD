package com.msi.kata.acceptance;

import com.msi.kata.bankaccount.*;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

import java.time.LocalDate;

@SuppressWarnings("ALL")
public class AccountStepDefinitions implements En {
    private LocalDate now = LocalDate.now();
    private OperationHistory history = new OperationHistoryMemory();
    private StatementPrinter printer = new StatementPrinterText();
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

        Then("^My balance should be (\\d+) Euros$", (Integer arg0) -> {
            // TODO check balance in the printer result
            throw new PendingException();
        });

    }

}
