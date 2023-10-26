package assign;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import assign.ProductListServlet;
 
/**
* Servlet implementation class ProductDetailsServlet
*/
@WebServlet("/productDetails")
public class ProductDetailServelet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        
        // Assuming you have a method to get purchased products for a user
        List<String> purchasedProducts = getPurchasedProducts(request.getSession().getAttribute("username").toString());
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Product Details</title></head><body>");
        out.println("<h1>Product Details</h1>");
        out.println("<p>Product Name: " + product + "</p>");
        
        if(purchasedProducts.contains(product)) {
            out.println("<p>You have already bought this product.</p>");
        } else {
            out.println("<form action='buyProduct' method='post'>");
            out.println("<input type='hidden' name='product' value='" + product + "'>");
            out.println("<input type='submit' value='Buy'>");
            out.println("</form>");
        }
        
        out.println("</body></html>");
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        
        // Assuming you have a method to add purchased products for a user
        addPurchasedProduct(request.getSession().getAttribute("username").toString(), product);
        
        response.sendRedirect("productList");
    }
    
    private List<String> getPurchasedProducts(String username) {
        // Implement this method to retrieve purchased products for a user
        return null;
    }
    
    private void addPurchasedProduct(String username, String product) {
        // Implement this method to add purchased products for a user
    }
}