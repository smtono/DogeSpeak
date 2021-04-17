package Parser;

import Lexer.Token.Token;

import java.util.List;

/**
 *
 */
public class Parser {
    // ATTRIBUTES
    private final List<Token> tokens;
    private int currentPosition;
    private Token currentToken;

    // CONSTRUCTOR
    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        currentPosition = -1;
        currentToken = null;
    }

    // ACCESSORS
    public List<Token> getTokens() { return tokens; }

    // HELPER METHODS
    /** Goes to the next token in the list of tokens */
    private void advance() {
        currentPosition += 1;

        if (currentPosition < tokens.size()) {
            currentToken = tokens.get(currentPosition);
        }
    }

    private void factor() {
        Token token = currentToken;

        
    }

    private void term() {

    }

    private void expression() {

    }

    // TODO: fix
    @Override
    public String toString() {
        return "Parser{" +
                "tokens=" + tokens +
                '}';
    }
}
