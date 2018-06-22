package businesslogic.managedbeans;

import businesslogic.manager.UserManager;
import transferModels.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private User user;
    private UserManager userManager;

    @PostConstruct
    void init(){
        userManager = new UserManager();
        user = new User();
    }

    //getter und setter müpssen immer public sein, da sich JSF die selbst suchen muss!
    private void setUser(User user) {
        this.user = user;
    }

    private User getUser(){
        return user;
    }

    public void createUser(){
        user.setId(user.getUserName().hashCode());
        userManager.createUser(user.getUserName(), user.getPassword(), user.getId());
    }
/*
    public String renderUserWelcome (){

        userManager.getUserName(user.)
    }
    */
}
