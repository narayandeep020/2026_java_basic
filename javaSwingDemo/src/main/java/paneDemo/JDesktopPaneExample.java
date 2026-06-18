package main.java.paneDemo;

import javax.swing.*;
import java.awt.*;

public class JDesktopPaneExample extends JFrame {

    public JDesktopPaneExample(){
        CustomDesktopPane custom = new CustomDesktopPane();
        Container con = getContentPane();
        con.add(custom,BorderLayout.CENTER);
        custom.display(custom);

        setTitle("JDesktopPane Example");
        setSize(300,350);
        setVisible(true);
    }
    public static void main(String[] args){
        new JDesktopPaneExample();
    }
}
class CustomDesktopPane extends JDesktopPane{
    int numFrame = 3, x=30, y=30;

    public void display(CustomDesktopPane dp){
        for (int i = 0; i<numFrame; i++){
            JInternalFrame jFrame = new JInternalFrame("Internal Frame"+i,true,true,true,true);

            jFrame.setBounds(x,y,250,85);
            Container c1 = jFrame.getContentPane();
            c1.add(new Label("I Love Java Programming"));
            dp.add(jFrame);
            jFrame.setVisible(true);
            y += 85;
        }
    }
}
