package com.msi.kata.bankaccount;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementPrinterText implements StatementPrinter {
    private PrintStream pStream;

    public StatementPrinterText(PrintStream pStream) {
        this.pStream = pStream;
    }

    public void printStatement(Statement statement) {
        List<StatementLine> lines = new ArrayList<>(statement.getLines());
        Collections.reverse(lines);
        lines.forEach(line -> {
            String strLine = line.getOperation().getType() + " " +
                    line.getOperation().getDate().format(DateTimeFormatter.ISO_DATE) + " " +
                    line.getOperation().getAmount() + " " +
                    line.getBalance();
            pStream.println(strLine);
        });
    }
}
