<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
  </head>
  <body>
  <center>
    <s:form action = "login">
        <s:textfield  name = "person.username"  label = "Username"/>
        <s:textfield  name = "person.password" label = "Password"/>
        <s:submit value = "Login"/>
     </s:form>
    <center>
  </body>
</html>
