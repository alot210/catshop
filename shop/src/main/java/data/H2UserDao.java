package data;

import transferModels.Config;
import transferModels.User;

import java.sql.*;

public class H2UserDao {

    public void addUser(User user) throws SQLException {

        Connection con = Config.getSQLConnection();

        String sql = "INSERT INTO USER(ID,NAME,PRICE,AMOUNT) VALUES (?,?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, user.getId());
        statement.setString(2, user.getUserName());
        statement.setString(3, user.getPassword());
        int numberRows = statement.executeUpdate();
    }

    public User getUser(int id) throws SQLException {
        Connection con = Config.getSQLConnection();
        String sql = "SELECT * FROM USER WHERE ID="+id;
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        User user = new User();
        while(resultSet.next()) {
            user.setId(resultSet.getInt("ID"));
            user.setUserName(resultSet.getString("NAME"));

        }
        return user;
    }

    public void deleteUser(User user){
        int id = user.getId();
        String sql = "DELETE FROM ARTICLE WHERE ID="+id;
    }
}
