package bdsql.users;

import connection.ConnectionManager;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Connection connection = ConnectionManager.createConnection();
        UserRepository repository = new UserRepositoryImpl(connection);

       // User user = new User("hgds","sdfs", 7);
      //  repository.save_By_Id(user);
        User userToUpdate = new User("Peter", "Dog", 5);
        repository.update_By_Id(userToUpdate);

      //  try {
      //      System.out.println(repository.find_By_Id(52));
      //  } catch (SQLException e) {
      //      e.printStackTrace();
     //   }

    //    System.out.println(repository.findAll());
    }
}

