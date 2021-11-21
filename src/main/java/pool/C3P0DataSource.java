package pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0DataSource {
    private static ComboPooledDataSource cdps = new ComboPooledDataSource();


    static {
        try {
            cdps.setDriverClass("org.postgresql.Driver");
            cdps.setJdbcUrl("jdbc:postgresql://localhost:5432/project_epam");
            // пользователь бд
            cdps.setUser("EmCharlotte");
            // пароль пользователя
            cdps.setPassword("1990");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return cdps.getConnection();
    }
}
