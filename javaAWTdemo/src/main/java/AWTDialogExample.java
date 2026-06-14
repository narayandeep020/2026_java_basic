package main.java;

import java.awt.*;
import java.awt.event.*;

public class AWTDialogExample {

    public static void main(String[] args) {
        // Create the main frame
        Frame mainFrame = new Frame("AWT Dialog Example");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new FlowLayout());

        // Create a button to open the dialog
        Button openDialogBtn = new Button("Open Dialog");

        // Create the dialog
        Dialog dialog = new Dialog(mainFrame, "My Dialog", true); // true = modal
        dialog.setSize(250, 150);
        dialog.setLayout(new FlowLayout());

        Label label = new Label("Enter your name:");
        TextField textField = new TextField(15);
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // Add components to dialog
        dialog.add(label);
        dialog.add(textField);
        dialog.add(okBtn);
        dialog.add(cancelBtn);

        // OK button action
        okBtn.addActionListener(e -> {
            String name = textField.getText().trim();
            if (name.isEmpty()) {
                // Simple validation
                System.out.println("Name cannot be empty!");
            } else {
                System.out.println("Hello, " + name + "!");
                dialog.setVisible(false);
            }
        });

        // Cancel button action
        cancelBtn.addActionListener(e -> dialog.setVisible(false));

        // Open dialog button action
        openDialogBtn.addActionListener(e -> {
            textField.setText(""); // reset field
            dialog.setVisible(true);
        });

        // Handle window closing for main frame
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                mainFrame.dispose();
            }
        });

        // Handle window closing for dialog
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dialog.setVisible(false);
            }
        });

        // Add button to main frame
        mainFrame.add(openDialogBtn);

        // Show main frame
        mainFrame.setVisible(true);
    }
}
