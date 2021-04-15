package Lexer;

// TOKEN TYPES
public enum TokenType {
    IDENTIFIER("identifier"),
    COMMENT_START("quite!!"),
    COMMENT_END("!!"),
    INTEGER(""),
    FLOAT(""),
    EQUAL("equel"),
    ADD("plus"),
    SUBTRACT("minus"),
    MULTIPLY("timez"),
    DIVIDE("divid"),
    UNEXPECTED(""),
    NONE("");

    private final String keyword;
    TokenType(String keyword) { this.keyword = keyword; }
    public String getKeyword() { return keyword; }
}