
import builder.TreeBuilder2;
import exprTree.ExprTree2;
import exprTree.Node2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //TODO meilleure gestion des exeptions (EX: messages d'erreurs etc...)
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                TreeBuilder2 treeBuilder2 = new TreeBuilder2(line);
                ExprTree2 tree = (ExprTree2) treeBuilder2.build();
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
