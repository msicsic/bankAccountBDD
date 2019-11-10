package com.msi.kata.bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OperationShould {

    @Test
    void withdrawal_should_returns_negative_amount() {
        // WHEN
        Operation withdrawal = new Operation(Operation.Type.WITHDRAWAL, new Money(100), LocalDate.now());

        // THEN
        Assertions.assertEquals(new Money(-100), withdrawal.getAmount());
    }
}