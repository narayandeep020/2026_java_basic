package main.java.components;

import javax.swing.*;

public class JTableExample {

    JFrame f;
    JTableExample(){
        f=new JFrame();
        String data[][] = {{"101","Deep","50000"},{"102","Maha","70000"},{"103","Sulu","20000"}};
        String colunm[] = {"ID","Name","Salary"};

        JTable jt = new JTable(data,colunm);
        jt.setBounds(30,40,200,300);

        JScrollPane sp = new JScrollPane(jt);

        f.add(sp);
        f.setSize(300,400);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new JTableExample();
    }
}
