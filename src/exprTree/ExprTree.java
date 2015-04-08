package exprTree;

import builder.TreeBuilder;

/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Antoine Duch�ne. 08/04/15
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

    //TODO A am�liorer !
    @Override
    public ExprIF getReducedTree() {

        if (getRoot().getLeftNode() != null && getRoot().getRightNode() != null) {
            ExprTree subLeft = new ExprTree(root.getLeftNode());
            ExprTree subRight = new ExprTree(root.getRightNode());
            ExprTree eL = (ExprTree) subLeft.getReducedTree();
            ExprTree eR = (ExprTree) subRight.getReducedTree();

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

    public void setRoot(Node root) {
        this.root = root;
    }


    //TODO A am�liorer !
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

    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder("( ( ( 2 + 2 ) + ( 9 + 1 ) ) + ( 2 + 5 ) )");
        ExprTree tree = (ExprTree) treeBuilder.build();
        System.out.println(tree.solve());
    }

}
