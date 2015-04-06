
import builder.TreeBuilder;
import exprTree.ExprIF;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //TODO meilleure gestion des exeptions (EX: messages d'erreurs etc...)
        try {
            long before = System.currentTimeMillis();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                TreeBuilder tree = new TreeBuilder(line);
                ExprIF root = tree.build();
                bufferedWriter.write(root.getReducedTree().toString());
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
