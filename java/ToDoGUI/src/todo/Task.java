package todo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;

import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "tasks")
class Task {

    private static final String COMPLETED_FIELD_NAME = "completed";
    private static final String DESCRIPTION_FIELD_NAME = "description";
    private static final String PARENT_FIELD_NAME = "parentlist";
    static DatabaseTableConfig<Task> taskTableConfig;

    @DatabaseField
    private boolean completed = false;
    @DatabaseField
    private String taskDesc;
    @DatabaseField
    private String parent;

    public Task() {
        this.taskDesc = "NOARGS CONST";
        List<DatabaseFieldConfig> fieldConfigs = new ArrayList<DatabaseFieldConfig>();
        DatabaseFieldConfig completedC = new DatabaseFieldConfig("completed");
        completedC.setColumnName(COMPLETED_FIELD_NAME);
        fieldConfigs.add(completedC);
        DatabaseFieldConfig taskDescC = new DatabaseFieldConfig("taskDesc");
        taskDescC.setColumnName(DESCRIPTION_FIELD_NAME);
        fieldConfigs.add(taskDescC);
        DatabaseFieldConfig parentC = new DatabaseFieldConfig("parent");
        parentC.setColumnName(PARENT_FIELD_NAME);
        fieldConfigs.add(parentC);
        taskTableConfig = new DatabaseTableConfig<Task>(Task.class, fieldConfigs);
        taskTableConfig.setTableName(this.parent);
    }

    Task(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    Task(String taskDesc, int boolint, String parent) {
        this.taskDesc = taskDesc;
        this.completed = (boolint == 1);
        this.parent = parent;
        ;
    }

    String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    boolean isCompleted() {
        return completed;
    }

    void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
