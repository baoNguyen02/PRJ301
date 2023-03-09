/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Product;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Win
 */
public class DetailController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("mode")!=null && req.getParameter("mode").equals("1")) {
            Product p = new Product();
            String id = req.getParameter("id");
            p.getProduct(id);
            req.setAttribute("p", p);
            req.getRequestDispatcher("ProductDetail.jsp").forward(req, resp);
        }

        String account = req.getParameter("account");
        User u = new User(account, "");
        u.getUser(account);
        req.setAttribute("u", u);
        req.getRequestDispatcher("Detail.jsp").forward(req, resp);
       
    }

}
