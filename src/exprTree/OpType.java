package exprTree;

/**
 * Created by Antoine on 08/04/2015.
 */
public enum OpType {
    ADD('+'),
    MUL('*'),
    SUB('-'),
    DIV('/');

    public char getOperation() {
        return operation;
    }

    private final char operation;

    OpType(char operation) {
        this.operation = operation;
    }


    public double compute(Node2 leftNode, Node2 rightNode) {
        switch (this) {
            case MUL:
                return leftNode.eval() * rightNode.eval();
            case DIV:
                return leftNode.eval() / rightNode.eval();
            case ADD:
                return leftNode.eval() + rightNode.eval();
            case SUB:
                return leftNode.eval() - rightNode.eval();
            default:
                return Double.NaN;
        }
    }
}
