package data;

import transferModels.User;

import java.util.ArrayList;

public interface UserDao {

    void addUser(User user);
    User getUser(int id);
}
