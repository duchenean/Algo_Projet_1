package exprTree;


/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Antoine Duchêne. 4/04/15
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

