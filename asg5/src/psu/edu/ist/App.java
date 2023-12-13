package psu.edu.ist;

import psu.edu.ist.Controller.QueueController;
import psu.edu.ist.Model.QueueModel;
import psu.edu.ist.View.QueueAppView;

public class App {
    public static void main(String[] args) {
        QueueModel theModel = new QueueModel<Integer>();
        QueueAppView theView = new QueueAppView();

        QueueController c = new QueueController(theModel, theView);
        theView.setVisible(true);
    }
}
