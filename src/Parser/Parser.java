package Parser;

import Lexer.Lexer;
import Lexer.Token.ArithmeticOperation;
import Lexer.Token.Token;
import Parser.Nodes.ArithmeticOperationNode;
import Parser.Nodes.ExpressionNode;
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

            // Operator : Should not begin with operator, return error
            case OPERATOR:
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
    private ArithmeticOperationNode getTerm() {
        NumberNode leftFactor = (NumberNode) getFactor();
        ArithmeticOperationNode term = new ArithmeticOperationNode();

        //if ()

        // TODO: simplify condition
        while (currentToken.getValue().equals(ArithmeticOperation.ADD) || currentToken.getValue().equals(ArithmeticOperation.SUBTRACT)) {
            Token operatorToken = currentToken;
            advance();
            NumberNode rightFactor = (NumberNode) getFactor();
            term = new ArithmeticOperationNode(leftFactor, operatorToken, rightFactor);
        }
        return term;
    }

    private Node getExpression() {
        ArithmeticOperationNode leftTerm = getTerm();
        ExpressionNode expression = new ExpressionNode();
        boolean inWhile = false;

        // TODO: simplify condition
        while (currentToken.getValue().equals(ArithmeticOperation.MULTIPLY) || currentToken.getValue().equals(ArithmeticOperation.DIVIDE)) {
            inWhile = true;
            Token operatorToken = currentToken;
            advance();
            NumberNode rightFactor = (NumberNode) getFactor();
            expression = new ExpressionNode(leftTerm, operatorToken, rightFactor);
        }

        // TODO: fix for error
        if(inWhile) {
            return expression;
        }
        else {
            return leftTerm;
        }
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
