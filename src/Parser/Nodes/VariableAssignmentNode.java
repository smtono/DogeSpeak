package Parser.Nodes;

import Interpreter.Values.GenericNumber;
import Interpreter.Values.GenericString;
import Lexer.Token.Token;

public class VariableAssignmentNode extends Node {
    // ATTRIBUTES
    private final Token name;
    private final Node value;

    // CONSTRUCTOR
    public VariableAssignmentNode(Token name, Node value) {
        super(name);
        this.name = name;
        this.value = value;
    }

    // ACCESSORS
    public Token getName() { return name; }
    public Node getValue() { return value; }

    @Override
    public GenericNumber evaluateExpression() {
       return getValue().evaluateExpression();
    }

    public GenericString evaluateString() {
        return new GenericString(getValue().getToken().getValue());
    }

    @Override
    public String toString() { return value.toString(); }
}
