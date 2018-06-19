package data;

import transferModels.Article;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {

    void addUser(Article article) throws SQLException;
    Article getUser(int id) throws SQLException;
    void deleteUser(Article article);
}
