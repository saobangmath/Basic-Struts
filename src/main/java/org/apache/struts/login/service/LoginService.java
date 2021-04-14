package org.apache.struts.login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {
    static final String dbUsername = "trtai";
    static final String dbPassword = "S@obang12345678901";
    static final String dbName = "DB";
    public static boolean validate(String username, String password){
        boolean status = false;
        try{
            String url = "jdbc:mysql://localhost:3306/" + dbName;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
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
