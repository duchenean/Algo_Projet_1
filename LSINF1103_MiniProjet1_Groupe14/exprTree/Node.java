package exprTree;


/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Date : 24/04/2015
 * Authors : Antoine Duchêne - Justin Michaux
 */

public abstract class Node {
    protected Node leftNode;
    protected Node rightNode;

    public Node(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node() {
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public abstract String toString();

    public abstract double eval();


}

