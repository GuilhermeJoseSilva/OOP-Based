import java.sql.Connection;
import java.sql.SQLException;

import config.DatabaseConfig;
import config.DatabaseConnection;
import config.EnvConfig;

public class App {
    public static void main(String[] args) {
        EnvConfig env = EnvConfig.load(".env");
        DatabaseConfig databaseConfig = new DatabaseConfig(env);
        DatabaseConnection databaseConnection = new DatabaseConnection(databaseConfig);

        try (Connection conn = databaseConnection.connect()) {
            System.out.println("Connected to MySQL successfully.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
