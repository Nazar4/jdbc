package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionManager {

    public ConnectionManager() {
    }

    private static final String URL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&serverTimezone=UTC";
    private static final String USER_NAME = "user1";
    private static final String PASSWORD = "12345";

    public static Connection createConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("error when creating connection", e);
        }
        return connection;
    }
}
