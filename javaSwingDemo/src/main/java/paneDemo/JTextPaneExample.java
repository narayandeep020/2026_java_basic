package main.java.paneDemo;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class JTextPaneExample {

    public static void main(String[] args) throws BadLocationException {
        JFrame frame = new JFrame("JTextPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = frame.getContentPane();
        JTextPane tp = new JTextPane();
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBold(sas,true);

        tp.setCharacterAttributes(sas,true);
        tp.setText("Welcome");

        sas = new SimpleAttributeSet();
        StyleConstants.setItalic(sas,true);
        StyleConstants.setForeground(sas,Color.YELLOW);
        StyleConstants.setBackground(sas,Color.BLUE);

        Document doc = tp.getStyledDocument();
        doc.insertString(doc.getLength(), "To Java ", sas);

        sas = new SimpleAttributeSet();
        doc.insertString(doc.getLength(), "World", sas);

        JScrollPane sp = new JScrollPane(tp);
        cp.add(sp,BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}