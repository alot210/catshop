package businesslogic.managedbeans;

import businesslogic.manager.UserManager;
import transferModels.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.SQLException;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

    private User user;
    private UserManager userManager;

    @PostConstruct
    void init(){
        userManager = new UserManager();
        user = new User();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public String createUser() throws SQLException {


        user.setId(user.getUserName().hashCode());
        userManager.createUser(user);
        user.setUserName(userManager.getUserName(user));

        return "ok";
    }

  /*  public String renderUserWelcome () throws SQLException {


        return "welcome.xhtml";
    }*/

    public String logout(){

        user.setUserName("");
        user.setPassword("");
        //todo
        return "ok";
    }

    public String resetForm(){

        return "login.xhtml";
    }

}
