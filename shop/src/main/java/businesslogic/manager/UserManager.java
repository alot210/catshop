package businesslogic.manager;

import data.H2FactoryDao;
import data.H2UserDao;
import data.H2UserDaoMockUp;
import transferModels.User;

import java.sql.SQLException;

//TODO
public class UserManager {

    public void createUser(){

    }

    public void createUser(User user){

       /* User u = new User(user.getUserName(),user.getPassword(),user.getId());
        H2UserDaoMockUp UserDao = H2FactoryDao.getMockUp();

            UserDao.createUser(u);*/

    }


    public void createUserTable(){

    }

    public String getUserName(User u) throws SQLException {


        H2UserDao UserDao = H2FactoryDao.getDaoUser();
        H2UserDaoMockUp UserDao2 = H2FactoryDao.getMockUp();
        User benutzer = UserDao2.getUser(u.getId()); //u.getUserName();
        return benutzer.getUserName();
    }
}
