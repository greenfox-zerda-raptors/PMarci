import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class Workshop02 {
    public static void main(String[] args) throws SQLException {
        String databaseUrl = "jdbc:mysql://localhost:3306/workshop02?user=root&password=admin1234";

        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        TableUtils.createTableIfNotExists(connectionSource, Account.class);

        Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);

        Account account = new Account("Captain America", "uejnsd632**234.");
        createAccountIfNotExists(accountDao, account);
        createAccountIfNotExists(accountDao, new Account("Ironman", "asdf"));
        createAccountIfNotExists(accountDao, new Account("Wolverine", "asdf"));
        createAccountIfNotExists(accountDao, new Account("Hulk", "adsf"));
        createAccountIfNotExists(accountDao, new Account("Loki", "asdf"));

        QueryBuilder<Account, String> queryBuilder = accountDao.queryBuilder();
        queryBuilder.orderBy(Account.NAME_FIELD_NAME, true);
        PreparedQuery<Account> preparedQuery = queryBuilder.prepare();
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
}