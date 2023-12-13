package psu.edu.ist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import psu.edu.ist.Model.ClothingArticle;

public class DataEngine {
    public ArrayList<ClothingArticle> loadClosetData(String fileName){
        ArrayList<ClothingArticle> clst = new ArrayList<>();
        try {
            File data = new File(fileName);
            Scanner input = new Scanner(data);
            input.useDelimiter(",");

            //since the data file has headers in the first line we need to skip reading in the first line
            //if block prevents code from crashing if there is no data in file
            /*if (input.hasNextLine()){
                input.nextLine();
            }

             */

            while (input.hasNextLine())
            {
                ClothingArticle newCA = new ClothingArticle();
                String[] record = input.nextLine().split(",");
                //newCA.setPlayerID(q);
                //q++;
                for(int x = 0; x < record.length-1; x++)
                {
                    newCA.setItemID(Integer.parseInt(record[0]));
                    newCA.setArticleName(record[1]);
                    newCA.setCategory(record[2]);
                    newCA.setColor(record[3]);
                    newCA.setFabricWeight(record[4]);
                }
                clst.add(newCA);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return clst;
    }
}
