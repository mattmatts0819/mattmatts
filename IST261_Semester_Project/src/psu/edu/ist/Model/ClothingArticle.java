package psu.edu.ist.Model;

import java.awt.*;

public class ClothingArticle {
    private String category;
    private String color;
    private String fabricWeight;
    private String articleName;
    private int itemID;

    //default constructor
    public ClothingArticle(){
        category = "";
        color = "";
        fabricWeight = "";
        articleName = "";
        itemID = 0;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricWeight() {
        return fabricWeight;
    }

    public void setFabricWeight(String fabricWeight) {
        this.fabricWeight = fabricWeight;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public ClothingArticle(int itemID, String category, String color, String fabricWeight, String articleName) {
        this.category = category;
        this.itemID = itemID;
        this.color = color;
        this.fabricWeight = fabricWeight;
        this.articleName = articleName;

    }

    @Override
    public String toString() {
        return "Category: " + category + ", Color: " + color +
                ", Fabric Weight: " + fabricWeight + ", Name: " + articleName;
    }
}
