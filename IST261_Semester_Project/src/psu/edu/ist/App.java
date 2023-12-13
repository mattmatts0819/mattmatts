package psu.edu.ist;

import psu.edu.ist.Controller.LandingPageController;
import psu.edu.ist.Model.Closet;
import psu.edu.ist.Model.ClothingArticle;
import psu.edu.ist.View.LandPgForm.LandingView;

import javax.swing.*;
import java.util.ArrayList;

public class App extends JFrame {
    public static void main(String[] args) {
        Closet closet = new Closet(new ArrayList<>());

        //load data from txt file
        DataEngine dE = new DataEngine();
        ArrayList<ClothingArticle> cl = new ArrayList<>();
        cl.addAll(dE.loadClosetData(
                "src/clst.txt"));
        closet.setCloset(cl);

        LandingView theView = new LandingView();

        LandingPageController lpc = new LandingPageController(theView);
        lpc.loadTable(cl);
        theView.setVisible(true);
    }
}
