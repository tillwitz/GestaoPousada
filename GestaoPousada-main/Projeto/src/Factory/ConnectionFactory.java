package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    public ConnectionFactory() {
        this.url = "jdbc:postgresql://localhost:5432/GestaoPousada";
        this.username = "postgres";
        this.password = "1234";
    }

    public Connection conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}