package Lexer.Token;

import java.util.Arrays;
import java.util.List;

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
    
    // TODO: change this to string value? -> look at github
    public Object getValue() { return value; }

    // HELPER METHODS
    /** Returns if a token type is an ArithmeticOperation or not */
    public boolean isArithmeticOperation() {
        ArithmeticOperation[] operations = ArithmeticOperation.values();

        for (ArithmeticOperation operation : operations) {
            if (operation.equals(value)) {
                return true;
            }
        }

        return false;
    }

    public boolean isNumber() {
        return type == TokenType.INTEGER || type == TokenType.FLOAT;
    }

    @Override
    public String toString() { return type + ": " + value; }
}
