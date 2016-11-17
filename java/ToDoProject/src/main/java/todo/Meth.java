package main.java.todo;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;


public abstract class Meth {
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
                Thread.sleep(time/18);
                System.out.print("==");
            }
            System.out.print("=|\n");
            Thread.sleep(time/4);
        } catch (InterruptedException e) {
            System.out.println("What the heck is going on?");
        }

    }
    public static TaskList<Task> createTasklist(String title) {
        TaskList<Task> newList = new TaskList<>(title);
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
                current.remove(temp);
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
    public static void listTasks(TaskList<Task> current) {
        System.out.printf("**********************************************\nList title: %s      Owner: %s\n**********************************************\n", current.title, current.owner);
        if (current.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            for (Task t : current) {
                System.out.println(t.getTaskDesc());
            }
        }
    }
}


