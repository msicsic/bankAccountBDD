package com.msi.kata.bankaccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperationHistoryMemory implements OperationHistory {
    private List<Operation> operations = new ArrayList<>();

    public void add(Operation.Type type, Money amount, LocalDate date) {
        operations.add(new Operation(type, amount, date));
    }

    @Override
    public Statement getStatement() {
        Money balance = new Money(0);
        List<StatementLine> lines = new ArrayList<>();
        for (Operation operation : operations) {
            balance = balance.add(operation.getAmount());
            lines.add(new StatementLine(operation, balance));
        }
        return new Statement(lines);
    }
}
