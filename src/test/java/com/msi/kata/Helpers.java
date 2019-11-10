package com.msi.kata;

import com.msi.kata.bankaccount.Money;
import com.msi.kata.bankaccount.Statement;
import com.msi.kata.bankaccount.StatementLine;

import java.util.List;

public class Helpers {

    public static Money getBalance(Statement statement) {
        List<StatementLine> lines = statement.getLines();
        Money balance = new Money(0);
        if (!lines.isEmpty()) {
            balance = lines.get(lines.size() - 1).getBalance();
        }
        return balance;
    }
}
