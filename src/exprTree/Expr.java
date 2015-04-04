package exprTree;

/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Antoine Duchêne. 4/04/15
 */
public class Expr implements ExprIF {
    private Expr nextLeft;
    private Expr nextRight;
    private Expr parent;
    private String content;

    public Expr(String content, Expr parent, Expr nextLeft, Expr nextRight) {
        this.content = content;
        this.parent = parent;
        this.nextLeft = nextLeft;
        this.nextRight = nextRight;
    }

    public Expr(String content) {
        this.content = content;
    }

    public Expr() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setParent(Expr parent) {
        this.parent = parent;
    }

    public void setNextLeft(Expr nextLeft) {
        this.nextLeft = nextLeft;
    }

    public void setNextRight(Expr nextRight) {
        this.nextRight = nextRight;
    }

    public Expr getParent() {
        return parent;
    }

    public Expr getNextLeft() {
        return nextLeft;
    }

    public Expr getNextRight() {
        return nextRight;
    }

    public Object getContent() {
        return content;
    }

    @Override
    public ExprIF getReducedTree() {
        return null;
    }

    @Override
    public String toString() {
        return content;
    }
}

