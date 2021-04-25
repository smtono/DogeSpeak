package Parser.Nodes;

import Lexer.Token.Token;

public class VariableAccessNode extends Node {
    // ATTRIBUTES
    private final Token token;

    // CONSTRUCTOR
    public VariableAccessNode(Token token) {
        this.token = token;
    }

    // ACCESSORS
    @Override
    public Token getToken() { return token; }

    @Override
    public String toString() {
        return token.toString();
    }
}