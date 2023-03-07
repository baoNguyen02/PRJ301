<%-- 
    Document   : AddProduct
    Created on : Mar 4, 2023, 5:35:22 PM
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
        <h3>Add new Product</h3>
        <form action="add" method="post">
            <br>ProductName:<input type="text" name="name">
            <br>Price:<input type="text" name="price">
            <br>Stock:<input type="text" name="stock">
            <br>Image:<input type="text" name="image">
            <br><input type="submit" name="submit" value="Add">
        </form>
    </body>
</html>
