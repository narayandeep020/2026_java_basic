package main.java.paneDemo;

import javax.swing.*;
import java.awt.*;

public class JLayeredPanExample extends JFrame {

    public JLayeredPanExample(){
        super("JLayeredPane Example");
        setSize(400,400);
        JLayeredPane lp = getLayeredPane();

        //Creating Buttons
        JButton top = new JButton();
        top.setBackground(Color.WHITE);
        top.setBounds(20,20,50,50);

        JButton middle = new JButton();
        middle.setBackground(Color.BLUE);
        middle.setBounds(40,40,50,50);

        JButton bottom = new JButton();
        bottom.setBackground(Color.CYAN);
        bottom.setBounds(60,60,50,50);

        //adding buttons on pane
        lp.add(bottom,new Integer(1));
        lp.add(middle,new Integer(2));
        lp.add(top,new Integer(3));
    }
    public static void main(String[] args){
        JLayeredPanExample ex = new JLayeredPanExample();
        ex.setVisible(true);
    }
}
