package main.eventhandling;

import java.awt.*;
import java.awt.event.*;

// Driver Class
class CheckboxExample {
      // Main function
    public static void main(String[] args) {
        // Create a new frame with a title.
        Frame frame = new Frame("Checkbox Example");
        
        // Create a checkbox labeled "Enable Feature."
        Checkbox checkbox = new Checkbox("Enable Feature");

        // Create an instance of MyItemListener to handle checkbox events.
        MyItemListener itemListener = new MyItemListener();
        
        // Register the itemListener with the checkbox to listen for events.
        checkbox.addItemListener(itemListener);

        // Add the checkbox to the frame.
        frame.add(checkbox);
        
        // Set the frame size and layout.
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        
        // Make the frame visible.
        frame.setVisible(true);
    }
}

class MyItemListener implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // Respond when the checkbox is selected (checked).
            System.out.println("Feature is enabled.");
        } else {
            // Respond when the checkbox is deselected (unchecked).
            System.out.println("Feature is disabled.");
        }
    }
}