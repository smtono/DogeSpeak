package Parser.Nodes;

import Lexer.Token.Token;
import Lexer.Token.TokenType;

/**
 * TODO: documentation lol
 * A generic node class that wi
 */
public class Node {
    // ATTRIBUTES
    private final Token token;

    // CONSTRUCTOR
    public Node() {this.token = new Token(TokenType.NONE);} // default (for variable instantiation)
    public Node(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token.toString();
    }
}
