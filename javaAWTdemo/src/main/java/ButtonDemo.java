package main.java;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonDemo {
    public static void main(String[] args){

        Frame frame = new Frame("Button Example");
        Button button = new Button("Click Me");

        button.setBounds(80,100,60,30);
        button.setBackground(Color.yellow);

        frame.add(button);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
