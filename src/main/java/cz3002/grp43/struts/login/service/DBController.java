package cz3002.grp43.struts.login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBController {
    static final String DB_USERNAME = "trtai";
    static final String DB_PASSWORD = "S@obang12345678901";
    static final String URL = "jdbc:mysql://localhost:3306/DB";
    static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public boolean validate(String username, String password){
        boolean status = false;
        try{
            Class.forName(DRIVER_CLASS);
            Connection conn = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement ps = conn.prepareStatement("select * from DB.User where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();
            status = result.next();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
