package data;

import transferModels.Config;
import transferModels.User;

import java.sql.*;

public class H2UserDao {

    public void addUser(User user) throws SQLException {

        Connection con = Config.getSQLConnection();

        String sql = "INSERT INTO USER(ID,NAME,PASSWORD) VALUES (?,?,?)";
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

    public void createUserTable() {
        try {
            Connection con = Config.getSQLConnection();
            PreparedStatement statement1 = con.prepareStatement("DROP TABLE IF EXISTS USER");
            PreparedStatement statement2 = con.prepareStatement("CREATE TABLE USER(ID INT PRIMARY KEY, NAME VARCHAR(255), PASSWORD VARCHAR(255))");

            statement1.execute();
            statement2.execute();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
