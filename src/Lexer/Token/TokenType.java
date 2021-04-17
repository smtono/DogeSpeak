package Lexer.Token;

// TODO: Split into more specific token classes (and make generic interface)
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

    UNEXPECTED(""),
    NONE("");
    
    // TODO: write method that has a token as an argument
    //  returns true if that token type is here

    private final String keyword;
    TokenType(String keyword) { this.keyword = keyword; }
    public String getKeyword() { return keyword; }
}