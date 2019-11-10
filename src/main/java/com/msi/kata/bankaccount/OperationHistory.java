package com.msi.kata.bankaccount;

import java.time.LocalDate;

public interface OperationHistory {

    void add(Operation.Type type, Money amount, LocalDate date);

    Statement getStatement();
}
