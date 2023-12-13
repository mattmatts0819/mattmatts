package psu.edu.ist.Controller;

import psu.edu.ist.DataEngine;
import psu.edu.ist.Model.Closet;
import psu.edu.ist.Model.ClothingArticle;
import psu.edu.ist.View.ArtClothForm.ArticleClothingView;
import psu.edu.ist.View.EnterCityForm.EntrCityView;
import psu.edu.ist.View.LandPgForm.LandingView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LandingPageController extends JFrame {
    private Closet closet;
    private LandingView lpView;
    private String city;

    public LandingPageController(LandingView theView){
        this.lpView = theView;

        loadWeatherOnStart();

        DataEngine de = new DataEngine();
        this.closet = new Closet(de.loadClosetData("src/clst.txt"));

        lpView.form.getAddGarmentButton().addActionListener(e -> {
            ArticleClothingView acv1= new ArticleClothingView();
            acv1.setVisible(true);
            ArticleClothingController acCNTRL = new ArticleClothingController(acv1, closet, this);
        });

        lpView.form.getExitButton().addActionListener(e -> {
            persistData();
            System.exit(0);
        });

        LandingPageController lpc = this;
        lpView.form.getItemsTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editRecord(lpc);
            }
        });

        lpView.form.getEnterCityButton().addActionListener(e -> {
            EntrCityView ecv = new EntrCityView();
            ecv.setVisible(true);
            ecv.form.getOKButton().addActionListener(e1 -> {
                city = ecv.getCity();
                WeatherGrabber wg = new WeatherGrabber(city);
                lpView.form.getTempTxtArea().setText(String.valueOf(wg.getWeather()));
                persistData();
            });

        });

    }
    public void loadTable(ArrayList<ClothingArticle> c) {
        String headers[] = {"Item ID", "Article Name", "Category", "Color", "Fabric Weight"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);
        for(ClothingArticle ca : c)
        {
            model.addRow(new Object[] {ca.getItemID(), ca.getArticleName(), ca.getCategory(),
                    ca.getColor(), ca.getFabricWeight()});
        }
        lpView.form.itemsTable.setModel(model);
    }

    public void editRecord(LandingPageController lpc){
        int selectedRow = lpView.form.itemsTable.getSelectedRow();

        int itemID;
        String name;
        String color;
        String category;
        String fabWeight;

        itemID = (int) lpView.form.itemsTable.getValueAt(selectedRow, 0);
        name = (String) lpView.form.itemsTable.getValueAt(selectedRow, 1);
        color = (String) lpView.form.itemsTable.getValueAt(selectedRow, 3);
        category = (String) lpView.form.itemsTable.getValueAt(selectedRow, 2);
        fabWeight = (String) lpView.form.itemsTable.getValueAt(selectedRow, 4);

        ArticleClothingView acView = new ArticleClothingView();
        acView.setVisible(true);
        ArticleClothingController acCNTRL =
                new ArticleClothingController(acView, closet, lpc, itemID, name, category, color, fabWeight);
    }
    public void loadWeatherOnStart(){
        try {
            File data = new File("src/city.txt");
            Scanner input = new Scanner(data);
            city = input.nextLine();
        }
        catch (IOException e){
            System.out.println("file not found");
        }

        WeatherGrabber wg = new WeatherGrabber(city);
        lpView.form.getTempTxtArea().setText(String.valueOf(wg.getWeather()));
    }
    public void persistData(){
        String fileName = "src/clst.txt";
        String cityFile = "src/city.txt";
        try{
            PrintWriter out = new PrintWriter(fileName);
            int iD = 1;
            for (ClothingArticle c : closet.getCloset()) {
                out.print(iD + "," + c.getArticleName() + "," +
                        c.getCategory() + "," + c.getColor() + "," + c.getFabricWeight() + "\n");
                iD++;
            }
            out.close();
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        try{
            PrintWriter out = new PrintWriter(cityFile);
            out.print(city);
            out.close();
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }

    }
}
