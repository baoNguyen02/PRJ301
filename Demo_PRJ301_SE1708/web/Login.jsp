<%-- 
    Document   : Login
    Created on : Feb 14, 2023, 10:32:28 AM
    Author     : HP
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
        </form>
    </body>
</html>
