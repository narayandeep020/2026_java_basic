package main.java.components;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JTableExample2 {

    public static void main(String[] a) {
        JFrame f = new JFrame("Table Example");
        String data[][]={ {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}};
        String column[]={"ID","NAME","SALARY"};

        final JTable jt=new JTable(data,column);
        jt.setCellSelectionEnabled(true);

        ListSelectionModel select = jt.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String data = null;
                int row[] = jt.getSelectedRows();
                int column[] = jt.getSelectedColumns();

                for (int i = 0; i< row.length; i++){
                    for (int j = 0; j<column.length; j++){
                        data =(String) jt.getValueAt(row[i], column[j]);

                    }
                }
                System.out.println("Table element selected is: " + data);
            }
        });

        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
