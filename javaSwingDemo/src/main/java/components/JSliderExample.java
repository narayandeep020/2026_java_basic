package main.java.components;

import javax.swing.*;

public class JSliderExample extends JFrame {

    public JSliderExample(){
        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,50,25);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JPanel panel = new JPanel();
        panel.add(slider);
        add(panel);
    }
    public static void main(String[] args){
        JSliderExample js = new JSliderExample();
        js.pack();
        js.setVisible(true);
    }
}
