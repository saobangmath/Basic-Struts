package org.apache.struts.login.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.login.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends ActionSupport {
    private Person person;

    @Override
    public String execute(){
        boolean status = false;
        try{
            String url = "jdbc:mysql://localhost:3306/DB";
            String username = "trtai";
            String password = "S@obang12345678901";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement("select * from DB.User where username = ? and password = ?");
            ps.setString(1, person.getUsername());
            ps.setString(2, person.getPassword());
            ResultSet result = ps.executeQuery();
            status = result.next();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (!status){
            person.setPassword("");
            person.setUsername("");
        }
        return status ? "Success" : "Error";
    }

    public Person getPerson(){
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
