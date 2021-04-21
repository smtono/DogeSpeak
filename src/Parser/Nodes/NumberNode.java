package Parser.Nodes;

import Lexer.Token.Token;
import Lexer.Token.TokenType;

/**
 *
 */
public class NumberNode extends Node {
    // NUMBER NODE ATTRIBUTES
    private final Token token;

    // CONSTRUCTOR
    public NumberNode(Token token) {
        super(token);
        this.token = token;
    }

    // ACCESSORS
    public Token getToken() { return token; }

    // HELPER METHODS
    /** returns whether the token is an integer or float */
    public boolean isInteger() { return token.getType().equals(TokenType.INTEGER); }
    public boolean isFloat() { return token.getType().equals(TokenType.FLOAT); }

    @Override
    public String toString() {
        return token.toString();
    }
}
