package Interpreter;

import Lexer.Token.ArithmeticOperation;
import Parser.Nodes.ExpressionNode;
import Parser.Nodes.Node;
import Parser.Nodes.NumberNode;
import Parser.Parser;

public class Interpreter {

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
                    System.out.println(visitOperationNode((ExpressionNode) node));
                    break;
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

    public static GenericNumber visitOperationNode(ExpressionNode node) {
        //System.out.println("Found operation node");

        GenericNumber left = new GenericNumber(Integer.parseInt(String.valueOf(node.getLeft().getToken().getValue())));
        int right = Integer.parseInt(String.valueOf(node.getRight().getToken().getValue()));

        switch (ArithmeticOperation.getArithmeticOperation(node.getOperation().getValue())) {
            case ADD:
                return left.plus(right);
            case SUBTRACT:
                return left.minus(right);
            case MULTIPLY:
                return left.times(right);
            case DIVIDE:
                return left.dividedBy(right);
        }
        return new GenericNumber();
    }

    public static GenericNumber visitNumberNode(NumberNode node) {
       // System.out.println("Found number node");
        //System.out.println(number);
        return new GenericNumber(Integer.parseInt(String.valueOf(node.getToken().getValue())));
    }

    // TODO: simplify, put run method in one place
    public static void run(String code) {
        Node node = Parser.run(code);
        visit(node);
    }
}
