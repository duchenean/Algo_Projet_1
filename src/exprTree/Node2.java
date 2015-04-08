package exprTree;


/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Antoine Duchêne. 4/04/15
 */

public abstract class Node2 {
    protected Node2 leftNode;
    protected Node2 rightNode;

    public Node2(Node2 leftNode, Node2 rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node2() {
    }

    public void setLeftNode(Node2 leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node2 rightNode) {
        this.rightNode = rightNode;
    }

    public Node2 getLeftNode() {
        return leftNode;
    }

    public Node2 getRightNode() {
        return rightNode;
    }

    public abstract String toString();

    public abstract double eval();


}

