package main.java.paneDemo;

import javax.swing.*;

public class JScrollPaneExample1 {

    public static void main(String[] args) {
        // Create a JTextArea with a lot of text
        JTextArea textArea = new JTextArea(20, 40);
        for (int i = 1; i < 40; i++) {
            textArea.append("Line " + i + "\n");
        }


        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a JFrame to hold the scroll pane
        JFrame frame = new JFrame("ScrollPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}
