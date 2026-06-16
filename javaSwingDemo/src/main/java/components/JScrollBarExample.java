package main.java.components;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class JScrollBarExample {

    JScrollBarExample() {
        JFrame f = new JFrame("ScrollBar Example");
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);

        final JScrollBar s = new JScrollBar();
        s.setBounds(100, 100, 50, 100);
        f.add(s);
        f.add(label);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        s.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                label.setText("Vertical ScrollBar value is: " + s.getValue());
            }
        });
    }

    public static void main(String args[]) {
        new JScrollBarExample();
    }
}
