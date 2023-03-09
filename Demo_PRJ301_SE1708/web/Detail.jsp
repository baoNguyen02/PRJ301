<%-- 
    Document   : Detail
    Created on : Mar 3, 2023, 1:03:19 PM
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
        Account: ${u.getName()}<br><br>
        Password: ${u.getPassword()}<br><br>
        Name: ${u.getName()}<br><br>
        Gender: ${u.getGender()}<br><br>
        Address: ${u.getAddress()}<br><br>
        Dob: ${u.getDob()}
    </body>
</html>
