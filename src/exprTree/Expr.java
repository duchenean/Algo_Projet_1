package exprTree;


import java.util.Locale;
import java.util.Scanner;

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


    public Expr(String content, Expr nextLeft, Expr nextRight) {
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public static boolean isDouble(String s) {
        Scanner sc = new Scanner(s);
        sc.useLocale(Locale.US);
        return sc.hasNextDouble();
    }

    public static double toDouble(String s) {
        Scanner sc = new Scanner(s);
        sc.useLocale(Locale.US);
        return sc.nextDouble();
    }

    @Override
    public ExprIF getReducedTree() {
        if (nextRight != null && nextLeft != null) {
            nextLeft.getReducedTree();
            nextRight.getReducedTree();
            if (content.equals("+")) {
                Double newExpr = Double.parseDouble(nextLeft.getContent()) + Double.parseDouble(nextRight.getContent());
                content = newExpr.toString();
            }
            if (content.equals("*")) {
                Double newExpr = Double.parseDouble(nextLeft.getContent()) * Double.parseDouble(nextRight.getContent());
                content = newExpr.toString();
            }
            if (content.equals("/")) {
                Double newExpr = Double.parseDouble(nextLeft.getContent()) / Double.parseDouble(nextRight.getContent());
                content = newExpr.toString();
            }
            if (content.equals("-")) {
                Double newExpr = Double.parseDouble(nextLeft.getContent()) - Double.parseDouble(nextRight.getContent());
                content = newExpr.toString();
            }
        }
        return this;
    }

    @Override
    public String toString() {
        if (nextRight != null && nextLeft != null) {
            nextLeft.toString();
            nextRight.toString();
            if (!isDouble(nextRight.getContent()) && !isDouble(nextLeft.getContent())) {
                content = "(" + nextLeft.getContent() + this.getContent() + nextRight.getContent() + ")";
            }
            if (isDouble(nextRight.getContent()) && !isDouble(nextLeft.getContent())) {
                content = "(" + nextLeft.getContent() + this.getContent() + toDouble(nextRight.getContent()) + ")";
            }
            if (!isDouble(nextRight.getContent()) && isDouble(nextLeft.getContent())) {
                content = "(" + toDouble(nextLeft.getContent()) + this.getContent() + nextRight.getContent() + ")";
            }
            if (isDouble(nextRight.getContent()) && isDouble(nextLeft.getContent())) {
                content = "(" + toDouble(nextLeft.getContent()) + this.getContent() + toDouble(nextRight.getContent()) + ")";
            }
        }
        return this.content;
    }
}

