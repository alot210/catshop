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
        userManager.createUser(user.getUserName(), user.getPassword(), user.getId());
        return renderUserWelcome();
    }

    public String renderUserWelcome () throws SQLException {


        user.setUserName(userManager.getUserName(user));
        return "/welcome.xhtml";
    }

}
