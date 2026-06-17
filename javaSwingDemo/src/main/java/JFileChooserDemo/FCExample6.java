package main.java.JFileChooserDemo;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Example on JFileChooser( File, FileSystemView )

public class FCExample6 extends JFrame implements ActionListener {

    static JLabel l;

    FCExample6() {
    }

    public static void main(String[] args) {
        JFrame f = new JFrame(" JavaTpoint");
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b1 = new JButton("save dialog");
        JButton b2 = new JButton("open dialog");

        FCExample6 ex = new FCExample6();
        b1.addActionListener(ex);
        b2.addActionListener(ex);

        JPanel p = new JPanel();
        p.add(b1);
        p.add(b2);
l = new JLabel("no file selected");
p.add(l);
f.add(p);
f.show();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();
        if (com.equals("save")){
            JFileChooser jf = new JFileChooser(FileSystemView.getFileSystemView());
            int r = jf.showSaveDialog(null);
            if (r==JFileChooser.APPROVE_OPTION){
                l.setText(jf.getSelectedFile().getAbsolutePath());
            }else
                l.setText("The user cancelled the operation");
        }else{
            JFileChooser jf = new JFileChooser(FileSystemView.getFileSystemView());
            int r = jf.showOpenDialog(null);
            if (r==JFileChooser.APPROVE_OPTION){
                l.setText(jf.getSelectedFile().getAbsolutePath());
            }else
                l.setText("The user cancelled the operation");
        }
    }
}

