package com.msi.kata.bankaccount;

import java.time.LocalDate;

public class OperationHistoryMemory implements OperationHistory {

    public void add(Operation.Type type, Money amount, LocalDate date) {
        // TODO
    }

    @Override
    public Statement getStatement() {
        // TODO
        return new Statement();
    }
}
