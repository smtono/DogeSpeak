package Interpreter;

import Interpreter.Values.GenericNumber;
import Interpreter.Values.GenericString;
import Lexer.Token.TokenType;
import Parser.Nodes.*;
import Parser.Parser;

public class Interpreter {
    public static VariableDictionary variables = new VariableDictionary(); // this might be bad practice oh well .-.

    // VISIT METHODS
    /** "Visits" each node in the expression and evaluates as necessary with the corresponding method call */
    public static void visit(Node node) {
        try {
            switch (node.getNodeType()) {
                case NUMBER:
                    System.out.println(visitNumberNode((NumberNode) node));
                    break;
                case ARITHMETIC_OPERATION:
                    if (node instanceof ArithmeticOperationNode) {
                        System.out.println(visitArithmeticOperationNode((ArithmeticOperationNode) node));
                    }
                    else if (node instanceof ExpressionNode) {
                        System.out.println(visitExpressionNode((ExpressionNode) node));
                    }
                    break;
                case STRING:
                    if (node instanceof StringConcatenationNode) {
                        System.out.println(visitStringConcatenationNode((StringConcatenationNode) node));
                    }
                    else if (node instanceof StringNode) {
                        System.out.println(visitStringNode((StringNode) node));
                    }
                    break;
                case VARIABLE:
                    visitVariableAssignmentNode((VariableAssignmentNode) node);
                    break;
                case IDENTIFIER:
                    visitVariableAccessNode(node);
                case NONE:
                default:
                    noVisit();
                    break;
            }
        } catch (NullPointerException e) {
            noVisit();
        }
    }

    public static void noVisit() {
        // TODO: implement no visit error
        System.out.println("Error: No visit");
    }

    public static GenericNumber visitArithmeticOperationNode(ArithmeticOperationNode node) {
        if (node.getLeft().getNodeType().equals(NodeType.VARIABLE)) {
            String variableValue = visitVariableAccessNode(node.getLeft());
            node.getLeft().getToken().setValue(variableValue);
        }
        if (node.getRight().getNodeType().equals(NodeType.VARIABLE)) {
            String variableValue = visitVariableAccessNode(node.getRight());
            node.getRight().getToken().setValue(variableValue);
        }
        return node.evaluateExpression();
    }

    public static GenericNumber visitExpressionNode(ExpressionNode node) {
        if (node.getLeft().getNodeType().equals(NodeType.VARIABLE)) {
            String variableValue = visitVariableAccessNode(node.getLeft());
            node.getLeft().getToken().setValue(variableValue);
        }
        if (node.getRight().getNodeType().equals(NodeType.VARIABLE)) {
            String variableValue = visitVariableAccessNode(node.getRight());
            node.getRight().getToken().setValue(variableValue);
        }
        return node.evaluateExpression();
    }

    public static GenericString visitStringConcatenationNode(StringConcatenationNode node) {
        return node.concatenateStrings();
    }

    public static GenericNumber visitNumberNode(NumberNode node) {
        return new GenericNumber(Integer.parseInt(String.valueOf(node.getToken().getValue())));
    }

    public static GenericString visitStringNode(StringNode node) {
        return new GenericString(node.getToken().getValue());
    }

    /** Returns the value of the variable assignment node associated with the variable name passed */
    public static void visitVariableAssignmentNode(VariableAssignmentNode node) {
        String variableName = node.getToken().getValue();
        String value = "";

        if (node.getValue().getToken().getType().equals(TokenType.INTEGER)) {
            value = node.getValue().evaluateExpression().toString();
        }
        else if (node.getValue().getNodeType().equals(NodeType.ARITHMETIC_OPERATION)) {
            value = node.getValue().evaluateExpression().toString();
        }
        else if (node.getValue().getNodeType().equals(NodeType.STRING)) {
            value = node.evaluateString().toString();
        }

        variables.addVariable(variableName, value); // add new variable to dictionary
    }

    /** Returns the value of the variable given */
    public static String visitVariableAccessNode(Node node) {
        String value = variables.getValue(node.getToken().getValue());

        if (value.equals("")) { // if value was not found print error
            System.out.println("Variable does not exist");
            return "";
        }
        else {
            return value;
        }
    }

    // TODO: simplify, put run method in one place
    public static void run(String code) {
        Node node = Parser.run(code);
        visit(node);
    }
}