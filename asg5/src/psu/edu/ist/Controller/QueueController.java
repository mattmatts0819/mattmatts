package psu.edu.ist.Controller;

import psu.edu.ist.Model.QueueModel;
import psu.edu.ist.View.QueueAppView;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueController {

    private QueueModel model;
    private QueueAppView qView;
    private Stack <Queue <Integer>> undoStack = new Stack <>();
    //stack used to store all
    // pre-existing iterations of the queue

    public QueueController(QueueModel model, QueueAppView qView) {
        this.model = model;
        this.qView = qView;

        qView.form.getEnqueueButton().addActionListener(e -> { //controls logic surrounding the enqueue button
            String enQText = qView.form.getEnQueueTextField().getText();
            if (!validateInt(enQText)){
                JOptionPane.showMessageDialog(qView, "Invalid Enqueue Entry");
                return;
            }
            int enQInt = Integer.parseInt(enQText);
            model.enqueue(enQInt);

            Queue<Integer> copy = new LinkedList<>(); //creates copy of source queue to add to undoStack
            copy.addAll(model.getWrappedQueue());
            undoStack.push(copy);

            //updates all text display fields with new front, rear, and queue values
            qView.form.getFrontTextArea().setText(Integer.toString((Integer) model.peekFront()));
            qView.form.getRearDisplayArea().setText(Integer.toString((Integer) model.peekRear()));
            qView.form.getQueueDisplayArea().setText(model.toString());

        });

        qView.form.getDequeueButton().addActionListener(e -> { //controls logic surrounding the dequeue button
            if (model.getWrappedQueue().isEmpty()){
                JOptionPane.showMessageDialog(qView, "Error: Queue is empty.");
                return;
            }

            model.dequeue();

            //updates all text display fields with new front, rear, and queue values
            qView.form.getFrontTextArea().setText(Integer.toString((Integer) model.peekFront()));
            qView.form.getRearDisplayArea().setText(Integer.toString((Integer) model.peekRear()));
            qView.form.getQueueDisplayArea().setText(model.toString());

            Queue<Integer> copy = new LinkedList<>(); //creates copy of source queue to add to undoStack
            copy.addAll(model.getWrappedQueue());
            undoStack.push(copy);
        });

        qView.form.getUndoButton().addActionListener(e -> {
            if (undoStack.empty()){ // validates that stack is not empty, displays error message if empty
                JOptionPane.showMessageDialog(qView, "Error: Nothing to undo.");
                return;
            }

            model.setSource((Queue) undoStack.pop());

            //updates all text display fields with new front, rear, and queue values
            qView.form.getFrontTextArea().setText(Integer.toString((Integer) model.peekFront()));
            qView.form.getRearDisplayArea().setText(Integer.toString((Integer) model.peekRear()));
            qView.form.getQueueDisplayArea().setText(model.toString());
        });
    }


    /**
     * method used to validate values entered into enqueue field
     * @param entry String value entered by user
     * @return boolean value representing whether the entry met all conditions
     */
    public boolean validateInt(String entry){
        try {
            if (entry.equals("")){
                throw new IllegalArgumentException();
            }
            Integer.parseInt(entry);
            return true;
        }catch (NumberFormatException e){
            return false;
        }catch (IllegalArgumentException e){
            return false;
        }
    }
}
