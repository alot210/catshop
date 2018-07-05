package businesslogic.manager;

import data.H2FactoryDao;
import data.H2UserDao;
import data.H2UserDaoMockUp;
import transferModels.User;

import java.sql.SQLException;

//TODO
public class UserManager {

    public void createUser(User user){

        User u = new User(user.getUserName(),user.getPassword(),user.getId());
//        H2UserDaoMockUp UserDao = H2FactoryDao.getMockUp();
        H2UserDao userDao = H2FactoryDao.getDaoUser();
        try {
            userDao.addUser(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void createUserTable(){
        H2UserDao userDao = H2FactoryDao.getDaoUser();
        userDao.createUserTable();
    }

    public String getUserName(User u) throws SQLException {


        H2UserDao UserDao = H2FactoryDao.getDaoUser();

        User user = UserDao.getUser(u.getId());

//        H2UserDaoMockUp UserDao2 = H2FactoryDao.getMockUp();
//        User benutzer = UserDao2.getUser(u.getId()); //u.getUserName();
        return user.getUserName();
    }
}
