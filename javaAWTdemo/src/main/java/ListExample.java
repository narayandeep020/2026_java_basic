package main.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class that is used as the main application
public class ListExample {

    private Frame frame;
    private List langList;
    private Button btn;
    private Label selectLang;

    // Constructor to initalize the GUI elements
    public ListExample(){

        // Creating a Frame
        frame = new Frame("Programming Languages List");

        // Creating a list which will contain the
        // programming languages.
        langList = new List(10);

        // Setting List Postition
        langList.setBounds(100, 100, 150, 150);

        // Adding programming languages to the list
        String[] languages
                = { "Java", "Python", "C++", "JavaScript",
                "Ruby", "C#",     "PHP", "Swift",
                "Go",   "Kotlin" };

        for (String language : languages) {
            langList.add(language);
        }

        // Setting Button Position
        btn = new Button("Display Selected");
        btn.setBounds(100, 270, 100, 30);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                displaySelectedLanguages();
            }
        });

        // Setting Label Position
        selectLang = new Label("Languages:");
        selectLang.setBounds(100, 310, 150, 20);

        // Adding Components to the frame
        frame.add(langList);
        frame.add(btn);
        frame.add(selectLang);

        // Setting Frame Size
        frame.setSize(400, 400);

        // Setting Layout to null
        frame.setLayout(null);

        // Making the frame visible
        frame.setVisible(true);
    }

    // This method will be used to display the selected
    // programming languages.
    public void displaySelectedLanguages(){

        String[] selectedItems = langList.getSelectedItems();
        String selectedLanguages = String.join(", ", selectedItems);
        selectLang.setText("Languages: "+ selectedLanguages);

    }

    // Main method to run the application
    public static void main(String[] args){
        new ListExample();
    }
}
