<%-- 
    Document   : detail
    Created on : Feb 23, 2023, 9:34:05 AM
    Author     : Win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.User" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User u=new User();
            if(request.getAttribute("u")!=null)
                u = (User)request.getAttribute("u");
        %>
        
        Account: <%= u.getName()%><br><br>
        Password: <%= u.getPassword()%><br><br>
        Name: <%= u.getName()%><br><br>
        Gender: <%= u.getGender()%><br><br>
        Address: <%= u.getAddress()%><br><br>
        Dob: <%= u.getDob()%>
    </body>
</html>
