package Parser.Nodes;

import Lexer.Token.ArithmeticOperation;
import Lexer.Token.Token;
import Lexer.Token.TokenType;

/**
 *
 */
public class ArithmeticOperationNode extends Node {
    // ATTRIBUTES
    private final Node left;
    private final Token operation;
    private final Node right;

    // CONSTRUCTOR
    public ArithmeticOperationNode() {
        this.left = new Node();
        this.operation = new Token(TokenType.NONE);
        this.right = new Node();
    }
    public ArithmeticOperationNode(NumberNode left, Token operation, NumberNode right) {
        super(operation);
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    // ACCESSORS
    public Node getLeft() { return left; }
    // TODO ._.
    public ArithmeticOperation getOperation() { return (ArithmeticOperation) operation.getValue(); }
    public Node getRight() { return right; }

    // TODO: fix to show whole operation (left and right nodes)
    @Override
    public String toString() { return '(' + left.toString() + ' ' + operation.toString() + ' ' + right.toString() + ')'; }
}
