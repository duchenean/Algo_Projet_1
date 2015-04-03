package builder;

import exprTree.ExprIF;

import java.util.Stack;

/**
 * Project : Algo_Projet_1
 * Package : builder
 * Antoine Duchêne. 3/04/15
 */
public class TreeBuilder implements TreeBuilderIF {
    String exp;

    public TreeBuilder(String exp) {
        this.exp = exp;
    }

    @Override
    public ExprIF build() {
        Stack<String> stack;
        return null;
    }

    private static boolean isOperation(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }

    private static boolean isClosingParenthesis(char c) {
        if (c == ')') {
            return true;
        }
        return false;
    }

    private static boolean isDigit(char c) {
        int NumVal = Character.getNumericValue(c);
        if (NumVal <= 9 && NumVal >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
