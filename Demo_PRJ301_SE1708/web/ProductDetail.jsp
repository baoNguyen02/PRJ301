<%-- 
    Document   : ProductDetail
    Created on : Mar 2, 2023, 11:31:10 PM
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
        <form action="product" method="post">
            ProductID<input type="text" name="id" value="${p.getId()}">
            <br>ProductName:<input type="text" name="name" value="${p.getName()}">
            <br>Price:<input type="text" name="price" value="${p.getPrice()}">
            <br>Stock:<input type="text" name="stock" value="${p.getStock()}">
            <br>Image:<input type="text" name="image" value="${p.getImage()}">
            <br><input type="submit" name="submit" value="update">
        </form>
    </body>
</html>
