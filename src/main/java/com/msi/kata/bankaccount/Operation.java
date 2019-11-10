package com.msi.kata.bankaccount;

import java.time.LocalDate;
import java.util.Objects;

public class Operation {
    public enum Type {DEPOSIT, WITHDRAWAL}

    private Type type;
    private Money amount;
    private LocalDate date;

    public Operation(Type type, Money amount, LocalDate date) {
        this.type = type;
        this.date = date;
        if (type == Type.WITHDRAWAL) {
            this.amount = amount.negate();
        } else {
            this.amount = amount;
        }
    }

    public Type getType() {
        return type;
    }

    public Money getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return type == operation.type &&
                Objects.equals(amount, operation.amount) &&
                Objects.equals(date, operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, date);
    }
}