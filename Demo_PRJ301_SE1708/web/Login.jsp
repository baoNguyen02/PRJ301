<%-- 
    Document   : Login
    Created on : Mar 2, 2023, 11:08:20 PM
    Author     : Win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST" style="margin:auto">
            Account:<input type="text" name="account">
            <br>Password:<input type="text" name="password">
            <br>Login:<input type="submit" name="login" value="Login">
            <br><br>Do you have any account?<a href="Register.jsp">Register</a>
        </form>
        <h3>${result}</h3>
    </body>
</html>
