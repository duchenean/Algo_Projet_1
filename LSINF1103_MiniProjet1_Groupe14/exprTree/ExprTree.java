package exprTree;

/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Date : 24/04/2015
 * Authors : Antoine Duchêne - Justin Michaux
 */

public class ExprTree implements ExprIF {
    private Node root;
    public boolean isSimplified = false;


    public ExprTree() {
        this.root = null;
    }

    public ExprTree(Node root) {
        this.root = root;
    }

    @Override
    public ExprIF getReducedTree() {

        if (getRoot().getLeftNode() != null && getRoot().getRightNode() != null) {
            ExprTree subLeft = new ExprTree(root.getLeftNode());
            ExprTree subRight = new ExprTree(root.getRightNode());
            ExprTree eL = (ExprTree) subLeft.getReducedTree(); // Appel récursif
            ExprTree eR = (ExprTree) subRight.getReducedTree(); // Appel récursif

            if (getRoot() instanceof OpNode) {

                if (((OpNode) getRoot()).isDirectlySolvable() && (!eL.isSimplified || !eR.isSimplified)) {
                    root = new NumberNode(root.eval());
                    isSimplified = true;
                    return this;
                }
            }

            if (eL.isSimplified) {
                this.getRoot().setLeftNode(eL.getRoot());
                return new ExprTree(this.getRoot());
            }

            if (eR.isSimplified) {
                this.getRoot().setRightNode(eR.getRoot());
                return new ExprTree(this.getRoot());
            }


        }
        return this;
    }

    /**
     * @pre
     * @post
     */
    public String solve() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this).append(" = ");

        do {
            stringBuilder.append(this.getReducedTree().toString());
            if (this.getRoot().getLeftNode() != null && this.getRoot().getRightNode() != null) {
                stringBuilder.append(" = ");
            }

        } while (this.getRoot().getLeftNode() != null && this.getRoot().getRightNode() != null);

        return stringBuilder.toString();
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {
        String str = null;
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return root.toString();
        } else if (root.getLeftNode() != null && root.getRightNode() != null) {
            ExprTree LeftTree = new ExprTree(root.getLeftNode());
            ExprTree RightTree = new ExprTree(root.getRightNode());
            str = "(" + LeftTree.toString() + root.toString() + RightTree.toString() + ")";
        }
        return str;
    }
}
