package psu.edu.ist.Controller;

import psu.edu.ist.Model.Closet;
import psu.edu.ist.Model.ClothingArticle;
import psu.edu.ist.View.ArtClothForm.ArticleClothingView;
import psu.edu.ist.View.LandPgForm.LandingView;

import javax.swing.*;

public class ArticleClothingController extends JFrame {

    private ArticleClothingView acView;
    private Closet closet;
    private int _itemID;
    private LandingPageController lpc;
    public ArticleClothingController(ArticleClothingView acView, Closet closet, LandingPageController lpc){
        this.acView = acView;
        this.closet = closet;
        this.lpc = lpc;

        acView.form.getOKButton().addActionListener(e -> {
            addRecord();
            lpc.persistData();
        });

        acView.form.getDeleteButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(acView, "No record selected to delete.");
        });
    }
    public ArticleClothingController(ArticleClothingView acView, Closet closet,
                                     LandingPageController lpc, int itemID,
                                     String name, String category, String color, String fabWeight){
        this.acView = acView;
        this.closet = closet;
        this.lpc = lpc;

        this._itemID = itemID;

        acView.form.getNameJTextField().setText(name);
        acView.form.getCategoryTextField().setText(category);
        acView.form.getColorTextField().setText(color);



        if (fabWeight.equalsIgnoreCase("medium")){
            acView.form.getMedWeightRadButton().setSelected(true);
        } else if (fabWeight.equalsIgnoreCase("heavy")){
            acView.form.getHeavyWeightRadButton().setSelected(true);
        } else if (fabWeight.equalsIgnoreCase("lite")) {
            acView.form.getLightweightRadButton().setSelected(true);
        }else {
            acView.form.getXtraHvyRadButton().setSelected(true);
        }

        acView.form.getOKButton().addActionListener(e -> {
            editRecord();
            lpc.persistData();
        });

        acView.form.getDeleteButton().addActionListener(e -> {
            delete();
            lpc.persistData();
        });
    }
    public void addRecord(){
        String artName = acView.form.getNameJTextField().getText();
        String cat = acView.form.getCategoryTextField().getText();
        String color = acView.form.getColorTextField().getText();
        String fabW = "";

        if (acView.form.getLightweightRadButton().isSelected()){
            fabW = "Lite";
        } else if (acView.form.getMedWeightRadButton().isSelected()) {
            fabW = "Medium";
        } else if (acView.form.getHeavyWeightRadButton().isSelected()) {
            fabW = "Heavy";
        } else if (acView.form.getXtraHvyRadButton().isSelected()) {
            fabW = "Xtra Heavy";
        }
        else {
            JOptionPane.showMessageDialog(acView, "Please select a fabric weight.");
        }


        if(validate(artName,color, cat, fabW)){
            ClothingArticle c = new ClothingArticle(closet.getCloset().size()+1, cat, color, fabW, artName);
            closet.addClothing(c);

            acView.form.getNameJTextField().setText("");
            acView.form.getCategoryTextField().setText("");
            acView.form.getColorTextField().setText("");

            lpc.loadTable(closet.getCloset());
        }
        else{
            JOptionPane.showMessageDialog(acView, "Unable to create article. Check all fields are filled");
        }
    }
    public void editRecord(){
        for (ClothingArticle c : closet.getCloset()) {
            if (c.getItemID() == _itemID){
                c.setArticleName(acView.form.getNameJTextField().getText());
                c.setCategory(acView.form.getCategoryTextField().getText());
                c.setColor(acView.form.getColorTextField().getText());

                if (acView.form.getLightweightRadButton().isSelected()){
                    c.setFabricWeight("Lite");
                } else if (acView.form.getMedWeightRadButton().isSelected()) {
                    c.setFabricWeight("Medium");
                } else if (acView.form.getHeavyWeightRadButton().isSelected()) {
                    c.setFabricWeight("Heavy");
                } else if (acView.form.getXtraHvyRadButton().isSelected()) {
                    c.setFabricWeight("Xtra Heavy");
                }
                //LandingPageController lpc = new LandingPageController();
                lpc.loadTable(closet.getCloset());
                break;
            }
        }
    }
    public void delete(){
        for (ClothingArticle ca: closet.getCloset()){
            if(ca.getItemID() == _itemID){
                closet.getCloset().remove(ca);
                lpc.loadTable(closet.getCloset());
                break;
            }
        }
    }
    public boolean validate(String artName, String color, String category, String fabWeight){
        if (artName.equalsIgnoreCase("")){
            return false;
        }
        else if (color.equalsIgnoreCase("")){
            return false;
        } else if (!category.equalsIgnoreCase("T-Shirt") || category.equalsIgnoreCase("Hoodie")
                || category.equalsIgnoreCase("Crewneck") || category.equalsIgnoreCase("Pants") ||
                category.equalsIgnoreCase("Long-Sleeve Shirt") || category.equalsIgnoreCase("Outerwear")) {
            return false;
        }
        return true;
    }
}
