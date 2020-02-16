package repository.impl;

import bdsql.users.User;
import bdsql.users.UserMapper;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public static final String CREATE_BY_ID = "INSERT INTO users (first_name, last_name) values(?,?)";
    public static final String UPDATE_BY_ID = "UPDATE users SET first_name=?, last_name=? WHERE id=?";
    private static final String READ_BY_ID = "select * from users where id =?";
    private static final String DELETE_BY_ID = "delete from users where id=?";
    private static final String READ_ALL = "select * from users";
    private Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public void save_By_Id(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(CREATE_BY_ID);

            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public void update_By_Id(User user){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_BY_ID);
            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setInt(3, user.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void delete_By_Id(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public User find_By_Id(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(READ_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        User result = UserMapper.map(resultSet);
        statement.close();
        return result;
    }
    public List<User> findAll() {
        PreparedStatement statement = null;
        List<User> listOfUsers = new ArrayList<>();
        try {
            statement = connection.prepareStatement(READ_ALL);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listOfUsers.add(UserMapper.map(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listOfUsers;
    }
}
