package todo;
import java.util.ArrayList;

public class TaskList<Task> extends ArrayList<Task> {
    public final String title;
    public final String owner;

    public String getTitle() {
        return title;
    }

    public String getOwner() {
        return owner;
    }

    public TaskList(String title, String sessionUserName) {
        this.title = title;
        this.owner = sessionUserName;
    }
}
