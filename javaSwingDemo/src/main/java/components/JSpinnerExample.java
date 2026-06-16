package main.java.components;

import javax.swing.*;

public class JSpinnerExample {
    public static void main(String[] args){
        JFrame f=new JFrame("Spinner Example");

        SpinnerModel value = new SpinnerNumberModel(5,0,10,1);
        JSpinner spin = new JSpinner(value);

        spin.setBounds(100,100,50,30);
        f.add(spin);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
