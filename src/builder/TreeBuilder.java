package builder;

import exprTree.Expr;
import exprTree.ExprIF;

import java.util.Scanner;
import java.util.Stack;

/**
 * Project : Algo_Projet_1
 * Package : builder
 * Antoine Duchêne. 3/04/15
 */

public class TreeBuilder implements TreeBuilderIF {
    Expr root;
    String exp;

    /**
     * @pre 'exp' est complètement parenthésée et bien formée. Les éléments
     * de l'expression sont séparés par un espace.
     * @post Initialise l'AST
     */
    public TreeBuilder(String exp) {
        this.exp = exp;
    }

    @Override
    public ExprIF build() {
        Stack<Expr> stack = new Stack<Expr>();
        for (int i = 0; i < exp.length(); i++) {
            if (isDigit(exp.charAt(i))) {
                StringBuilder number = new StringBuilder();
                while (i < exp.length() && isDigit(exp.charAt(i))) {
                    //Tant que le nombre n'est pas fini
                    number.append(exp.charAt(i));
                    i++;
                }
                Expr Expr = new Expr(number.toString());
                stack.push(Expr);

            } else if (isOperation(exp.charAt(i))) {
                Expr Expr = new Expr(Character.toString(exp.charAt(i)));
                stack.push(Expr);

            } else if (isClosingParenthesis(exp.charAt(i))) {
                Expr n2 = stack.pop();
                Expr n = stack.pop();
                Expr n1 = stack.pop();
                n1.setParent(n);
                n2.setParent(n);
                n.setNextLeft(n1);
                n.setNextRight(n2);
                stack.push(n);
            }

        }
        return stack.pop(); // Retourne la racine de l'AST
    }

    /**
     * @pre -
     * @post Return true si le caractère est une opération +, -, *, /
     * False sinon
     */
    private static boolean isOperation(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }

    /**
     * @pre -
     * @post Return true si le caractère est ')'
     * False sinon
     */
    private static boolean isClosingParenthesis(char c) {
        if (c == ')') {
            return true;
        }
        return false;
    }

    /**
     * @pre -
     * @post Return true si le caractère est '('
     * False sinon
     */
    private static boolean isOpeningParenthesis(char c) {
        if (c == '(') {
            return true;
        }
        return false;
    }

    /**
     * @pre -
     * @post Return true si le caractère est un chiffre
     * false sinon
     */
    private static boolean isDigit(char c) {
        if ((Character.getNumericValue(c) <= 9 && Character.getNumericValue(c) >= 0) || c == '.') {
            return true;
        }
        return false;
    }

    public Expr getRoot() {
        return root;
    }

    public void setRoot(Expr root) {
        this.root = root;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }


    public static void main(String[] args) {
        //EXEMPLE DE FONCTIONNEMENT
        TreeBuilder tree = new TreeBuilder("( ( 2 + 2 ) * ( 9 - 8 ) )");
        Expr root = (Expr) tree.build();
        Expr res = (Expr) root.getReducedTree();
        System.out.println(res.toString());


    }
}
