package main.java;// Java Program to implement
// AWT Panel
import java.awt.*;
import java.awt.event.*;

// Driver Class
public class PanelExample {
      // main function
    public static void main(String[] args) {
      
        Frame frame = new Frame("Java AWT Panel Example");
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();

        // Set the layout manager for panel1
        panel1.setLayout(new FlowLayout());

        // Add components to panel1
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
      
        panel1.add(button1);
        panel1.add(button2);
        panel2.add(button3);

        // Set background colors for panels
        panel1.setBackground(Color.CYAN);
        panel2.setBackground(Color.MAGENTA);

        // Add panels to the frame
        frame.add(panel1);
        frame.add(panel2);

        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
      
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}