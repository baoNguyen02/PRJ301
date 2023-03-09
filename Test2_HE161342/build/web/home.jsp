<%-- 
    Document   : home
    Created on : Mar 9, 2023, 7:59:24 AM
    Author     : Win
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            Add new Student
            <br>ID:<input type="text" name="id"><br>
            Name:<input type="text" name="name"><br>
            Gender:<input type="radio" name="gender" value="1">Male
            <input type="radio" name="gender" value="0">Female
            <br><select name="option">
                <option value="1">information Technology</option>
                <option value="2">Business Administration</option>
                <option value="3">Data Science</option>
                <option value="4">Marketing and PR</option>
            </select>
            <br><input type="submit" value="Add"><br>
            <table border="3px" width="40%">
                <td>ID</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Department</td>
                <c:forEach items="${requestScope.data}" var="data">
                    <tr>
                        <td>${data.getId()}</td>
                        <td>${data.getName()}</td>
                        <td>${data.gender == 1 ? 'True' : 'False'}</td> 
                        <td>${data.did == 1? 'information Technology' : (data.did == 2 ? 'Business Administration' : 
                              (data.did == 3 ? 'Data Science' : 'Marketing and PR'))}</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
