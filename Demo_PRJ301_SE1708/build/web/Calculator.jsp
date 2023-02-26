<%-- 
    Document   : Caculation
    Created on : Feb 7, 2023, 11:33:41 AM
    Author     : M.S.I
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String result="";
        if(request.getAttribute("result")!=null)
        result=(String)request.getAttribute("result");
        String a="", b="";
        if(request.getAttribute("a")!=null){
        a=(String)request.getAttribute("a");
            }
            if(request.getAttribute("b")!=null){
        b=(String)request.getAttribute("b");
            }
        String op="";
        if(request.getAttribute("op")!=null){
        op=(String)request.getAttribute("op");}  
            
        
        %>
        CACULATION
        <form id="frm" action="Example2" method='post'>
            Enter a:<input type='text' name='a' value="<%=a%>">
            <br>Enter b:<input type='text' name='b' value="<%=b%>">
            <br>Operator:
            <select name="op" onchange="change()">
                <%
                    if(op.equals("1")){
                    out.print("<option value='1'>+</option>");
                    out.print("<option value='0'>All</option>");
                    out.print("<option value='2'>-</option>");
                    }else if(op.equals("2")){
                    out.print("<option value='2'>-</option>");
                    out.print("<option value='0'>All</option>");
                    out.print("<option value='1'>+</option>");
                    }else{
                    out.print("<option value='2'>-</option>");
                    out.print("<option value='1'>+</option>");
                    out.print("<option value='0'>All</option>");
                    }
                %>
            </select>
            <br>Result: <input type="text" readonly value="<%=result%>"/>
            <br><input type='submit' value='OK' name='ok'>
        </form>
        <script>
            function change() {
                document.getElementById("frm").submit();
            }
        </script>
    </body>
</html>