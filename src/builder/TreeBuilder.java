package builder;

import exprTree.Expr;
import exprTree.ExprIF;

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
                while (isDigit(exp.charAt(i))) {
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

    public static void postOrder(Expr root) {
        if (root == null) {
            return;
        }
        postOrder(root.getNextLeft());
        postOrder(root.getNextRight());
        if (root.toString().equals("+")) {
            Double newExpr = Double.parseDouble(root.getNextLeft().toString()) + Double.parseDouble(root.getNextRight().toString());
            root.setContent(newExpr.toString());
            //System.out.println(root);
        }
        if (root.toString().equals("*")) {
            Double newExpr = Double.parseDouble(root.getNextLeft().toString()) * Double.parseDouble(root.getNextRight().toString());
            root.setContent(newExpr.toString());
            //System.out.println(root);
        }
        if (root.toString().equals("/")) {
            Double newExpr = Double.parseDouble(root.getNextLeft().toString()) / Double.parseDouble(root.getNextRight().toString());
            root.setContent(newExpr.toString());
            //System.out.println(root);
        }
        if (root.toString().equals("-")) {
            Double newExpr = Double.parseDouble(root.getNextLeft().toString()) - Double.parseDouble(root.getNextRight().toString());
            root.setContent(newExpr.toString());
            //System.out.println(root);
        }
        if (root.getParent() == null) {
            System.out.println("Résultat : " + root);
        }
    }

    public static void main(String[] args) {
        TreeBuilder tree = new TreeBuilder("( ( 2 + 2 ) * ( 3 - 4 ) )");
        Expr root = (Expr) tree.build();
        System.out.println(root.getReducedTree());


    }
}
