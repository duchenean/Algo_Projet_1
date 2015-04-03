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
}
