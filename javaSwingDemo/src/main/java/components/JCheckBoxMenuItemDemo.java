package main.java.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class JCheckBoxMenuItemDemo {
    public static void main(String[] args){
        JFrame frame = new JFrame("Jmenu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar mb = new JMenuBar();

        JMenu m = new JMenu("File");
        m.setMnemonic(KeyEvent.VK_F);
        mb.add(m);

        JMenuItem mi = new JMenuItem("Open",KeyEvent.VK_N);
        m.add(mi);

        JCheckBoxMenuItem cbi = new JCheckBoxMenuItem("Option_1");
        cbi.setMnemonic(KeyEvent.VK_C);
        m.add(cbi);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                AbstractButton ab = (AbstractButton) event.getSource();
                boolean selected = ab.getModel().isSelected();
                String newLabel;
                Icon newIcon;
                if (selected){
                    newLabel = "Value_1";
                }else {
                    newLabel = "Value_2";
                }
                ab.setText(newLabel);
            }
        };
        cbi.addActionListener(al);
        frame.setJMenuBar(mb);
        frame.setSize(350, 250);
        frame.setVisible(true);

    }
}
