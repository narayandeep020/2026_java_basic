package main.java;

import java.awt.*;
import java.awt.event.*;

// Driver Class
public class PopupMenuExample {
      // main function
    public static void main(String[] args) {
      
        Frame frame = new Frame("AWT PopupMenu Example");
        frame.setSize(400, 400);

        // Create a PopupMenu
        PopupMenu popupMenu = new PopupMenu();

        // Create MenuItems
        MenuItem menuItem1 = new MenuItem("Option 1");
        MenuItem menuItem2 = new MenuItem("Option 2");
        MenuItem menuItem3 = new MenuItem("Option 3");

        // Add MenuItems to the PopupMenu
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);

        // Add the PopupMenu to the Frame
        frame.add(popupMenu);

        // Add a MouseListener to the Frame to display the PopupMenu
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(frame, e.getX(), e.getY());
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(frame, e.getX(), e.getY());
                }
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
      
    }
}