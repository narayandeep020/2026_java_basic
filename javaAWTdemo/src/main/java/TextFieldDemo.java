package main.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo {

    public static void main(String[] args){

        Frame frame = new Frame("TextField Example");

        TextField tf1 = new TextField();
        tf1.setBounds(50,50,200,30);

        TextField tf2 = new TextField();
        tf2.setBounds(50,100,200,30);

        frame.add(tf1);
        frame.add(tf2);

        frame.setSize(300,200);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
