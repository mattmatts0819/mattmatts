package psu.edu.ist.View;

import javax.swing.*;

public class QueueForm {
    private JPanel mainQueueJPanel;
    private JButton enqueueButton;
    private JTextField enQueueTextField;
    private JButton dequeueButton;
    private JButton undoButton;
    private JTextArea queueDisplayArea;
    private JLabel frontDisplay;
    private JLabel queueDisplayLabel;
    private JLabel rearDisplayLabel;
    private JTextField frontTextArea;
    private JTextArea rearDisplayArea;

    public JPanel getMainQueueJPanel() {
        return mainQueueJPanel;
    }

    public JButton getEnqueueButton() {
        return enqueueButton;
    }

    public JTextField getEnQueueTextField() {
        return enQueueTextField;
    }

    public JButton getDequeueButton() {
        return dequeueButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JTextArea getQueueDisplayArea() {
        return queueDisplayArea;
    }

    public JLabel getFrontDisplay() {
        return frontDisplay;
    }

    public JLabel getQueueDisplayLabel() {
        return queueDisplayLabel;
    }

    public JLabel getRearDisplayLabel() {
        return rearDisplayLabel;
    }

    public JTextField getFrontTextArea() {
        return frontTextArea;
    }

    public JTextArea getRearDisplayArea() {
        return rearDisplayArea;
    }
}
