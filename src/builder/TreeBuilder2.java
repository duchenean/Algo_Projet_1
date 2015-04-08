package builder;

import exprTree.*;

import java.util.Stack;

/**
 * Project : Algo_Projet_1
 * Package : builder
 * Antoine Duchêne. 3/04/15
 */

public class TreeBuilder2 implements TreeBuilderIF {
    private String exp;

    /**
     * @pre 'exp' est complètement parenthésée et bien formée. Les éléments
     * de l'expression sont séparés par un espace.
     * @post Initialise l'AST
     */
    public TreeBuilder2(String exp) {
        this.exp = exp;
    }

    @Override
    public ExprIF build() {
        Stack<Node2> stack = new Stack<Node2>();
        for (int i = 0; i < exp.length(); i++) {
            char currentChar = exp.charAt(i);
            if (isDigit(currentChar)) {
                StringBuilder number = new StringBuilder();
                while (i < exp.length() && isDigit(exp.charAt(i))) {   //Tant que le nombre n'est pas fini
                    number.append(exp.charAt(i));
                    i++;
                }
                Node2 Node = new NumberNode(Double.parseDouble(number.toString()));
                stack.push(Node);

            } else if (isOperation(currentChar)) {

                Node2 Node = new OpNode(getOpType(currentChar));
                stack.push(Node);

            } else if (isClosingParenthesis(currentChar)) {
                Node2 rightNode = stack.pop();
                Node2 root = stack.pop();
                Node2 leftNode = stack.pop();
                root.setLeftNode(leftNode);
                root.setRightNode(rightNode);
                stack.push(root);
            }

        }
        return new ExprTree2(stack.pop()); // Retourne la racine de l'AST
    }

    /**
     * @pre -
     * @post Return true si le caractère est une opération +, -, *, /
     * False sinon
     */
    private static boolean isOperation(char c) {
        for (OpType type : OpType.values()) {
            if (c == type.getOperation()) {
                return true;
            }
        }
        return false;
    }

    /**
     * @pre -
     * @post Return le type d'opérateur (OpType) si le caractère est fait partie de OpType
     * Throw une exeption sinon
     */
    private static OpType getOpType(char op) {
        for (OpType type : OpType.values()) {
            if (op == type.getOperation()) {
                return type;
            }
        }
        throw new IllegalArgumentException();
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
     * @post Return true si le caractère est un chiffre
     * false sinon
     */
    private static boolean isDigit(char c) {
        if ((Character.getNumericValue(c) <= 9 && Character.getNumericValue(c) >= 0) || c == '.') {
            return true;
        }
        return false;
    }
}
