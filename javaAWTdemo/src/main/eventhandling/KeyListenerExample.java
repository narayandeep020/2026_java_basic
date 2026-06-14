package main.eventhandling;

import java.awt.*;
import java.awt.event.*;

public class KeyListenerExample extends Frame implements KeyListener {

    private TextField textField;
    private Label displayLabel;

    // Constructor
    public KeyListenerExample() {
        // Set frame properties
        setTitle("Typed Text Display");
        setSize(400, 200);
        setLayout(new FlowLayout());

        // Create and add a TextField
        textField = new TextField(20);
        textField.addKeyListener(this);
        add(textField);

        // Create and add a Label
        displayLabel = new Label("Typed Text: ");
        add(displayLabel);

        // Handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Ensure focus
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Center window
        setLocationRelativeTo(null);

        // Make visible
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyChar());
        displayLabel.setText("Typed Text: " + textField.getText());
    }

    public static void main(String[] args) {
        new KeyListenerExample();
    }
}