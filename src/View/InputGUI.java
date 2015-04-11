package View;

import builder.TreeBuilder;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import exprTree.ExprTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project : Algo_Projet_1
 * Package : View
 * Antoine Duchêne. 4/04/15
 */
public class InputGUI extends JFrame {
    private JButton runButton;
    private JTextField expressionTextField;
    private JPanel panel;
    private JTextField resField;
    private JLabel labelRes;

    public InputGUI() {
        super("Expression evaluator v0.1");

        super.setPreferredSize(new Dimension(700, 250));
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Actions();
        setVisible(true);
    }

    public void Actions() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solve();
            }
        });

        expressionTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solve();

            }
        });
    }

    public void solve() {
        String exp = expressionTextField.getText();
        TreeBuilder treeBuilder = new TreeBuilder(exp);
        ExprTree tree = (ExprTree) treeBuilder.build();
        resField.setText(tree.solve());
    }


    public static void main(String[] args) {
        LookAndFeel feel = new WindowsLookAndFeel();
        try {
            UIManager.setLookAndFeel(feel);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        InputGUI gui = new InputGUI();
    }

}
