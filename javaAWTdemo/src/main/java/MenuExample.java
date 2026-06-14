package main.java;

import java.awt.*;
import java.awt.event.*;

//Driver Class
public class MenuExample {

    //Main Method
    public static void main(String[] args) {
        Frame frame = new Frame("Menu Example");
        MenuBar menuBar = new MenuBar();
        frame.setMenuBar(menuBar);

        // Create a "File" menu
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem closeItem = new MenuItem("Close");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);
        fileMenu.addSeparator();

        // Create an "Exit" menu item with an action listener
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Added exit as item in MenuItem
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
