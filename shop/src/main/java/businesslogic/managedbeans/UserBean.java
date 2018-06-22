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



    public String userName;
    public String password;
    public int id;

    @PostConstruct
    void init(){
        userManager = new UserManager();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    private void setUser(User user) {
        this.user = user;
    }

    private User getUser(){
        return user;
    }

    public void createUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int uid = username.hashCode();
        userManager.createUser(username, password, uid);
    }
}
