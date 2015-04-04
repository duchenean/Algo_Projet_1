package builder;

import exprTree.ExprIF;

import java.util.Stack;

/**
 * Project : Algo_Projet_1
 * Package : builder
 * Antoine Duchêne. 3/04/15
 */
public class TreeBuilder implements TreeBuilderIF {

    private class Node implements ExprIF {
        private Node nextLeft;
        private Node nextRight;
        private Object content;

        public Node(Object content, Node nextLeft, Node nextRight) {
            this.content = content;
            this.nextLeft = nextLeft;
            this.nextRight = nextRight;
        }

        public Node(Object content) {
            this.content = content;
        }

        public Node() {
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public void setNextLeft(Node nextLeft) {
            this.nextLeft = nextLeft;
        }

        public void setNextRight(Node nextRight) {
            this.nextRight = nextRight;
        }

        public Node getNextLeft() {
            return nextLeft;
        }

        public Node getNextRight() {
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
            return content.toString();
        }
    }

    Node root;
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
        StringBuilder number = new StringBuilder();
        Stack<Node> stack = new Stack<Node>();
        for (int i = 0; i < exp.length(); i++) {
            if (isDigit(exp.charAt(i))) {
                if (!isDigit(exp.charAt(i - 1))) {
                    number.delete(0, number.length());
                    number.append(exp.charAt(i));
                    if (!isDigit(exp.charAt(i + 1))) {
                        Node node = new Node(Integer.parseInt(number.toString()));
                        stack.push(node);
                    }
                } else if (isDigit(exp.charAt(i - 1))) {
                    number.append(exp.charAt(i));
                } else if (exp.charAt(i + 1) == -1) {
                    Node node = new Node(Integer.parseInt(number.toString()));
                    stack.push(node);
                }

            } else if (isOperation(exp.charAt(i))) {
                Node node = new Node(exp.charAt(i));
                stack.push(node);
            } else if (isClosingParenthesis(exp.charAt(i))) {
                Node n2 = stack.pop();
                Node n = stack.pop();
                Node n1 = stack.pop();
                n.setNextLeft(n1);
                n.setNextRight(n2);
                stack.push(n);
            }

        }

        return stack.pop();
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
        if (Character.getNumericValue(c) <= 9 && Character.getNumericValue(c) >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeBuilder tb = new TreeBuilder("( 4 - 2 )");
        tb.build();
    }
}
