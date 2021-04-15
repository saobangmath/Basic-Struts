package org.apache.struts.login.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.login.model.Person;
import org.apache.struts.login.service.DBController;
import org.apache.commons.lang3.StringUtils;

public class LoginAction extends ActionSupport {

    private Person person;

    private DBController dbController = new DBController();

    @Override
    public String execute(){
        String username = person.getUsername(),
               password = person.getPassword();
        boolean status = false;
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            reset();
            addActionError("Username & Password cannot be blank!");
        }
        else{
            status = dbController.validate(username, password);
            if (!status){
                reset();
                addActionError("Invalid Username & Password!");
            }
        }
        return status ? SUCCESS : ERROR;
    }

    public Person getPerson(){
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public DBController getDbController() {
        return dbController;
    }

    public void setDbController(DBController dbController) {
        this.dbController = dbController;
    }

    public void reset(){
        person.setPassword("");
        person.setUsername("");
    }
}
