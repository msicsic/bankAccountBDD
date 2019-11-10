package com.msi.kata.bankaccount;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.*;

class StatementPrinterTextShould {

    @Test
    void deposit_100() {
        // GIVEN
        PrintStream pStream = mock(PrintStream.class);
        StatementPrinter printer = new StatementPrinterText(pStream);
        LocalDate date = LocalDate.of(2010, 10, 1);
        StatementLine line1 = new StatementLine(new Operation(Operation.Type.DEPOSIT, new Money(100), date), new Money(100));
        Statement statement = new Statement(Collections.singletonList(line1));

        // WHEN
        printer.printStatement(statement);

        // THEN
        verify(pStream, times(1)).println("DEPOSIT 2010-10-01 100 100");
    }
}