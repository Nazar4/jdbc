package bdsql.users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User map(ResultSet result) {
        try {
            int id = result.getInt("id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }
}
