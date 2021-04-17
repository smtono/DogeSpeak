package Parser.Nodes;

import Lexer.Token.Token;

/**
 *
 */
public class ArithmeticOperationNode extends Node {
    // ATTRIBUTES
    private final Node left;
    private final Token operation;
    private final Node right;

    // CONSTRUCTOR
    public ArithmeticOperationNode(Node left, Token operation, Node right) {
        super(operation);
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    // ACCESSORS
    public Node getLeft() { return left; }
    public Token getOperation() { return operation; }
    public Node getRight() { return right; }

    // TODO: fix to show whole operation (left and right nodes)
    @Override
    public String toString() {
        return operation.toString();
    }
}
