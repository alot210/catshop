package businesslogic.manager;

import data.H2FactoryDao;
import data.H2UserDao;
import transferModels.User;

import java.sql.SQLException;

//TODO
public class UserManager {

    public void createUser(){

    }

    public void createUser(String userName, String password, int id){

        User u = new User(userName,password,id);
        /*H2UserDao UserDao = H2FactoryDao.getDaoUser();
        try {
            //UserDao.addUser(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }


    public void createUserTable(){

    }

    public String getUserName(User u) throws SQLException {


        H2UserDao UserDao = H2FactoryDao.getDaoUser();
        //UserDao.getUser(id).getUserName();
        return u.getUserName();
    }
}
