package main.java.todo;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App extends Meth {
    public static void main(String[] args) {
        System.out.println("************************************************\n************************************************\n*************WELCOME TO MY TODO APP*************\n************************************************\n************************************************");
        load(1000);
        String dirPath = System.getProperty("user.dir");
        File dir = new File(dirPath);
        sessionUserName = setUserName(sessionUserName);
        listFiles(dir);
        readByLine(file, currentList);
        printHelp();
        Scanner scanner2 = new Scanner(System.in);
        while (true) {
        System.out.print("Enter command or quit: ");
        String input = scanner2.nextLine();
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
            case "switch":
            case "s": listFiles(dir);
                readByLine(file, currentList);
                break;
            case "user":
            case "u": sessionUserName = setUserName(sessionUserName);
                break;
            case "complete":
            case "c": completeTask(currentList, taskSub);
                break;
            case "help":
            case "h": printHelp();
                    break;
            case "quit":
            case "q": System.out.println("See u negsd dime! :^D");
                    System.exit(0);
            default: System.out.println("Unsupported argument");
            }
            storeList(currentList, tempStore);
            listToFile(tempStore, file);
        }

    }
}
