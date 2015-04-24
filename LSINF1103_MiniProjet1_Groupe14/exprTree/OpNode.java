package exprTree;

/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Date : 24/04/2015
 * Authors : Antoine Duchêne - Justin Michaux
 */
public class OpNode extends Node {
    OpType type;

    public OpNode(OpType type) {
        super(null, null);
        this.type = type;
    }

    //TODO
    @Override
    public String toString() {
        return Character.toString(type.getOperation());
    }

    @Override
    public double eval() {
        return type.compute(leftNode, rightNode);
    }

    public boolean isDirectlySolvable() {
        return (getLeftNode() instanceof NumberNode && getRightNode() instanceof NumberNode);
    }
}
