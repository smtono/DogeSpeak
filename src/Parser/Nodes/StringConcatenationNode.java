package Parser.Nodes;

import Interpreter.Values.GenericString;

public class StringConcatenationNode extends Node {
    // ATTRIBUTES
    private final StringNode left;
    private final StringNode right;

    // CONSTRUCTOR
    public StringConcatenationNode(StringNode left, StringNode right) {
        super(NodeType.STRING);
        this.left = left;
        this.right = right;
    }

    // ACCESSORS
    public StringNode getLeft() { return left; }
    public StringNode getRight() { return right; }

    // HELPER METHODS
    /** Adds two string values together */
    public GenericString concatenateStrings() {
        GenericString left = new GenericString(getLeft().toString());
        GenericString right = new GenericString(getRight().toString());

        return left.concatenate(right);
    }
}
