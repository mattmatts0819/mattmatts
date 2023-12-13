package psu.edu.ist.View.ArtClothForm;

import psu.edu.ist.View.ArtClothForm.ArticleClothingForm;

import javax.swing.*;

public class ArticleClothingView extends JFrame {
    public ArticleClothingForm form;
    public ArticleClothingView(){
        this.form = new ArticleClothingForm();
        JPanel content = form.getArtClothPanel();

        this.setContentPane(content);
        this.pack();
        this.setTitle("Add a Garment");
        this.setLocationRelativeTo(null);
    }
}

