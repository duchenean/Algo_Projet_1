
import builder.TreeBuilder;
import exprTree.ExprTree;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //TODO meilleure gestion des exeptions (EX: messages d'erreurs etc...)
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                TreeBuilder treeBuilder = new TreeBuilder(line);
                ExprTree tree = (ExprTree) treeBuilder.build();
                String printedLine = tree.solve();
                bufferedWriter.write(printedLine);
                System.out.println(printedLine);
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
