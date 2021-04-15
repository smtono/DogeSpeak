package Lexer;

// TOKEN TYPES
public enum TokenType {
    // TODO: make operations just under the operator enum
    IDENTIFIER("identifier"),
    COMMENT_START("quite!!"),
    COMMENT_END("!!"),
    OPERATOR(""),
    INTEGER(""),
    FLOAT(""),
    EQUAL("equel"),
    ADD("add"),
    SUBTRACT("sub"),
    MULTIPLY("timez"),
    DIVIDE("divid"),
    UNEXPECTED(""),
    NONE("");

    private final String keyword;
    TokenType(String keyword) { this.keyword = keyword; }
    public String getKeyword() { return keyword; }
}