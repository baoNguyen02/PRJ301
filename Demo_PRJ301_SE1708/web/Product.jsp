<%-- 
    Document   : Product
    Created on : Mar 2, 2023, 10:47:09 PM
    Author     : Win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="3px" width="40%">
            <h3><a href="AddProduct.jsp">Add new</a></h3>
            <td>id</td>
            <td>name</td>
            <td>price</td>
            <td>stock</td>
            <td>image</td>
        
            
            <c:forEach items="${requestScope.data}" var="item">
                <tr>
                    <td><a href="detail?id=${item.getId()}&mode=1">${item.getId()}</a></td>
                    <td>${item.getName()}</td>
                    <td>${item.getPrice()}</td>
                    <td>${item.getStock()}</td>
                    <td>${item.getImage()}</td>
                    <td>
                        <a href="delete?id=${item.getId()}">DELETE</a>
                    </td>
                </tr>
            </c:forEach>                
        </table>
    </body>
</html>
