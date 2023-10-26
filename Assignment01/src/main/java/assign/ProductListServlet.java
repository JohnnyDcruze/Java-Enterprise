package assign;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class ProductListServlet
*/
@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Product List</title><link rel=\"stylesheet\" href=\"styles3.css\">\r\n"
        		+ "</head><body>");
        out.println("<h1>Product Marketing</h1>");
        out.println("<form action='productDetails' method='get'>");
        out.println("Leo Das Hoodie <input type='submit' name='leo' value='Buy'><br>");
        out.println("Anthony Das Hoodie <input type='submit' name='antony' value='Buy'><br>");
        out.println("Harold Das Hoodie <input type='submit' name='harold' value='Buy'><br>");
        out.println("</form>");
        out.println("</body></html>");
    }
}