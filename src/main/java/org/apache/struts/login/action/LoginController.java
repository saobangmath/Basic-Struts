package org.apache.struts.login.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.login.model.Person;
import org.apache.struts.login.service.DBController;

public class LoginController extends ActionSupport {
    private Person person;

    @Override
    public String execute(){
        String username = person.getUsername(),
               password = person.getPassword();
        boolean status = false;
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            reset();
            System.out.println("Action error");
            addActionError("Username & Password cannot be blank!");
        }
        else{
            status = DBController.validate(username, password);
            if (!status){
                reset();
                addActionError("Invalid Username & Password!");
            }
        }
        return status ? "Success" : "Error";
    }

    public Person getPerson(){
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void reset(){
        person.setPassword("");
        person.setUsername("");
    }
}
