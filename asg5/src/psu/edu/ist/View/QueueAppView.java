package psu.edu.ist.View;

import javax.swing.*;

public class QueueAppView extends JFrame {
    public QueueForm form;

    public QueueAppView(){
        this.form = new QueueForm();
        JPanel content =  form.getMainQueueJPanel();

        this.setContentPane(content);
        this.pack();
        this.setTitle("Queueing up!");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
