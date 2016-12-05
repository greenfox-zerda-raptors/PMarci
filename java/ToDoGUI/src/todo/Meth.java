package todo;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class Meth extends JFrame{
    public static final String dirPath = System.getProperty("user.dir");
    public static final File dir = new File(dirPath);
    public static File file = null;
    public static String customListName = "default";
    public static String sessionUserName = "default";
    public static ArrayList<String> tempStore = new ArrayList<String>();
    public static TaskList<Task> currentList;


    public static void readByLine(File inputfile, TaskList<Task> current) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputfile));
            String tempLine = reader.readLine();
            String[] splitLine;

            while (tempLine != null) {
                splitLine = tempLine.split(";", 0);
                current.add(new Task(splitLine[1], Integer.parseInt(splitLine[0])));
                tempLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(e + ": selected list is empty!");
        }
    }
    public static void printByLine(File inputfile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputfile));
            String tempLine = reader.readLine();

            while (tempLine != null) {
                System.out.println(tempLine);
                tempLine = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void printHelp() {
        String loc2 = System.getProperty("user.dir");
        printByLine(new File(loc2 + "\\" + "usage.txt"));

    }

    public static void load(int time) {
        try {
            System.out.print("Loading: |=");
            for (int i = 0; i < 18; i++) {
                Thread.sleep(time / 18);
                System.out.print("==");
            }
            System.out.print("=|\n");
            Thread.sleep(time / 4);
        } catch (InterruptedException e) {
            System.out.println("What the heck is going on?");
        }

    }

    public static TaskList<Task> createTasklist(String title, String owner) {
        TaskList<Task> newList = new TaskList<>(title, owner);
        return newList;
    }

    public static TaskList<Task> addTask(TaskList current, String taskSub) {
        current.add(new Task(taskSub));
        return current;
    }

    public static TaskList<Task> remTask(TaskList current, String index) {
        if (index != null) {
            try {
                int temp = Integer.parseInt(index);
                current.remove(temp - 1);
            } catch (NumberFormatException e) {
                System.out.println("Index is not a number");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Unable to remove, index out of bounds");
            }
        } else {
            System.out.println("Unable to remove: No index is provided");
        }
        return current;
    }

    public static TaskList<Task> completeTask(TaskList<Task> current, String index) {
        try {
            int temp = Integer.parseInt(index);
            Task tempTask = current.get(temp - 1);
            if (!tempTask.isCompleted()) {
                tempTask.setCompleted(true);
            } else {
                tempTask.setCompleted(false);
            }
        } catch (NumberFormatException e) {
            System.out.println("Index is not a number");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to toggle completed, index out of bounds");
        }
        return current;
    }

    public static void listTasks(TaskList<Task> current) {
        final String listTaskFormat = "%d - [%c] %s\n";
        char[] compArr = new char[]{' ', 'x'};
        char comp;
        System.out.printf("**********************************************\nList title: %s      Owner: %s\n**********************************************\n", current.title, current.owner);
        if (current.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            for (Task t : current) {
                comp = (t.isCompleted()) ? compArr[1] : compArr[0];
                System.out.printf(listTaskFormat, current.indexOf(t) + 1, comp, t.getTaskDesc());
            }
        }
    }

    public static ArrayList<String> storeList(TaskList<Task> current, ArrayList<String> tempStore) {
        char[] compArr = new char[]{'0', '1'};
        char comp;
        tempStore.clear();
        final String tempFormat = "%c;%s";
        for (Task t : current) {
            comp = (t.isCompleted()) ? compArr[1] : compArr[0];
            tempStore.add(String.format(tempFormat, comp, t.getTaskDesc()));
        }
        return tempStore;
    }

    public static File listToFile(ArrayList<String> temp, File test) {
        try {
//            File outputFile = new File(fileName);
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(test, false)));
            for (String t : temp) {
                writer.println(t);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An IO Exception occured while writing to file");
        }
        return test;
    }
    public static void listFiles(File dir) {
        System.out.println("\nFollowing files are available:\n");
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".csv");
            }
        });
        for (File s : files) {
            System.out.println(s.getName());
        }
        System.out.println("");
        do {
        if (file!=null && (!file.isFile() || !file.canRead() || !file.canWrite())){
                System.out.println("File not found or damaged, try again!\n(Type the filename without the directory or extension!)");
            }
            customListName = customListNameEntry(customListName);
            file = new File(dir + "\\" + customListName + ".csv");
        } while (!(file.isFile() && file.canRead() && file.canWrite()));
        currentList = createTasklist(customListName, sessionUserName);
    }
    public static String customListNameEntry(String customListName) {
        Scanner scanner1 = new Scanner(System.in);
        while (true) {
            System.out.print("Type the filename to open it,\nor create a new list with \"new [custom title]\": ");
            String fileInput = scanner1.nextLine();
            String[] fileSplit = fileInput.split("\\s", 2);
            String filename = fileSplit[0];
            if (fileSplit.length > 1 && (filename.equals("n") || filename.equals("new")) && !fileSplit[1].isEmpty()) {
                customListName = fileSplit[1];
                file = new File(dir + "\\" + customListName + ".csv");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println(e + "Couldn't create File");}
                break;
            } else if (filename.equals("n") || filename.equals("new")){
                System.out.println("You didn't enter a filename!");
            }
            else if (!fileSplit[0].isEmpty()){
                customListName = fileSplit[0];
                break;
            }
        }
        return customListName;
    }
    public static String setUserName(String sessionUserName) {
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Type the username for this session: ");
        sessionUserName = scanner3.nextLine();
    return sessionUserName;
    }
    public static void remList(TaskList<Task> currentList) { //UNDER CONSTRUCTION
        file.delete();
        System.out.printf("List %s was removed! (or was it? %b)\n", currentList.title, file.delete());
    }
    public void listTasks (TaskList<Task> current, JTextArea area) {
        final String listTaskFormat = "%d - [%c] %s\n";
        char[] compArr = new char[]{' ', 'x'};
        char comp;
        if (current.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
                String toArea = "";
            for (Task t : current) {
                comp = (t.isCompleted()) ? compArr[1] : compArr[0];
                toArea += String.format(listTaskFormat + "\n", current.indexOf(t) + 1, comp, t.getTaskDesc());
            }
            area.setText(toArea);
        }

    }
}



