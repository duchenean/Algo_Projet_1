
import builder.TreeBuilder;
import exprTree.ExprTree;
import java.io.*;

/**
 * Project : Algo_Projet_1
 * Package : exprTree
 * Date : 24/04/2015
 * Authors : Antoine Duchêne - Justin Michaux
 */

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                TreeBuilder treeBuilder = new TreeBuilder(line);
                ExprTree tree = (ExprTree) treeBuilder.build();
                String printedLine = tree.solve();
                bufferedWriter.write(printedLine);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
