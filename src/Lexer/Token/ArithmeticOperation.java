package Lexer.Token;

import java.util.Arrays;
import java.util.List;

public enum ArithmeticOperation {
    ADD("add"),
    SUBTRACT("sub"),
    MULTIPLY("timez"),
    DIVIDE("divid");

    private final String keyword;
    ArithmeticOperation(String keyword) { this.keyword = keyword; }
    public String getKeyword() { return keyword; }
}