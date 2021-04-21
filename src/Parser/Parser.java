package Parser;

import Lexer.Lexer;
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
        advance();
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

    private Node parse() {
        return getExpression();
    }

    /** Returns node type for given token */
    private Node getFactor() {
        Token token = currentToken;

        switch (token.getType()) {
            case INTEGER:
            case FLOAT:
                advance();
                return new NumberNode(token);

            // Operator : check for each arithmetic operation
            case OPERATOR:
                if (token.getValue().equals(ArithmeticOperation.ADD) || token.getValue().equals(ArithmeticOperation.SUBTRACT)) {

                }

            // Still need to define nodes for these
            case EQUAL:
            case IDENTIFIER:
            case COMMENT_START:
            case COMMENT_END:
            case NONE:
            case UNEXPECTED:
        }

        return null;
    }

    // TODO: Simplify DRY code for getTerm() and getExpression()
    private Node getTerm() {
        Node leftFactor = getFactor();

        while (currentToken.isArithmeticOperation()) {
            Token operatorToken = currentToken;
            advance();
            Node rightFactor = getFactor();
            leftFactor = new ArithmeticOperationNode(leftFactor, operatorToken, rightFactor);
        }
        return leftFactor;
    }

    private Node getExpression() {
        Node leftTerm = getTerm();

        while (currentToken.isArithmeticOperation()) {
            Token operatorToken = currentToken;
            advance();
            Node rightFactor = getFactor();
            leftTerm = new ArithmeticOperationNode(leftTerm, operatorToken, rightFactor);
        }
        return leftTerm;
    }

    public static void run(String code) {
        // Generate tokens
        Lexer lexer = new Lexer(code);
        List<Token> tokens = lexer.makeTokens();

        // Generate AST
        Parser parser = new Parser(tokens);
        System.out.println(parser.parse());
    }
}
