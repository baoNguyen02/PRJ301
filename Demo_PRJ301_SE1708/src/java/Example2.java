/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author M.S.I
 */
@WebServlet(urlPatterns = {"/example2"})
public class Example2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try ( PrintWriter out = response.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("</head>");
            out.print("<body>");
            out.print("CALCULATOR");
            out.print("<form method='post'>");
            out.print("Enter a:<input type='text' name='a'>");
            out.print("<br>Enter b:<input type='text' name='b'>");
            out.print("<br><input type='submit' value='OK' name='ok'>");
            out.print("</form>");
            out.print("</body>");
            out.print("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try ( PrintWriter out = response.getWriter()) {
            //Nhận thông tin từ clinent

            int a = 0, b = 0;
            String result = null;
            Boolean check = true;
            if (request.getParameter("a").isEmpty()) {
                result = "a is empty";
                check = false;
            } else {
                try {
                    a = Integer.parseInt(request.getParameter("a"));
                } catch (Exception e) {
                    result = "a is not interger number";
                    check = false;
                }
            }
            if (!check) {
                //out.print(result);
            }
            if (request.getParameter("b").isEmpty()) {
                result = "b is empty";
                check = false;
                  request.setAttribute("result", result);
            request.getRequestDispatcher("Calculator.jsp").forward(request, response);
            } else {
                try {
                    a = Integer.parseInt(request.getParameter("b"));
                } catch (Exception e) {
                    result += "b is not interger number";
                    check = false;
                      request.setAttribute("result", result);
            request.getRequestDispatcher("Caculation.jsp").forward(request, response);
                }
            }
            

            a = Integer.parseInt(request.getParameter("a"));//Yeu cau mot so nguyen a,b
            b = Integer.parseInt(request.getParameter("b"));

            // xử lý thông tin theo yêu cầu
            if (request.getParameter("op").equals("1")) {
                result = "" + (a + b);
            }
            if (request.getParameter("op").equals("2")) {
                result = "" + (a - b);
            }
            

            if (request.getParameter("op").equals("0")) {
                //result = "Chua chon op kia bro...";
                if (getInitParameter("op").equals("3")) {
                    result = "" + ((double) a / b);
                } else {
                    if (getServletContext().getInitParameter("op").equals("3")) {
                        result = "" + (a % b);
                    } else {
                        result = "M chua chon OP";
                    }
                }

            }
            request.setAttribute("op", request.getParameter("op"));
            
            if (request.getParameter("ok") != null) {//có nhấn nút ok
                result = "" + (a * b);
            }
            // Trả kết quả chỏ Cilent
            request.setAttribute("a",String.valueOf(a));
            request.setAttribute("b", String.valueOf(b));
            request.setAttribute("result", result);
            request.getRequestDispatcher("Calculator.jsp").forward(request, response);
           
        }catch(NumberFormatException e){
            
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}