package main.java.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JColorChooserExample extends JFrame implements ActionListener {
    JButton b;
    Container c;
    JColorChooserExample(){
        c = getContentPane();
        c.setLayout(new FlowLayout());

        b = new JButton("Color");
        b.addActionListener(this);
        c.add(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color initial = Color.RED;
        Color color = JColorChooser.showDialog(this, "Select a Color", initial);
        c.setBackground(color);
    }
    public static void main(String[] args){
        JColorChooserExample ch = new JColorChooserExample();
        ch.setSize(400,400);
        ch.setVisible(true);
        ch.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
