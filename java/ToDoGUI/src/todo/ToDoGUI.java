package todo;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Created by posam on 2016-11-25.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class ToDoGUI extends Meth {
    private int currentlyHighlighted = 0;
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
        customOut("WHAT'S GOING ON");
        highlight(currentlyHighlighted);
        this.pack();
        buttonSwitch.addMouseListener(new ControlListener());
        buttonUser.addMouseListener(new ControlListener());
        buttonAdd.addMouseListener(new ControlListener());
        buttonRemove.addMouseListener(new ControlListener());
        buttonComplete.addMouseListener(new ControlListener());
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

            } else if (source.equals(buttonAdd)) {

            } else if (source.equals(buttonRemove)) {

            }

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
            }
            listArea.getHighlighter().removeAllHighlights();
            highlight(currentlyHighlighted);
            System.out.println(currentlyHighlighted);
        }

        @Override
        public void keyReleased(KeyEvent e) {

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

    private void highlight(int index) {
        try {
            int startIndex = listArea.getLineStartOffset(index);
            int endIndex = listArea.getLineEndOffset(index);
//            String colour = (String) cbox.getSelectedItem();
            painter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
            listArea.getHighlighter().addHighlight(startIndex, endIndex, painter);

        } catch (BadLocationException e) {
            e.printStackTrace();
        }

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

