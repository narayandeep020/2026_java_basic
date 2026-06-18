package main.java.paneDemo;

import javax.swing.*;
import java.awt.*;

public class JSplitPaneExample{
    private static void createAndShow(){
        final JFrame frame = new JFrame("JSplitPane Example");

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new FlowLayout());
        String[] option1 = {"A","B","C","D","E"};
        JComboBox box1 = new JComboBox(option1);
        String[] option2 = {"1","2","3","4","5"};
        JComboBox box2 = new JComboBox(option2);

        Panel p1 = new Panel();
        p1.add(box1);
        Panel p2 = new Panel();
        p2.add(box2);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,p2);
        frame.getContentPane().add(split);
    }
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShow();
            }
        });
    }
}