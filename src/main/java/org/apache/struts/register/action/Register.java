package org.apache.struts.register.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.register.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends ActionSupport {
    private Person person;

    @Override
    public String execute(){
        boolean status = false;
        try{
            String url = "jdbc:mysql://localhost:3306/DB";
            String username = "trtai";
            String password = "S@obang12345678901";
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(person.getUsername() + " " + person.getPassword());
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
        return status ? "Success" : "Error";
    }

    public Person getPerson(){
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
