package main.layouts;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// class extends JFrame
class BoderLayoutDemo extends JFrame {

    BoderLayoutDemo()
    {
        
        // Creating Object of Jpanel class
        JPanel pa = new JPanel();

        // set the layout
        pa.setLayout(new BorderLayout());

        // add a new JButton with name "wel" and it is
        // lie top of the container
        pa.add(new JButton("WelCome"), BorderLayout.NORTH);

        // add a new JButton with name "come" and it is
        // lie button of the container
        pa.add(new JButton("Geeks"), BorderLayout.SOUTH);

        // add a new JButton with name "Layout" and it is
        // lie left of the container
        pa.add(new JButton("Layout"), BorderLayout.EAST);

        // add a new JButton with name "Border" and it is
        // lie right of the container
        pa.add(new JButton("Border"), BorderLayout.WEST);

        // add a new JButton with name "hello everybody" and it is
        // lie center of the container
        pa.add(new JButton("GeeksforGeeks"), BorderLayout.CENTER);

        // add the pa object which refer to the Jpanel
        add(pa);

        // Function to close the operation of JFrame.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Function to set size of JFrame.
        setSize(500, 400);

        // Function to set visible status of JFrame.
        setVisible(true);
    }
}

class MainFrame {

    // Driver code
    public static void main(String[] args)
    {
        
        // calling the constructor
        new BoderLayoutDemo();
    }
}