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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Win
 */
public class ProductController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses=req.getSession();
        if(ses.getAttribute("account")==null){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out=resp.getWriter()){
                out.print("chua login!!!");
                return;
            } 
        }
        
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
        //check xem da login chua?
        HttpSession ses=req.getSession();
        if(ses.getAttribute("account")==null){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out=resp.getWriter()){
                out.print("chua login!!!");
                return;
            } 
        }
        
        Product product = new Product();
        ArrayList<Product> data=product.getListProduct();
        req.setAttribute("data", data);
        req.getRequestDispatcher("Product.jsp").forward(req, resp);
    }
    
}
