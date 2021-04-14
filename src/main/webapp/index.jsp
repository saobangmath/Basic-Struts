<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link href="./styles/index.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
   <s:if test='hasActionErrors()'>
       <s:actionerror />
   </s:if>
  <header>
      <h1>CZ3002 Login Webapp with Struts2 </h1>
      <h3>By: TRAN ANH TAI, CAI ZIXIN, CLARENCE CHEW KAI WEI</h3>
  </header>
  <center>
    <s:form action = "login">
        <s:textfield  name = "person.username"  label = "Username"/>
        <s:textfield  name = "person.password" label = "Password"/>
        <s:submit value = "Login"/>
     </s:form>
    <center>
  </body>
</html>
