package Parser.Nodes;

import Interpreter.GenericNumber;
import Lexer.Token.Token;
import Lexer.Token.TokenType;

/**
 * TODO: documentation lol
 * A generic node class that wi
 */
public class Node {
    // ATTRIBUTES
    private final Token token;
    private final NodeType nodeType;


    // CONSTRUCTOR
    public Node() { // default (for variable instantiation)
        this.token = new Token(TokenType.NONE);
        this.nodeType = NodeType.NONE;
    }

    public Node(Token token) {
        this.token = token;

        switch (token.getType()) {
            case INTEGER:
            case FLOAT:
                this.nodeType = NodeType.NUMBER;
                break;
            case OPERATOR:
                this.nodeType = NodeType.ARITHMETIC_OPERATION;
                break;
            case VARIABLE:
            case IDENTIFIER:
            case VARIABLE_INSTANTIATION:
                this.nodeType = NodeType.VARIABLE;
                break;
            default:
                this.nodeType = NodeType.NONE;
        }
    }

    // ACCESSORS
    public Token getToken() { return token; }
    public NodeType getNodeType() { return nodeType; }

    // other
    public GenericNumber evaluateExpression() {
        return new GenericNumber(Integer.parseInt(token.getValue()));
    }

    @Override
    public String toString() {
        return token.toString();
    }
}
