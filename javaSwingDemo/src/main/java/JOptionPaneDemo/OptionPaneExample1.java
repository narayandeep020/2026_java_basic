package main.java.JOptionPaneDemo;

import javax.swing.*;

public class OptionPaneExample1{
    JFrame f;

    OptionPaneExample1(){
        f = new JFrame();
        JOptionPane.showMessageDialog(f,"Hello, Welcome to javaTpoint");
    }
    public static void main(String[] args){
        new OptionPaneExample1();
    }
}