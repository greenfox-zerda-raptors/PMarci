import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class Workshop03 {
    public static void main(String[] args) throws SQLException {
        String databaseUrl = "jdbc:mysql://localhost:3306/workshop03?user=root&password=admin1234";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        TableUtils.dropTable(connectionSource, Address.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Account.class);
        TableUtils.createTableIfNotExists(connectionSource, Address.class);

        Dao<Account, String> accountDao =
                DaoManager.createDao(connectionSource, Account.class);
        Dao<Address, String> addressDao =
                DaoManager.createDao(connectionSource, Address.class);

        Account account = new Account("Captain America", "uejnsd632**234.");
        createAddressIfNotExists(addressDao, new Address("Andrassy ut", "Budapest", 1061, "Hungary", "Captain America"));
        createAccountIfNotExists(accountDao, account);
        createAccountIfNotExists(accountDao, new Account("Ironman", "asdf"));
        createAddressIfNotExists(addressDao, new Address("Andrassy ut", "Budapest", 1061, "Hungary", "Ironman"));
        createAccountIfNotExists(accountDao, new Account("Wolverine", "asdf"));
        createAddressIfNotExists(addressDao, new Address("Andrassy ut", "Budapest", 1061, "Hungary", "Wolverine"));
        createAccountIfNotExists(accountDao, new Account("Hulk", "adsf"));
        createAddressIfNotExists(addressDao, new Address("Andrassy ut", "Budapest", 1061, "Hungary", "Hulk"));
        createAccountIfNotExists(accountDao, new Account("Loki", "asdf", new Address("Andrassy ut", "Budapest", 1061, "Hungary", "Loki")));
        createAddressIfNotExists(addressDao, new Address("Andrassy ut", "Budapest", 1061, "Hungary", "Loki"));

        QueryBuilder<Account, String> accountQB = accountDao.queryBuilder();
//        QueryBuilder<Address, String> addressQB = addressDao.queryBuilder();
//        accountQB.join()
        accountQB.orderBy(Account.NAME_FIELD_NAME, true);
        PreparedQuery<Account> preparedQuery = accountQB.prepare();
        List<Account> accList = accountDao.query(preparedQuery);
        for (Account a : accList) {


            System.out.println(a.toString());
        }
    }

    private static void createAccountIfNotExists(Dao<Account, String> accountDao, Account acc) throws SQLException {
        if (accountDao.queryForId(acc.getName()) == null) {
            accountDao.create(acc);
        }
    }

    private static void createAddressIfNotExists(Dao<Address, String> adressDao, Address add) throws SQLException {
        if (adressDao.queryForId(add.getName()) == null) {
            adressDao.create(add);
        }
    }
}