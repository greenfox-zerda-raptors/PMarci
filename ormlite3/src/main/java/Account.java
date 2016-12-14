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
    public static final String ADDRESS_FIELD_NAME = "address";
    @DatabaseField(foreign = true, columnName = ADDRESS_FIELD_NAME, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Address address;
    @DatabaseField(id = true, canBeNull = false, columnName = NAME_FIELD_NAME)
    private String name;

    @DatabaseField(canBeNull = false, columnName = PASSWORD_FIELD_NAME)
    private String password;

    public Account() {

    }

    public Account(String name, String password, Address address) {
        this.address = address;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("{%nname = %s,%naddress = %s %n}", this.name, this.address.toString());
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
