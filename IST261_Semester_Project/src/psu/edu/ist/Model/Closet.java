package psu.edu.ist.Model;

import java.util.ArrayList;

public class Closet {
    private ArrayList<ClothingArticle> closet;

    public Closet(ArrayList<ClothingArticle> closet) {
        this.closet = closet;
    }

    public ArrayList<ClothingArticle> getCloset() {
        return closet;
    }

    public void setCloset(ArrayList<ClothingArticle> closet) {
        this.closet = closet;
    }

    public void addClothing(ClothingArticle c) {
        closet.add(c);
    }

    @Override
    public String toString() {
        return "Items: " + closet.toString();
    }
}
