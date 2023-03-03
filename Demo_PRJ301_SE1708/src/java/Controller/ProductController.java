/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Win
 */
public class ProductController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= req.getParameter("id");
        String name= req.getParameter("name");
        String price= req.getParameter("price");
        String stock= req.getParameter("stock");
        String image= req.getParameter("image");
        
        Product p =new Product(id, name, price, stock, "");
        p.update();
        ArrayList<Product> data=p.getListProduct();
        req.setAttribute("data", data);
        req.getRequestDispatcher("Product.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        ArrayList<Product> data=product.getListProduct();
        req.setAttribute("data", data);
        req.getRequestDispatcher("Product.jsp").forward(req, resp);
    }
    
}
