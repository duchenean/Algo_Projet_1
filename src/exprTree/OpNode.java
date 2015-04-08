package exprTree;

/**
 * Created by Antoine on 08/04/2015.
 */
public class OpNode extends Node {
    OpType type;

    public OpNode(Node leftNode, Node rightNode, OpType type) {
        super(leftNode, rightNode);
        this.type = type;
    }

    public OpNode(OpType type) {
        super(null, null);
        this.type = type;
    }


    @Override
    public String toString() {
        switch (type) {
            case MUL:
                return "*";
            case DIV:
                return "/";
            case ADD:
                return "+";
            case SUB:
                return "-";
            default:
                return null;
        }
    }

    @Override
    public double eval() {
        return type.compute(leftNode, rightNode);
    }

    public boolean isDirectlySolvable() {
        return (getLeftNode() instanceof NumberNode && getRightNode() instanceof NumberNode);
    }

    public static void main(String[] args) {
        NumberNode numberNodeL = new NumberNode(25);
        NumberNode numberNodeR = new NumberNode(50);
        NumberNode numberNodeRR = new NumberNode(5);
        OpNode op = new OpNode(numberNodeL, numberNodeR, OpType.SUB);
        OpNode root = new OpNode(op, numberNodeRR, OpType.ADD);
        System.out.println(root.isDirectlySolvable());


    }

}
