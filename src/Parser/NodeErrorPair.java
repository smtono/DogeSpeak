package Parser;

import Error.*;
import Parser.Nodes.Node;


public class NodeErrorPair {
    private final Node node;
    private final GenericError error;


    public NodeErrorPair(Node node, GenericError error) {
        this.node = node;
        this.error = error;
    }

    public Node getNode() { return node; }
    public GenericError getError() { return error; }
}
