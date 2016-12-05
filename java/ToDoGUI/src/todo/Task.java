package todo;

public class Task {
        public String taskDesc;
        public boolean completed = false;
    public Task(String taskSub) {
        this.taskDesc = taskSub;
    }

    public Task(String taskDesc, int boolint) {
        this.taskDesc = taskDesc;
        this.completed = (boolint == 1);
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
