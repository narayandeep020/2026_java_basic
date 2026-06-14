package main.java;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LabelTest {

    public static void main(String[] args){

        Frame frame = new Frame("Basic Program");
        Label label = new Label("Hello Java World");

        label.setAlignment(Label.CENTER);

        frame.add(label);
        frame.setSize(300,300);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
