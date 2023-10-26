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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class withdrawServlet
 */
@WebServlet("/withdrawServlet")
public class withdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public withdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
		System.out.println(userId);
        double amount = Double.parseDouble(request.getParameter("amount"));
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/today","root","Sakthi@130901");
			System.out.println("Connection Established...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userId>0) {
		try {
			
			 PreparedStatement balanceStatement = con.prepareStatement("SELECT balance FROM account_details WHERE accountNo = ?");
	            balanceStatement.setLong(1, userId);
	            ResultSet balanceResultSet = balanceStatement.executeQuery();
			 if (balanceResultSet.next()) {
	                double balance = balanceResultSet.getDouble("balance");

	                if (amount <= balance) {
	                    // Sufficient balance for withdrawal.
	                    double newBalance = balance - amount;

	                    // Update the balance in the database.
	                    PreparedStatement updateStatement = con.prepareStatement("UPDATE account_details SET balance = ? WHERE accountNo = ?");
	                    updateStatement.setDouble(1, newBalance);
	                    updateStatement.setLong(2, userId);
	                    updateStatement.executeUpdate();

	                    // Set the response as a success message with the new balance.
	                    response.setContentType("text/html");
	                    PrintWriter out = response.getWriter();
	                    out.println("<html><body>");
	                    out.println("<h2>Withdrawal Successful</h2>");
	                    out.println("<p>You have successfully withdrawn " + amount + " </p>");
	                    out.println("<p>Your new balance is " + newBalance + " </p>");
	                    out.println("</body></html>");
	                } else {
	                    response.setContentType("text/html");
	                    PrintWriter out = response.getWriter();
	                    out.println("<html><body>");
	                    out.println("<h2>Withdrawal Failed</h2>");
	                    out.println("<p>Insufficient balance to withdraw </p>");
	                    out.println("</body></html>");
	                }
	            } else {
	            	System.out.println("User not found");
	            }
		}
			 catch (Exception e) {
		            e.printStackTrace();
		        }
		}
	}
	

}
