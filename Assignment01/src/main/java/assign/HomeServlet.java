package assign;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class HomeServlet
*/
@WebServlet("/welcome")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Welcome</title><link rel=\"stylesheet\" href=\"styles.css\"></head><body>");
        out.println("<h1>Welcome to the Leo Familie... ^.^ ..!</h1>");
        out.println("<a href='login'>Login</a>");
        out.println("</body></html>");
    }
}