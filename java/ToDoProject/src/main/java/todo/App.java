package main.java.todo;

import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App extends Meth {
    public static void main(String[] args) {
        System.out.println("************************************************\n************************************************\n*************WELCOME TO MY TODO APP*************\n************************************************\n************************************************");
        load(1000);
//        URL location = App.class.getProtectionDomain().getCodeSource().getLocation();
//        System.out.println(location.getFile());
//        printByLine(new File(loc2 + "\\" + "usage.txt"));
        TaskList<Task> currentList = createTasklist("asdfasdf"); //check for existing lists, if none there, ask to create
        printHelp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
        System.out.print("Enter command or quit: ");
        String input = scanner.nextLine();
            String[] split = input.split("\\s", 2);
            String command = split[0];
            String taskSub;
            if (split.length > 1) {
                taskSub = split[1];
            } else {
                taskSub = null;
            }
            switch (command) {
            case "list":
            case "l": listTasks(currentList);
                break;
            case "add":
            case "a": addTask(currentList, taskSub);
                break;
            case "remove":
            case "r": remTask(currentList, taskSub);
                break;
//            case "complete":
//            case "c": completeTask(currentList);
//                break;
            case "help":
            case "h": printHelp();
                    break;
            case "quit":
            case "q": System.out.println("See u negsd dime! :^D");
                    System.exit(0);
            default: System.out.println("Unsupported argument");
            }

        }

    }
}
