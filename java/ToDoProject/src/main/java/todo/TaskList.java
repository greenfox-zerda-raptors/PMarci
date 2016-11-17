package main.java.todo;
import java.util.ArrayList;

public class TaskList<Task> extends ArrayList<Task> {
    public final String title;
    public final String owner = "ME"; // implement this shit

    public TaskList(String title) {
        this.title = title;
    }
}
