package transferModels;

//TODO

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String password;
    private String id;

    public User(){

    }

    public User(String userName, String password, String id){
        this.userName= userName;
        this.password = password;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
