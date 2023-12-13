package psu.edu.ist.View.ArtClothForm;

import javax.swing.*;
import java.util.ArrayList;

public class ArticleClothingForm {
    public ArticleClothingForm(){
        catCMBO.add("T-Shirt");
        catCMBO.add("Long Sleeve Tee");
        catCMBO.add("Pants");
    }
    ArrayList<String> catCMBO = new ArrayList<>();
    private JTextField nameJTextField;
    private JComboBox colorSelectJCombo;
    private JRadioButton LightweightRadButton;
    private JRadioButton medWeightRadButton;
    private JRadioButton HeavyWeightRadButton;
    private JRadioButton XtraHvyRadButton;
    private JComboBox categoryCombobox = new JComboBox<>(catCMBO.toArray());
    private JButton OKButton;
    private JButton CLEARButton;
    private JPanel artClothPanel;
    private JButton deleteButton;
    private JTextField colorTextField;
    private JTextField categoryTextField;
    private JTextField graphTextField;

    public JPanel getArtClothPanel() {
        return artClothPanel;
    }

    public JTextField getNameJTextField() {
        return nameJTextField;
    }

    public JComboBox getColorSelectJCombo() {
        return colorSelectJCombo;
    }

    public JRadioButton getLightweightRadButton() {
        return LightweightRadButton;
    }

    public JRadioButton getMedWeightRadButton() {
        return medWeightRadButton;
    }

    public JRadioButton getHeavyWeightRadButton() {
        return HeavyWeightRadButton;
    }

    public JRadioButton getXtraHvyRadButton() {
        return XtraHvyRadButton;
    }

    public JComboBox getCategoryCombobox() {
        return categoryCombobox;
    }

    public JButton getOKButton() {
        return OKButton;
    }

    public JButton getCLEARButton() {
        return CLEARButton;
    }

    public ArrayList<String> getCatCMBO() {
        return catCMBO;
    }

    public JTextField getGraphTextField() {
        return graphTextField;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextField getColorTextField() {
        return colorTextField;
    }

    public JTextField getCategoryTextField() {
        return categoryTextField;
    }
}
