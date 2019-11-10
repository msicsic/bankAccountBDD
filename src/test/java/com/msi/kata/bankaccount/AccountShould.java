package com.msi.kata.bankaccount;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

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

}