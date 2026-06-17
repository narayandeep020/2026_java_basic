package main.java.JFileChooserDemo;

import javax.swing.*;

public class FCDemo2 {

    public static void main(String[] args){
        JFileChooser jf = new JFileChooser("D:");
        jf.showSaveDialog(null);
    }
}
