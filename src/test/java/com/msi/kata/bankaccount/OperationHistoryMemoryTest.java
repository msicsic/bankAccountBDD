package com.msi.kata.bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OperationHistoryMemoryTest {

    @Test
    void add_deposit_of_100_and_check_statement() {
        // GIVEN
        OperationHistoryMemory history = new OperationHistoryMemory();
        LocalDate now = LocalDate.now();

        // WHEN
        history.add(Operation.Type.DEPOSIT, new Money(100), now);

        // THEN
        StatementLine expected = new StatementLine(new Operation(Operation.Type.DEPOSIT, new Money(100), now), new Money(100));
        Assertions.assertEquals(expected, history.getStatement().getLines().get(0));
    }
}