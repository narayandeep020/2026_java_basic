package main.java.paneDemo;

import javax.swing.*;

public class JRootPaneExample {

     public static void main(String[] args) {

            JFrame f = new JFrame();
            f.setSize(100,100);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            JRootPane root = f.getRootPane();
  
            // Create a menu bar  
            JMenuBar bar = new JMenuBar();  
            JMenu menu = new JMenu("File");  
            bar.add(menu);  
            menu.add("Open");  
            menu.add("Close");  
            root.setJMenuBar(bar);  
  
            // Add a button to the content pane  
            root.getContentPane().add(new JButton("Press Me"));  
  
            // Display the UI  
            f.pack();  
            f.setVisible(true);
          }  
}  