import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by posam on 2016-12-14.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
@DatabaseTable(tableName = "accounts")
public class Account {

    public static final String PASSWORD_FIELD_NAME = "password";
    public static final String NAME_FIELD_NAME = "name";
    @DatabaseField(id = true, canBeNull = false, columnName = NAME_FIELD_NAME)
    private String name;

    @DatabaseField(canBeNull = false, columnName = PASSWORD_FIELD_NAME)
    private String password;

    public Account() {

    }

    @Override
    public String toString() {
        return name;
    }

    public Account(String username, String password) {
        setName(username);
        setPassword(password);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
}
