<%-- 
    Document   : ListUser
    Created on : Mar 2, 2023, 11:10:49 PM
    Author     : Win
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
           //nhan thong tin
            String name ="";
            if(request.getAttribute("name")!=null)
                name =(String)request.getAttribute("name");
        
            ArrayList<User> data = new ArrayList<User>();
            if(request.getAttribute("data")!=null)
                data = (ArrayList<User>)request.getAttribute("data");
        %>

        <h1>Welcome ${name}</h1>

        <table border="1px" width="40%">
            <td>Account</td>
            <td>Password</td>
            <td>Name</td>
            <td>Gender</td>
            <td>Address</td>
            <td>DOB</td>

            <%
                for(User user:data){
                    out.print("<tr>");
                    //out.print("<td><a href='detail?acc="+u.getAccount()+"' >"+user.getAccount()+"</a></td>");
                    out.print("<td><a href='detail?account="+user.getAccount()+"'>" + user.getAccount() +"</a></td>");
                    out.print("<td>"+user.getPassword()+"</td>");
                    out.print("<td>"+user.getName()+"</td>");
                    out.print("<td>"+user.getGender()+"</td>");
                    out.print("<td>"+user.getAddress()+"</td>");
                    out.print("<td>"+user.getDob()+"</td>");
                    out.print("</tr>");
                }
            %>    
        </table>

        <br>List User-using JSTL-EL 

        <table border="3px" width="40%">
            <td>Account</td>
            <td>Password</td>
            <td>Name</td>
            <td>Gender</td>
            <td>Address</td>
            <td>DOB</td>

            <c:forEach items="${requestScope.data}" var="item">
                <tr>
                    <td><a href="detail?account=${item.getAccount()}">${item.getAccount()}</a></td>
                    <td>${item.getPassword()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getGender()}</td>
                    <td>${item.getAddress()}</td>
                    <td>${item.getDob()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
