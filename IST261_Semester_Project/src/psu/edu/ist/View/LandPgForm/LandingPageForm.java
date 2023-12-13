package psu.edu.ist.View.LandPgForm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class LandingPageForm {
    private JPanel landingPagePanel;
    public JTable itemsTable;
    private JButton addGarmentButton;
    private JComboBox categoryFilterCMBX = new JComboBox<>();

    public JTextArea getTempTxtArea() {
        return tempTxtArea;
    }

    public JButton getEnterCityButton() {
        return enterCityButton;
    }

    private JButton exitButton;
    private JTextArea tempTxtArea;
    private JButton enterCityButton;

    public JPanel getPanel1() {
        return landingPagePanel;
    }

    public JTable getTable1() {
        return itemsTable;
    }

    public JButton getAddGarmentButton() {
        return addGarmentButton;
    }

    public JComboBox getCategoryFilterCMBX() {
        return categoryFilterCMBX;
    }

    public JPanel getLandingPagePanel() {
        return landingPagePanel;
    }

    public JTable getItemsTable() {
        return itemsTable;
    }

    public JButton getExitButton() {
        return exitButton;
    }
    public void loadCategoryDropDown(ArrayList<String> categories)
    {
        categories.add(""); //adds a blank line and the sort puts it in first position
        Collections.sort(categories);
        categoryFilterCMBX.setModel(new DefaultComboBoxModel<String>(categories.toArray(new String[0])));
        categoryFilterCMBX.setSelectedItem("Select a Category");
    }
    public LandingPageForm(){
        itemsTable.setAutoCreateRowSorter(true);

        ArrayList<String> categories = new ArrayList<>();

        categories.add("T-Shirt");
        categories.add("Long-Sleeve Tee");
        categories.add("Pants");
        categories.add("Outerwear");
        categories.add("Crewneck");
        categories.add("Hoodie");

        loadCategoryDropDown(categories);
    }
}
