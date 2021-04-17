package Parser;

import Lexer.Token.ArithmeticOperation;
import Lexer.Token.Token;
import Parser.Nodes.ArithmeticOperationNode;
import Parser.Nodes.Node;
import Parser.Nodes.NumberNode;

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

    /** Returns node type for given token */
    private Node getFactor() {
        Token token = currentToken;

        switch (token.getType()) {
            case INTEGER:
            case FLOAT:
                advance();
                return new NumberNode(token);

            case OPERATOR:
            case EQUAL:
            case IDENTIFIER:
            case COMMENT_START:
            case COMMENT_END:
            case NONE:
            case UNEXPECTED:
        }

        return null;
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
