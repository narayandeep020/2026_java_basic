package main.eventhandling;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionListenerDemo implements ActionListener {
    JCheckBox cb1, cb2, cb3;

    ActionListenerDemo(){
      
        // Create a frame
        Frame f = new Frame("AWT ActionListener Example");
      
        // Create a label
        Label l = new Label("Food Menu");
      
        // Set the positions
        l.setBounds(150, 50, 300, 20);

        // Create check boxes and set the positions
        cb1 = new JCheckBox("Pizza @ 100");
        cb1.setBounds(100, 100, 150, 20);
        cb2 = new JCheckBox("Burger @ 30");
        cb2.setBounds(100, 150, 150, 20);
        cb3 = new JCheckBox("Tea @ 10");
        cb3.setBounds(100, 200, 150, 20);

        // Create a button and set the positions
        Button b = new Button("Order");
        b.setBounds(100, 250, 80, 30);
      
        // Add action listener to the button
        b.addActionListener(this);

        // Add components to the frame
        f.add(l);
        f.add(cb1);
        f.add(cb2);
        f.add(cb3);
        f.add(b);

        // Set the size of the frame and make it visible
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    // Override the actionPerformed() method
    public void actionPerformed(ActionEvent e){
      
        // Calculate the total amount and display it
        float amount = 0;
        String msg = "";
        if (cb1.isSelected()) {
            amount += 100;
            msg = "Pizza: 100\n";
        }
        if (cb2.isSelected()) {
            amount += 30;
            msg += "Burger: 30\n";
        }
        if (cb3.isSelected()) {
            amount += 10;
            msg += "Tea: 10\n";
        }
        msg += "-----------------\n";
        JOptionPane.showMessageDialog(
            null, msg + "Total: " + amount);
    }

    // Main method
    public static void main(String[] args) { 
      new ActionListenerDemo();
    }
}