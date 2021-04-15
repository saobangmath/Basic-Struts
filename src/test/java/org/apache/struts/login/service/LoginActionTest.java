package org.apache.struts.login.service;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.login.action.LoginAction;
import org.apache.struts.login.service.DBController;
import org.apache.struts2.StrutsTestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LoginActionTest extends StrutsTestCase {

    @Mock
    DBController dbController = Mockito.mock(DBController.class);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMissingUserName() throws Exception{
        request.setParameter("person.username", "");
        request.setParameter("person.password", "trtai");

        ActionProxy actionProxy = getActionProxy("/login.action");
        LoginAction action = (LoginAction) actionProxy.getAction() ;

        assertNotNull("The action is null but should not be.", action);

        String result = actionProxy.execute();

        assertEquals("The execute method did not return " + ActionSupport.ERROR + " but should have.", ActionSupport.ERROR, result);
        assertEquals("The action error should be thrown!", action.hasActionErrors(), true);
        assertEquals("Username & Password should be blank", action.getActionErrors().contains("Username & Password cannot be blank!"), true);
    }

    @Test
    public void testMissingPassword() throws Exception{
        request.setParameter("person.username", "trtai");
        request.setParameter("person.password", "");

        ActionProxy actionProxy = getActionProxy("/login.action");
        LoginAction action = (LoginAction) actionProxy.getAction() ;

        assertNotNull("The action is null but should not be.", action);

        String result = actionProxy.execute();

        assertEquals("The execute method did not return " + ActionSupport.ERROR + " but should have.", ActionSupport.ERROR, result);
        assertEquals("The action error should be thrown!", action.hasActionErrors(), true);
        assertEquals("Username & Password should be blank", action.getActionErrors().contains("Username & Password cannot be blank!"), true);
    }

    @Test
    public void testSuccessAuthentication() throws Exception {

        request.setParameter("person.username", "trtai");
        request.setParameter("person.password", "trtai");
        Mockito.when(dbController.validate(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(true);

        ActionProxy actionProxy = getActionProxy("/login.action");
        LoginAction action = (LoginAction) actionProxy.getAction();
        action.setDbController(dbController);

        assertNotNull("The action is null but should not be.", action);

        String result = actionProxy.execute();

        assertEquals("The execute method did not return " + ActionSupport.SUCCESS + " but should have.", ActionSupport.SUCCESS, result);
        assertEquals("No action error should be thrown!", action.hasActionErrors(), false);
    }

    @Test
    public void testFailAuthentication() throws Exception {

        request.setParameter("person.username", "trtai");
        request.setParameter("person.password", "trtai");
        Mockito.when(dbController.validate(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(false);

        ActionProxy actionProxy = getActionProxy("/login.action");
        LoginAction action = (LoginAction) actionProxy.getAction();
        action.setDbController(dbController);

        assertNotNull("The action is null but should not be.", action);

        String result = actionProxy.execute();

        assertEquals("The execute method did not return " + ActionSupport.ERROR + " but should have.", ActionSupport.ERROR, result);
        assertEquals("The action error should be thrown!", action.hasActionErrors(), true);
        assertEquals("Invalid Username & Password!", action.getActionErrors().contains("Invalid Username & Password!"), true);
    }
}
