package Lexer;

public class Token {
    // TOKEN ATTRIBUTES
    private final TokenType type;
    private final Object value;

    // CONSTRUCTORS
    public Token(TokenType type, Object value) {
        this.type = type;
        this.value = value;
    }
    public Token(TokenType type) {
        this.type = type;
        this.value = null;
    }

    // ACCESSORS
    public TokenType getType() { return type; }
    public Object getValue() { return value; }

    // HELPER METHODS\

    @Override
    public String toString() {
        return "Token: " +
                "type=" + type +
                " value=" + value;
    }
}
