package transferModels;

import java.sql.Connection;

import java.io.Serializable;

public class Config implements Serializable {


    static Connection con;

    public static Connection  setSQLConnection(Connection _con){
        con = _con;
        return con;
    }

    public static Connection getSQLConnection(){
        return con;
    }
}
