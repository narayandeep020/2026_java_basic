package main.java.paneDemo;

import javax.swing.*;
import java.awt.*;

public class JScrollPaneExample2 {

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame("Scroll Pane Example");

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new FlowLayout());

        JTextArea area = new JTextArea(20,20);
        JScrollPane scroll = new JScrollPane(area);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scroll);
    }
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
