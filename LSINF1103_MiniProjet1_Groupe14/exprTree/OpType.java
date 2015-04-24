package exprTree;

/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Date : 24/04/2015
 * Authors : Antoine Duchêne - Justin Michaux
 */
public enum OpType {
    ADD('+'),
    MUL('*'),
    SUB('-'),
    DIV('/');

    private final char operation;


    OpType(char operation) {
        this.operation = operation;
    }


    public double compute(Node leftNode, Node rightNode) {
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
    public char getOperation() {
        return operation;
    }

    /**
     * @pre -
     * @post Return le type d'opérateur (OpType) si le caractère est fait partie de OpType
     * Throw une exeption sinon
     */
    public static OpType getOpType(char op) {
        for (OpType type : OpType.values()) {
            if (op == type.getOperation()) {
                return type;
            }
        }
        throw new IllegalArgumentException();
    }
}
