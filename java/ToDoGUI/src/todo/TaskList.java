package todo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;

import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "lists")
public class TaskList extends ArrayList<Task> {
    public static final String TITLE_FIELD_NAME = "title";
    public static final String OWNER_FIELD_NAME = "owner";
    private static final String ID_FIELD_NAME = "id";
    private DatabaseTableConfig<Task> listTableConfig;

    @DatabaseField
    private int id;

    @DatabaseField
    public String title;

    @DatabaseField
    public String owner = "DEFAULT";

    public TaskList() {
        List<DatabaseFieldConfig> fieldConfigs = new ArrayList<DatabaseFieldConfig>();
        DatabaseFieldConfig titleC = new DatabaseFieldConfig("title");
        titleC.setColumnName(TITLE_FIELD_NAME);
        fieldConfigs.add(titleC);
        DatabaseFieldConfig ownerC = new DatabaseFieldConfig("owner");
        ownerC.setColumnName(OWNER_FIELD_NAME);
        fieldConfigs.add(ownerC);
        DatabaseFieldConfig idC = new DatabaseFieldConfig("id");
        idC.setColumnName(ID_FIELD_NAME);
        idC.setGeneratedId(true);
        fieldConfigs.add(idC);
        listTableConfig = new DatabaseTableConfig<Task>(Task.class, fieldConfigs);
        listTableConfig.setTableName(getTitle());

    }

    public String getTitle() {
        return title;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("Title: %s  owner: %s", title, owner);
    }

    public TaskList(String title, String sessionUserName) {
        this.title = title;
        this.owner = sessionUserName;
    }
}
