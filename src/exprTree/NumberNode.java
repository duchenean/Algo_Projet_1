package exprTree;


/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Antoine Duchêne. 4/04/15
 */
public class NumberNode extends Node {

    double number;

    public NumberNode(double number) {
        this.number = number;
    }

    public NumberNode(Node leftNode, Node rightNode, double number) {
        super(leftNode, rightNode);
        this.number = number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Double.toString(number);
    }

    @Override
    public double eval() {
        return number;
    }
}
