package psu.edu.ist.Model;


import java.util.ArrayList;
import java.util.HashSet;

public class TestHarness {

    //TODO: create tests to show that all object classes are able to be
    // instantiated properly and that all getters and setters function properly

    public TestHarness() {
        Closet c1 = new Closet(new ArrayList<>());
        ArrayList<ClothingArticle> hs1 = new ArrayList<>();
        hs1.add(new ClothingArticle());
        hs1.add(new ClothingArticle());

        if(c1 != null){
            System.out.println("Closet Object created successfully");
            System.out.println(c1.toString());


            System.out.println(c1.toString());

            c1.setCloset(hs1);
            System.out.println(c1.toString());
        }
        else{
            System.out.println("there was an error creating a 'closet' object and/or modifying it");
        }
    }
}
