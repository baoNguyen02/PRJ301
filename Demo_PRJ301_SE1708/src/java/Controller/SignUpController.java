/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Win
 */
public class SignUpController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out=resp.getWriter()){
            String account=req.getParameter("account");
            String pass=req.getParameter("pass");
            String repass=req.getParameter("repass");
            String name=req.getParameter("name");
            String gender=req.getParameter("gender");
            String date=req.getParameter("date");
            String address=req.getParameter("address");
            String result="";
            boolean check = true;
            
            if(account==null){
                result+="account empty!";
                check=false;
            }
            if(pass==null){
                result+="pass empty!";
                check=false;
            }
            if(repass==null){
                result+="repass empty!";
                check=false;
            }
            if(name==null){
                result+="name empty!";
                check=false;
            }
            if(gender==null){
                result+="gender empty!";
                check=false;
            }
            if(date==null){
                result+="date empty!";
                check=false;
            }
            if(address==null){
                result+="address empty!";
                check=false;
            }
            if(!pass.equals(repass)){
                result+="pass not equal repass!!!";
                check=false;
            }
            
            LocalDate dobLocalDate = null;
            try {
                dobLocalDate = LocalDate.parse(date);
                LocalDate today = LocalDate.now();
                if (dobLocalDate.isAfter(today)) {
                    result+="date must be previous";
                    check=false;
                }
            } catch (DateTimeParseException ex) {
                result+="Invalid date of birth";
                check=false;
            }
            
            if(check==true){
                User user = new User(account, "");
                boolean check1 = user.checkUser1();
                if(!check1){
                    User user1=new User(account, repass, name, date, gender, address);
                    user1.insert();
                    result+="update successful";
                    req.setAttribute("result", result);
                    req.getRequestDispatcher("Home.jsp").forward(req, resp);
                }else{
                    result+="account exited!!!";
                } 
            }
            
            req.setAttribute("result", result);
            req.getRequestDispatcher("Register.jsp").forward(req, resp);           
        }
    }
}
