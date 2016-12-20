package todo;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by posam on 2016-11-25.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class ToDoGUI extends Meth {
    private JScrollPane scroll;
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
    private static ConnectionSource connectionSource;
    private static Dao<TaskList, String> listDao;
    private static Dao<Task, String> taskDao;
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
        listArea = new JTextArea(10, 20);
        listArea.setFont(legjobb);
        listArea.addKeyListener(new SelectionKeyListener());
        listArea.setFocusable(true);
        bar.add(menu);
        menu.add(item);
        listArea.setLineWrap(false);
        listArea.setEditable(false);
        listArea.setAutoscrolls(true);
        scroll = new JScrollPane(listArea);
        scroll.setAutoscrolls(true);
        listPanel.add(scroll, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.PAGE_END, 1, new Insets(0, 0, 0, 0), 0, 0));
        this.setVisible(true);
        currentList = createTasklist("DEFAULT1", "DEFAULT2"); //to be implemented
        try {
            setUpConnection("todo");
            initializeTestTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        readByLine(file, currentList);
        listTasks(currentList, listArea);
        customOut(outLabel, "WHAT'S GOING ON");
        highlight(currentList, listArea, currentlyHighlighted);
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
                try {
                    listLists(listArea, testPull(listArea));

                    return;
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            } else if (source.equals(buttonUser)) {

            } else if (source.equals(buttonComplete)) {
                completeTaskGUI(outLabel, currentList, currentlyHighlighted);
            } else if (source.equals(buttonAdd)) {
                addTaskGUI(outLabel, currentList, "DUMMY TASK", currentlyHighlighted);
            } else if (source.equals(buttonRemove)) {
                remTaskGUI(outLabel, currentList, currentlyHighlighted);
                if (currentlyHighlighted == currentList.size()) {
                    currentlyHighlighted--;
                }
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
                if (currentlyHighlighted == currentList.size()) {
                    currentlyHighlighted--;
                }
            } else if (keyCode == KeyEvent.VK_C) {
                System.out.println("bement");
                completeTaskGUI(outLabel, currentList, currentlyHighlighted);
            } else if (e.isControlDown() && e.getKeyChar() != 'n' && e.getKeyCode() == 78) {
                addTaskGUI(outLabel, currentList, "SHORTCUT DUMMY", currentlyHighlighted);
            }
            listTasks(currentList, listArea);
            listArea.getHighlighter().removeAllHighlights();
            highlight(currentList, listArea, currentlyHighlighted);
            System.out.println(currentlyHighlighted);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private void setUpConnection(String tablename) throws SQLException {
        String databaseUrl = "jdbc:mysql://localhost:3306/" + tablename + "?user=root&password=admin1234"; //TODO implement connection settings
        connectionSource = new JdbcConnectionSource(databaseUrl);
        System.out.println("setting up connection");

        System.out.println(connectionSource.isOpen(databaseUrl));
    }

    private void initializeTestTables() throws SQLException {
        TableUtils.dropTable(connectionSource, TaskList.class, true);
        String[] tableNames = new String[]{"test1.csv", "test2.csv"};
        ArrayList<TaskList> listofTL = new ArrayList<>();
        for (String s : tableNames) {
            File file = new File(dir + "\\" + s);
            TaskList temp = new TaskList(s, "DEFAULTUSER");
            readByLine(file, temp);
            listofTL.add(temp);
        }
        TableUtils.createTableIfNotExists(connectionSource, TaskList.class);
        listDao = DaoManager.createDao(connectionSource, TaskList.class);
        for (TaskList tl : listofTL) {
            createListTableIfNotExists(listDao, tl, tl.title);

        }
    }

    private static void createListTableIfNotExists(Dao<TaskList, String> listDao, TaskList tl, String name) throws SQLException {
        if (listDao.queryForId(tl.getTitle()) == null) {
            listDao.create(tl);
        }
    }

    private static void createTaskTableIfNotExists(Dao<Task, String> taskDao, Task task, String name) throws SQLException {
        if (taskDao.queryForId(task.getTaskDesc()) == null) {
            taskDao.create(task);
        }
    }

    private static List testPull(JTextArea listArea) throws SQLException {
        QueryBuilder<TaskList, String> tasklistQB = listDao.queryBuilder();
        tasklistQB.orderBy(TaskList.TITLE_FIELD_NAME, true);
        PreparedQuery<TaskList> preparedQuery = tasklistQB.prepare();
        List<TaskList> tlList = listDao.query(preparedQuery);
        return tlList;
    }

    public static void main(String[] args) throws SQLException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoGUI();
            }
        });
    }


}

