/*
 * Exemple de test sans lecture et écriture des fichiers
 */
 
import builder.TreeBuilder;
import builder.TreeBuilderIF;
import exprTree.ExprIF;

public class Main {
    public static void main(String[] args) {
        TreeBuilderIF tb = new TreeBuilder("( ( 1 + 2 ) * 3 )");
        ExprIF t = tb.build();
        //TODO Terminer args input
    }
}
