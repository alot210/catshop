package data;

import transferModels.Article;
import transferModels.User;

import java.sql.SQLException;

public class H2UserDaoMockUp implements UserDao {

    @Override
    public void addUser(User article) throws SQLException {
    }

    @Override
    public User getUser(int id) throws SQLException {
        String username ="wiebke";
        User user = new User(username, "1234", username.hashCode());
        return user;
    }

    @Override
    public void deleteUser(User article) {

    }
}
