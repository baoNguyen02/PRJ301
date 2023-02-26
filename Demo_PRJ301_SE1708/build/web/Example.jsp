<%-- 
    Document   : Example
    Created on : Feb 7, 2023, 10:12:38 AM
    Author     : HP

//c2:
 <%--
             
            
            for(int i=a;i<=b;i++)
            if(isSquare(i)) out.print(i +" "); 
        --%>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //Scriptlet-Noi viet code giong Servlet
           // out.print(message);
            String message="Xin chao moi nguoi!";
            //out.print(message);
            
            //Khai bao va khoi tao 2 bien so nguyen a va b
            //hien thi tong, hieu, tich, thuong, so du cua 2 so
            int a=5, b=26;
            String rs="";
            //out.print("a+b="+(a+b));
            //out.print("<br>a+b="+(a-b));
            //out.print("<br>a-b="+(a*b));
            //out.print("<br>a*b="+((double)b/a));
            //out.print("<br>a%b="+(b%a));
            
            //viet ham kiem tra so chinh phuong -isSquare
            //ap dung ham tren, hien thi so chinh phuong
            //tu a den b
            //out.print("<br>Cac so chinh phuong tu a den b: ");
            for(int i=a;i<=b;i++){
            if(isSquare(i)) //out.print(i +" ");
                                rs=i+ " ";

//            }
            
        %>

        <%!
            //Day la noi se co khai bao toan cuc-Global
            String message="Ok anh em!";
            boolean isSquare(int n){
            int temp = (int)Math.sqrt(n);
                if(temp*temp == n) {
                    return true;
                    }else{
                   return false;}
                    }
        %>

        <br>a=<%=a%>
        <br>b=<%=b%>
        <br>a+b=<%=a+b%>
        <br>a-b=<%=a-b%>
        <br>a*b=<%=a*b%>
        <br>a/b=<%=(double)a/b%>
        <br>a%b=<%=a%b%>
        <br>Cac so chinh phuong tu <%=a%> den <%=b%>: <%=rs%>
       


    </body>
</html>
