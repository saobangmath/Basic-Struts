<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
  </head>
  <body>
    <s:form action = "register">
        <s:textfield  name = "person.username"  label = "Username"/>
        <s:textfield  name = "person.password" label = "Password"/>
        <s:submit/>
    </s:form>
  </body>
</html>