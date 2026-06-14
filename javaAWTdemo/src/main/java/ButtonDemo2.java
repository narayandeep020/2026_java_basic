package main.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo2 {

    public static void main(String[] args){

        Frame frame = new Frame("AWT Button Example");
        Button button = new Button("Click Here!");

        button.setBounds(160,80,80,40);
        button.setBackground(Color.green);
//        button.setForeground(Color.white);

        Label label = new Label();

        label.setBounds(80,140,280,20);
        label.setForeground(Color.blue);
        label.setFont(new Font("Arial",Font.BOLD,14));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Hey Buddy, WelCome To Java Program");
            }
        });
        frame.add(button);
        frame.add(label);
        frame.setBackground(Color.lightGray);
        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
