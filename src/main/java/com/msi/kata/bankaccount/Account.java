package com.msi.kata.bankaccount;

import java.time.LocalDate;

public class Account {
    private OperationHistory history;

    public Account(OperationHistory history) {
        this.history = history;
    }

    public void deposit(Money amount, LocalDate date) {
        history.add(Operation.Type.DEPOSIT, amount, date);
    }

    public void printStatement(StatementPrinter printer) {
        printer.printStatement(history.getStatement());
    }
}
