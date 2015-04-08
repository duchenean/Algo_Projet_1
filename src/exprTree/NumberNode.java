package exprTree;


/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Antoine Duch�ne. 4/04/15
 */
public class NumberNode extends Node2 {

    double number;

    public NumberNode(double number) {
        this.number = number;
    }

    public NumberNode(Node2 leftNode, Node2 rightNode, double number) {
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
