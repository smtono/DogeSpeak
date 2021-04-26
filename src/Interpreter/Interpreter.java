package Interpreter;

import Lexer.Token.ArithmeticOperation;
import Parser.Nodes.*;
import Parser.Parser;

public class Interpreter {
    public static VariableDictionary variables = new VariableDictionary(); // this might be bad practice oh well .-.

    // VISIT METHODS
    /** "Visits" each node in the expression and evaluates as necessary with the corresponding method call */
    public static void visit(Node node) {
        // TODO: fix this garbage it's "BAD PRACTICE" (╬▔皿▔)╯
        try {
            switch (node.getNodeType()) {
                case NUMBER:
                    System.out.println(visitNumberNode((NumberNode) node));
                    break;
                case ARITHMETIC_OPERATION:
                    System.out.println(visitOperationNode((ArithmeticOperationNode) node));
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

    public static GenericNumber visitOperationNode(ArithmeticOperationNode node) {
        if (node.getLeft().getNodeType().equals(NodeType.VARIABLE)) {
            String variableValue = visitVariableAccessNode(node);
            node.getToken().setValue(variableValue);
        }
        return node.evaluateExpression();
    }

    public static GenericNumber visitNumberNode(NumberNode node) {
       // System.out.println("Found number node");
        //System.out.println(number);
        return new GenericNumber(Integer.parseInt(String.valueOf(node.getToken().getValue())));
    }

    /** returns the value of the variable assignment node associated with the variable name passed */
    public static void visitVariableAssignmentNode(VariableAssignmentNode node) {
        String variableName = node.getToken().getValue();
        String value = node.getValue().evaluateExpression().toString();

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