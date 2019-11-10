package com.msi.kata.acceptance;

import com.msi.kata.Helpers;
import com.msi.kata.bankaccount.*;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class AccountStepDefinitions implements En {
    private LocalDate now = LocalDate.now();
    private OperationHistory history = new OperationHistoryMemory();
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private StatementPrinterText realPrinter = new StatementPrinterText(new PrintStream(buffer));
    private FakePrinter printer = new FakePrinter(realPrinter);
    private Account account;

    public AccountStepDefinitions() {
        Given("^I have an empty account$", () -> {
            account = new Account(history);
        });

        Given("^I deposit (\\d+) Euros$", (Integer amount) -> {
            account.deposit(new Money(amount), now);
        });

        Given("^I withdraw (\\d+) Euros$", (Integer amount) -> {
            account.withdraw(new Money(amount), now);
        });

        Given("^make the following operations$", (DataTable table) -> {
            List<DataTableConfigurer.COperation> operations = table.asList(DataTableConfigurer.COperation.class);
            operations.forEach(operation -> {
                if (operation.type == Operation.Type.DEPOSIT) {
                    account.deposit(operation.amount, operation.date);
                } else {
                    account.withdraw(operation.amount, operation.date);
                }
            });
        });

        When("^I ask for the statement$", () -> {
            account.printStatement(printer);
        });

        Then("^My balance should be (\\d+) Euros$", (Integer amount) -> {
            Assertions.assertEquals(new Money(amount), Helpers.getBalance(printer.statement));
        });

        Then("^I should see$", (DataTable table) -> {
            String expected = table.asList(DataTableConfigurer.CPrintedLine.class).stream().map(Object::toString).collect(Collectors.joining(System.lineSeparator())) + System.lineSeparator();
            Assertions.assertEquals(expected, new String(buffer.toByteArray()));
        });
    }

}
