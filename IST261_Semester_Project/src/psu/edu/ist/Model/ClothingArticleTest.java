package psu.edu.ist.Model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ClothingArticleTest {

    @Test
    void getCategory() {
        ClothingArticle cA1 = new ClothingArticle();
        cA1.setCategory("crewneck");
        assertEquals("crewneck", cA1.getCategory());
    }

    @Test
    void setCategory() {
        ClothingArticle cA1 = new ClothingArticle();
        cA1.setCategory("hoodie");
        assertEquals("hoodie", cA1.getCategory());
    }

    @Test
    void getColor() {
        ClothingArticle cA1 = new ClothingArticle();
        cA1.setColor("black");
        assertEquals("black", cA1.getColor());
    }

    @Test
    void setColor() {
        ClothingArticle cA1 = new ClothingArticle();
        cA1.setColor("pink");
        assertEquals("pink", cA1.getColor());
    }

    @Test
    void getFabricWeight() {
        ClothingArticle cA1 = new ClothingArticle();
        cA1.setFabricWeight("xtra heavy");
        assertEquals("xtra heavy", cA1.getFabricWeight());
    }

    @Test
    void setFabricWeight() {
        ClothingArticle cA1 = new ClothingArticle();
        cA1.setFabricWeight("lite");
        assertEquals("lite", cA1.getFabricWeight());
    }

    @Test
    void getArticleName() {
        ClothingArticle cA1 = new ClothingArticle();
        cA1.setArticleName("Red Sox Hat");
        assertEquals("Red Sox Hat", cA1.getArticleName());
    }

    @Test
    void setArticleName() {
        ClothingArticle cA1 = new ClothingArticle();
        cA1.setArticleName("Disney Sweatshirt");
        assertEquals("Disney Sweatshirt", cA1.getArticleName());
    }
}