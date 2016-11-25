package todo;

import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by posam on 2016-11-25.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class ToDoGUI extends JFrame {
    private JFrame frame;
    private JPanel controlPanel, contentPane;
    private JButton buttonUser, buttonSwitch, buttonComplete;
    private JLabel listOwner, listTitle;
    private JMenuBar bar;
    private JMenu menu;
    private JMenuItem item;
    private JPanel outPanel;
    private JPanel listPanel;
    private JTextArea listArea;
    private JLabel outLabel;
    private Highlighter.HighlightPainter painter;
    private Timer timer;

    private ToDoGUI() {
        this.setDefaultCloseOperation(3);
        this.setContentPane(contentPane);
        listArea.setLineWrap(true);
        this.pack();
        this.setVisible(true);
        customOut("Shit's fine");
    }
    public void customOut(String message) {
        outLabel.setText(message);
        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetOutMessage("default message");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    private void resetOutMessage(String s) {
        outLabel.setText(s);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoGUI();
            }
        });

    }

}

