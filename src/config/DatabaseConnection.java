package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final DatabaseConfig config;

    public DatabaseConnection(DatabaseConfig config) {
        this.config = config;
    }

    public Connection connect() throws SQLException {
        if (!config.hasDatabaseName()) {
            throw new IllegalStateException("Set DB_NAME in .env before connecting.");
        }

        return DriverManager.getConnection(
                config.getJdbcUrl(),
                config.getUser(),
                config.getPassword()
        );
    }
}
