package Parser.Nodes;

import Lexer.Token.ArithmeticOperation;
import Lexer.Token.Token;
import Lexer.Token.TokenType;

public class ExpressionNode extends Node {
    // ATTRIBUTES
    private final Node left;
    private final Token operation;
    private final Node right;

    // CONSTRUCTOR
    public ExpressionNode() {
        this.left = new Node();
        this.operation = new Token(TokenType.NONE);
        this.right = new Node();
    }
    // operation is + or -
    public ExpressionNode(ArithmeticOperationNode left, Token operation, ArithmeticOperationNode right) {
        super(operation);
        this.operation = operation;
        this.left = left;
        this.right = right;
    }
    public ExpressionNode(ArithmeticOperationNode left, Token operation, Node right) {
        super(operation);
        this.operation = operation;
        this.left = left;
        this.right = right;
    }
    public ExpressionNode(Node left, Token operation, Node right) {
        super(operation);
        this.left = left;
        this.operation = operation;
        this.right = right;
    }

    // ACCESSORS
    public Node getLeft() { return left; }
    public Token getOperation() { return operation; }
    public Node getRight() { return right; }

    // TODO: fix to show whole operation (left and right nodes)
    @Override
    public String toString() { return '(' + left.toString() + ' ' + operation.toString() + ' ' + right.toString() + ')'; }
}
