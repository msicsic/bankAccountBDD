package com.msi.kata.bankaccount;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class AccountShould {

    @Test
    void deposit_100_added_in_history() {
        // GIVEN
        OperationHistory history = mock(OperationHistory.class);
        LocalDate now = LocalDate.now();
        Account account = new Account(history);

        // WHEN
        account.deposit(new Money(100), now);

        // THEN
        verify(history).add(Operation.Type.DEPOSIT, new Money(100), now);
    }

    @Test
    void deposit_100_and_deposit_200_added_in_history() {
        // GIVEN
        OperationHistory history = mock(OperationHistory.class);
        LocalDate now = LocalDate.now();
        Account account = new Account(history);

        // WHEN
        account.deposit(new Money(100), now);
        account.deposit(new Money(200), now);

        // THEN
        InOrder inOrder = inOrder(history);
        inOrder.verify(history).add(Operation.Type.DEPOSIT, new Money(100), now);
        inOrder.verify(history).add(Operation.Type.DEPOSIT, new Money(200), now);
    }

    @Test
    void print_statement_from_history() {
        // GIVEN
        Statement statement = mock(Statement.class);
        OperationHistory history = mock(OperationHistory.class);
        when(history.getStatement()).thenReturn(statement);
        StatementPrinter printer = mock(StatementPrinter.class);
        Account account = new Account(history);

        // WHEN
        account.printStatement(printer);

        // THEN
        verify(history).getStatement();
        verify(printer).printStatement(statement);
    }

    @Test
    void withdrawal_100_added_in_history() {
        // GIVEN
        OperationHistory history = mock(OperationHistory.class);
        LocalDate now = LocalDate.now();
        Account account = new Account(history);

        // WHEN
        account.withdraw(new Money(100), now);

        // THEN
        verify(history).add(Operation.Type.WITHDRAWAL, new Money(100), now);
    }

}