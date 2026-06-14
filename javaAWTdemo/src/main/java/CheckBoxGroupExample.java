package main.java;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckBoxGroupExample {
    private Frame mainFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public CheckBoxGroupExample(){
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new Frame("CheckBoxGroup Example");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);

        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350,100);

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }
    private void showCheckBoxGroupDemo(){
        headerLabel.setText("Control in action : CheckBoxGroupDemo");

        CheckboxGroup group = new CheckboxGroup();

        Checkbox chkBox = new Checkbox("Java",group,true);
        Checkbox chkBox2 = new Checkbox("Python",group,false);
        Checkbox chkBox3 = new Checkbox("C#",group,false);

        chkBox.addItemListener(getCheckboxItemListener("Java"));
        chkBox2.addItemListener(getCheckboxItemListener("Python"));
        chkBox3.addItemListener(getCheckboxItemListener("C#"));

        controlPanel.add(chkBox);
        controlPanel.add(chkBox2);
        controlPanel.add(chkBox3);

        mainFrame.setVisible(true);
    }

    private ItemListener getCheckboxItemListener(final String s) {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    statusLabel.setText(s+" Checkbox: Checked");
                }else {
                    statusLabel.setText(s+" Checkbox: Unchecked");
                }
            }
        };
    }
    public static void main(String[] args){
        CheckBoxGroupExample check = new CheckBoxGroupExample();
        check.showCheckBoxGroupDemo();
    }
}
