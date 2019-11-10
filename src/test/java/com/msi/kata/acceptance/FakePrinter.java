package com.msi.kata.acceptance;

import com.msi.kata.bankaccount.Statement;
import com.msi.kata.bankaccount.StatementPrinter;

public class FakePrinter implements StatementPrinter {
    public Statement statement;
    public StatementPrinter delegate;

    public FakePrinter(StatementPrinter delegate) {
        this.delegate = delegate;
    }

    @Override
    public void printStatement(Statement statement) {
        this.statement = statement;
        this.delegate.printStatement(statement);
    }
}
