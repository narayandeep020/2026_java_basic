package main.java.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogExample {
    public static JDialog d;

    JDialogExample(){
        JFrame f = new JFrame();
        d = new JDialog(f,"Dialog Example",true);
        d.setLayout(new FlowLayout());

        JButton b = new JButton("OK");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialogExample.d.setVisible(false);
            }
        });

        d.add(new JLabel("Click Button to continue"));
        d.add(b);
        d.setSize(300,300);
        d.setVisible(true);
    }
    public static void main(String[] args){
        new JDialogExample();
    }
}
