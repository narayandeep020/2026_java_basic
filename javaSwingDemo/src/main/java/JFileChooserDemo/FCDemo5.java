package main.java.JFileChooserDemo;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

//Example program on JFileChooser( File ) constructor

public class FCDemo5 {

    public static void main(String[] args) {
        // creating object to the JFileChooser class
        // File class
        File f = new File("D:\\wonder_share\\");
        JFileChooser jf = new JFileChooser(f, FileSystemView.getFileSystemView());// parameterised constructor JFileChooser( file ) is called.
        jf.showSaveDialog(null); // opening the saved dialogue
    }
}
