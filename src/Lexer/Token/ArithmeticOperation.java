package Lexer.Token;

public enum ArithmeticOperation {
    ADD("add"),
    SUBTRACT("sub"),
    MULTIPLY("timez"),
    DIVIDE("divid");

    // TODO: write method that has a token as an argument
    //  returns true if that token type is here

    private final String keyword;
    ArithmeticOperation(String keyword) { this.keyword = keyword; }
    public String getKeyword() { return keyword; }
}