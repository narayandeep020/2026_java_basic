package main.java.components;

import javax.swing.*;

public class JComboBoxExample1 {
    JFrame f;

    JComboBoxExample1(){
        f = new JFrame("ComboBox Example");
        String country[] = {"India","USA","England","Dubai","Africa"};

        JComboBox cb = new JComboBox(country);
        cb.setBounds(50,50,90,20);


        f.add(cb);
        f.setLayout(null);
        f.setSize(400,500);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new JComboBoxExample1();
    }
}
