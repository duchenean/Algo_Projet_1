package exprTree;
/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Date : 24/04/2015
 * Authors : Antoine Duchêne - Justin Michaux
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
