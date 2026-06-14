package main.java;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxDemo {
    // Constructor to initialize
    public CheckBoxDemo()
    {
        // Creating a Frame
        Frame frame = new Frame(
                "Checkbox with ItemListener Example");

        // Creating a Checkbox
        Checkbox checkbox = new Checkbox("Enable Feature");

        // Setting Checkbox position
        checkbox.setBounds(50, 50, 150, 30);

        // Adding ItemListener to Checkbox
        checkbox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                // Handling Checkbox state change event
                if (checkbox.getState()) {
                    System.out.println(
                            "Feature is enabled");
                }
                else {
                    System.out.println(
                            "Feature is disabled");
                }
            }
        });

        // Adding Checkbox to the frame
        frame.add(checkbox);

        // Setting Frame size
        frame.setSize(400, 200);

        // Setting Layout to null
        frame.setLayout(null);

        // Making the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxDemo();
    }
}