package main.java.JFileChooserDemo;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class FCDemo3 {

    public static void main(String[] args){
        JFileChooser fc = new JFileChooser("D:", FileSystemView.getFileSystemView());
        fc.showSaveDialog(null);
    }
}
