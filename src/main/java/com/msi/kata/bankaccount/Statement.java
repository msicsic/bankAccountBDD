package com.msi.kata.bankaccount;

import java.util.List;
import java.util.Objects;

public class Statement {
    private List<StatementLine> lines;

    public Statement(List<StatementLine> lines) {
        this.lines = lines;
    }

    public List<StatementLine> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(lines, statement.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
