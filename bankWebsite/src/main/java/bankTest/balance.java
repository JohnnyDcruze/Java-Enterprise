package bankTest;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class balance
*/
@WebServlet("/balance")
public class balance extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PrintWriter out=response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/today", "root", "Sakthi@130901");
            System.out.println("Connection Established...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        int userId = Integer.parseInt(request.getParameter("uid"));
 
        try {
            PreparedStatement balanceStatement = con.prepareStatement("select balance from account_details where accountNo = ?");
            balanceStatement.setInt(1, userId);
            ResultSet resultSet = balanceStatement.executeQuery();
 
            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                out.println("Balance : "+balance);
            } else {
                response.sendRedirect("balance_failed.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("balance_failed.jsp");
        }
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}