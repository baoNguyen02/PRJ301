
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Win
 */
public class Example extends HttpServlet {

    /**
     * Hàm này được gọi khi Form gọi nó set method='post'
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            //Nhận thông tin từ Client
            int a = 0, b = 0;
            String result = null;
            boolean check = true;
            if (req.getParameter("a").isEmpty()) {
                result = "a is empty";
                check = false;
            } else {
                try {
                    a = Integer.parseInt(req.getParameter("a"));
                } catch (Exception e) {
                    result = "a is not integer number";
                    check = false;
                }
            }

            if (req.getParameter("b").isEmpty()) {
                result += "b is empty";
                check = false;
            } else {
                try {
                    b = Integer.parseInt(req.getParameter("b"));
                } catch (Exception e) {
                    result += "b is not integer number";
                    check = false;
                }
            }

            if (check = false) {
                out.print(result);
            } else {
                if (req.getParameter("op").equals("1")) {
                    result = "a+b=" + (a + b);
                }
                if (req.getParameter("op").equals("2")) {
                    result = "a-b=" + (a - b);
                }
                if (req.getParameter("op").equals("0")) {
                    result = "m chưa chọn ok!!!";
                }
                if (req.getParameter("ok") != null) {//có nhấn nut ok
                    result = "a*b=" + (a * b);
                }
            }
            //Xử lí thông tin theo yêu càu
            //Trả kết quả cho Client
            out.print(result);
        } catch (Exception e) {

        }
    }

    /**
     * Hàm này được gọi khi 1. Chạy trực tiếp servlet 2. Form gọi nó set
     * method='get' hoặc không set method
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("</head>");
            out.print("<body>");
            out.print("CALCULATION");
            out.print("<form method='post'>");
            out.print("Enter a:<input type='text' name='a'>");
            out.print("<br>Enter b:<input type='text' name='b'>");
            out.print("<br><input type='submit' value='OK' name='ok'>");
            out.print("<input type='reset' value='RESET' name='reset'>");
            out.print("</form>");
            out.print("</body>");
            out.print("</html>");
        } catch (Exception e) {

        }
    }

}
