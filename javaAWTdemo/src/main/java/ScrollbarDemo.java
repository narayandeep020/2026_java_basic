package main.java;

import java.awt.*;

// Driver Class
public class ScrollbarDemo {
    // Main method
    public static void main(String[] args){
      
        // Create a frame
        Frame f = new Frame("Scrollbar Example");
      
        // Create a label and set its properties
        Label l = new Label("GeeksforGeeks");
        l.setBounds(130, 80, 200, 30);
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setForeground(Color.GREEN);
        f.add(l);

        // Create a scrollbar (by default it is vertical)
        Scrollbar s1 = new Scrollbar();
        // Set the position
        s1.setBounds(280, 140, 40, 175);
        f.add(s1);

        // Create its respective label
        Label l1 = new Label("Vertical Scrollbar");
        l1.setBounds(260, 330, 200, 30);
        f.add(l1);

        // Create a horizontal scrollbar
        Scrollbar s2 = new Scrollbar(Scrollbar.HORIZONTAL);
        // Set the position
        s2.setBounds(50, 250, 175, 40);
        f.add(s2);

        // Create its respective label
        Label l2 = new Label("Horizontal Scrollbar");
        l2.setBounds(85, 330, 200, 30);
        f.add(l2);

        // Set the properties of the frame
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}