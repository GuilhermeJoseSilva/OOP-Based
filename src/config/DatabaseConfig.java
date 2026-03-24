package config;

public class DatabaseConfig {
    private final String host;
    private final String port;
    private final String database;
    private final String user;
    private final String password;

    public DatabaseConfig(EnvConfig env) {
        this.host = env.get("DB_HOST", "localhost");
        this.port = env.get("DB_PORT", "3306");
        this.database = env.get("DB_NAME", "");
        this.user = env.get("DB_USER", "root");
        this.password = env.get("DB_PASSWORD", "");
    }

    public String getJdbcUrl() {
        return "jdbc:mysql://" + host + ":" + port + "/" + database
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }

    public String getServerJdbcUrl() {
        return "jdbc:mysql://" + host + ":" + port
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }

    public String getDatabaseName() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public boolean hasDatabaseName() {
        return !database.isBlank();
    }
}
