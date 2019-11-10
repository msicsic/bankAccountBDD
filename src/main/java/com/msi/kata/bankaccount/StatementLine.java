package com.msi.kata.bankaccount;

import java.util.Objects;

public class StatementLine {
    private Operation operation;
    private Money balance;

    public StatementLine(Operation operation, Money balance) {
        this.operation = operation;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public Money getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementLine that = (StatementLine) o;
        return Objects.equals(operation, that.operation) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, balance);
    }
}
