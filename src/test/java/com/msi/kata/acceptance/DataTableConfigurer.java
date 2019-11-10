package com.msi.kata.acceptance;


import com.msi.kata.bankaccount.Money;
import com.msi.kata.bankaccount.Operation;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.time.LocalDate;
import java.util.Locale;

public class DataTableConfigurer implements TypeRegistryConfigurer {

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(COperation.class, (TableEntryTransformer<COperation>) entry ->
                        new COperation(
                                Operation.Type.valueOf(entry.get("operation")),
                                new Money(Integer.parseInt(entry.get("amount"))),
                                LocalDate.parse(entry.get("date"))
                        )
                )
        );

        registry.defineDataTableType(new DataTableType(CPrintedLine.class, (TableEntryTransformer<CPrintedLine>) entry ->
                        new CPrintedLine(
                                entry.get("operation"),
                                entry.get("date"),
                                entry.get("amount"),
                                entry.get("balance")
                        )
                )
        );
    }

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    static class COperation {
        Operation.Type type;
        LocalDate date;
        Money amount;

        COperation(Operation.Type type, Money amount, LocalDate date) {
            this.type = type;
            this.date = date;
            this.amount = amount;
        }
    }

    static class CPrintedLine {
        String operation;
        String date;
        String amount;
        String balance;

        CPrintedLine(String operation, String date, String amount, String balance) {
            this.operation = operation;
            this.date = date;
            this.amount = amount;
            this.balance = balance;
        }

        public String toString() {
            return operation + " " + date + " " + amount + " " + balance;
        }
    }
}

