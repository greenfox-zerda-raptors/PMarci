package todo;

import javax.swing.*;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Created by posam on 2016-11-25.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class ToDoGUI extends Meth {
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
    private JPanel mainPanel;
    private JButton buttonAdd;
    private JButton buttonRemove;
    private Highlighter.HighlightPainter painter;
    private Timer timer;
    private Font legjobb = new Font( "Comic Sans MS", Font.PLAIN, 24);

    private ToDoGUI() {
        String dirPath = System.getProperty("user.dir");
        File dir = new File(dirPath);
        File file = new File(dir + "\\" + "floor.png");
        bar = new JMenuBar();
        menu = new JMenu("File");
        item = new JMenuItem("Open...");
        this.setDefaultCloseOperation(3);
        this.setContentPane(contentPane);
        menu.setFont(legjobb);
        this.setJMenuBar(bar);
        bar.add(menu);
        menu.add(item);
        listArea.setLineWrap(false);
        listArea.setEditable(false);
        this.setVisible(true);
        currentList = createTasklist("DEFAULT1", "DEFAULT2"); //to be implemented
        readByLine(file, currentList);
        listTasks(currentList, listArea);
        customOut("WHAT'S GOING ON");
        this.pack();
        buttonSwitch.addMouseListener(new ControlListener());
        buttonUser.addMouseListener(new ControlListener());
        buttonAdd.addMouseListener(new ControlListener());
        buttonRemove.addMouseListener(new ControlListener());
        buttonComplete.addMouseListener(new ControlListener());
//                new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                customOut("hovering over switch");
//            }
//            @Override
//            public void mouseExited(MouseEvent e) {
//                resetOutMessage();
//            }
//        });
    }
    private class ControlListener extends MouseAdapter{

        @Override
        public void mouseEntered(MouseEvent e) {
            String tip;
            final Object source = e.getSource();
            if (source.equals(buttonSwitch)) {
                customOut("hovering over switch");

            } else if (source.equals(buttonUser)) {
                customOut("hovering over user");

            } else if (source.equals(buttonComplete)) {
                customOut("hovering over complete");

            } else if (source.equals(buttonAdd)) {
                customOut("hovering over add");

            } else if (source.equals(buttonRemove)) {
                customOut("hovering over remove");

            } else {
                customOut("huh?");
            }
        }
    }
    public void customOut(String message) {
        outLabel.setText(message);
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetOutMessage();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void resetOutMessage() {
        resetOutMessage("all is fine");
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

