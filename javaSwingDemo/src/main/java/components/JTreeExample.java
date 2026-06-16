package main.java.components;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeExample {
    JFrame f;
    JTreeExample(){
        f = new JFrame();

        DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color = new DefaultMutableTreeNode("Color");
        DefaultMutableTreeNode font = new DefaultMutableTreeNode("Font");
        style.add(color);
        style.add(font);

        DefaultMutableTreeNode red = new DefaultMutableTreeNode("Red");
        DefaultMutableTreeNode blue = new DefaultMutableTreeNode("Blue");
        DefaultMutableTreeNode green = new DefaultMutableTreeNode("Green");
        DefaultMutableTreeNode black = new DefaultMutableTreeNode("Black");
        color.add(red); color.add(blue); color.add(green); color.add(black);

        JTree jt = new JTree(style);
        f.add(jt);
        f.setSize(200,200);
        f.setVisible(true);
    }
    public static void main(String[] args){
        new JTreeExample();
    }
}
