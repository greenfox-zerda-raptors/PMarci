package todo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private Font legjobb = new Font("Comic Sans MS", Font.PLAIN, 24);

    private ToDoGUI() {
        String dirPath = System.getProperty("user.dir");
        File dir = new File(dirPath);
        File file = new File(dir + "\\" + "sample.csv");
        bar = new JMenuBar();
        menu = new JMenu("File");
        item = new JMenuItem("Open...");
        this.setDefaultCloseOperation(3);
        this.setContentPane(contentPane);
        menu.setFont(legjobb);
        this.setJMenuBar(bar);
        listArea.addKeyListener(new SelectionKeyListener());
        listArea.setFocusable(true);
        bar.add(menu);
        menu.add(item);
        listArea.setLineWrap(false);
        listArea.setEditable(false);
        this.setVisible(true);
        currentList = createTasklist("DEFAULT1", "DEFAULT2"); //to be implemented
        readByLine(file, currentList);
        listTasks(currentList, listArea);
        customOut(outLabel, "WHAT'S GOING ON");
        highlight(listArea, currentlyHighlighted);
        this.pack();
        buttonSwitch.addMouseListener(new ControlListener());
        buttonUser.addMouseListener(new ControlListener());
        buttonAdd.addMouseListener(new ControlListener());
        buttonRemove.addMouseListener(new ControlListener());
        buttonComplete.addMouseListener(new ControlListener());
        buttonSwitch.addActionListener(new ButtonActionListener());
        buttonUser.addActionListener(new ButtonActionListener());
        buttonAdd.addActionListener(new ButtonActionListener());
        buttonRemove.addActionListener(new ButtonActionListener());
        buttonComplete.addActionListener(new ButtonActionListener());
    }

    public int getCurrentlyHighlighted() {
        return currentlyHighlighted;
    }

    public void setCurrentlyHighlighted(int currentlyHighlighted) {
        this.currentlyHighlighted = currentlyHighlighted;
    }

    private class ControlListener extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            final Object source = e.getSource();
            timer.stop();
            if (source.equals(buttonSwitch)) {
                customOut(outLabel, "hovering over switch");

            } else if (source.equals(buttonUser)) {
                customOut(outLabel, "hovering over user");

            } else if (source.equals(buttonComplete)) {
                customOut(outLabel, "hovering over complete");

            } else if (source.equals(buttonAdd)) {
                customOut(outLabel, "hovering over add");

            } else if (source.equals(buttonRemove)) {
                customOut(outLabel, "hovering over remove");

            } else {
                customOut(outLabel, "huh?");
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            timer.restart();
        }
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            final Object source = e.getSource();
            if (source.equals(buttonSwitch)) {

            } else if (source.equals(buttonUser)) {

            } else if (source.equals(buttonComplete)) {
                completeTaskGUI(outLabel, currentList, currentlyHighlighted);
            } else if (source.equals(buttonAdd)) {
                addTaskGUI(outLabel, currentList, "DUMMY TASK", currentlyHighlighted);
            } else if (source.equals(buttonRemove)) {
                remTaskGUI(outLabel, currentList, currentlyHighlighted);
            }
            listTasks(currentList, listArea);
        }
    }

    private class SelectionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            final int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                if (currentlyHighlighted != 0)
                    setCurrentlyHighlighted(--currentlyHighlighted);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                if (currentlyHighlighted != currentList.size() - 1)
                    setCurrentlyHighlighted(++currentlyHighlighted);
            } else if (keyCode == KeyEvent.VK_R) {
                remTaskGUI(outLabel, currentList, currentlyHighlighted);
            } else if (keyCode == KeyEvent.VK_C) {
                System.out.println("bement");
                completeTaskGUI(outLabel, currentList, currentlyHighlighted);
            } else if (e.isControlDown() && e.getKeyChar() != 'n' && e.getKeyCode() == 78) {
                addTaskGUI(outLabel, currentList, "SHORTCUT DUMMY", currentlyHighlighted);
            }
            listTasks(currentList, listArea);
            listArea.getHighlighter().removeAllHighlights();
            highlight(listArea, currentlyHighlighted);
            System.out.println(currentlyHighlighted);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
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

