package psu.edu.ist.View.LandPgForm;

import javax.swing.*;

public class LandingView extends JFrame {
    public LandingPageForm form;
    public LandingView(){
        this.form = new LandingPageForm();
        JPanel content = form.getPanel1();

        this.setContentPane(content);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setTitle("Find - a - Fit");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
