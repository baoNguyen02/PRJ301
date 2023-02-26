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
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class LoginController extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhan thong tin
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        //Xy ly thong tin
        User user = new User(account, password);
        boolean check = user.checkUser();
                
        
        //Tra ket qua ve
        if(check){
            String name=user.getNameByAccount(account);
            req.setAttribute("name", name);
            ArrayList<User> data=user.getListUser();
            req.setAttribute("data", data);
            
            req.getRequestDispatcher("ListUser.jsp").forward(req, resp);
            
        } else{
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    
}