package repository;

import bdsql.users.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    void save_By_Id(User user);

    void update_By_Id(User user);

    void delete_By_Id(int id);

    User find_By_Id(int id) throws SQLException;

    List<User> findAll();
}
