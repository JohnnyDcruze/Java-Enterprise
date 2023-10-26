package assign;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assign.ProductDetailServelet;
 
 
/**
* Servlet implementation class LoginServlet
*/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Login</title><link rel=\"stylesheet\" href=\"styles2.css\">\r\n"
        		+ "</head><body>");
        out.println("<form action='productList' method='post'>");
        out.println("Username: <input type='text' name='username' required><br>");
        out.println("Password: <input type='password' name='password' required ><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</body></html>");
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("leo");
        String password = request.getParameter("anilfamily");
        
        if(username.equals("leo") && password.equals("password")) {
            response.sendRedirect("ProductDetailsServlet");
        }
        else {
            response.sendRedirect("login");
        }
    }
 
}