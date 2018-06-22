package data;

import transferModels.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {

    void addUser(User article) throws SQLException;
    User getUser(int id) throws SQLException;
    void deleteUser(User article);
}
