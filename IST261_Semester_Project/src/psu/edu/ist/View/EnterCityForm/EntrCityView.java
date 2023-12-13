package psu.edu.ist.View.EnterCityForm;

import psu.edu.ist.View.ArtClothForm.ArticleClothingForm;

import javax.swing.*;

public class EntrCityView extends JFrame {

    public EntrCityForm form;
    public EntrCityView(){
        this.form = new EntrCityForm();
        JPanel content = form.getPanel1();

        this.setContentPane(content);
        this.pack();
        this.setTitle("");
        this.setLocationRelativeTo(null);

        form.getOKButton().addActionListener(e -> {
            getCity();
        });
    }
    public String getCity(){
        String city = form.getCityField().getText();
        return city;
    }
}
