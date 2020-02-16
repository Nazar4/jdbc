package jdbc;

import java.sql.*;

public class Main {
    static final String URL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&serverTimezone=UTC";

    private static final String USER_NAME = "user1";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()){
                System.out.println(resultSet.getString("last_name"));
                System.out.println(resultSet.getString("first_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }

        }
    }
}
