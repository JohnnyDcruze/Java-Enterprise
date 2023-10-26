package bankTest;

import java.io.IOException;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int userId=Integer.parseInt(request.getParameter("userId"));
		String password=request.getParameter("password");
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
		 try {
	            
	            PreparedStatement statement = con.prepareStatement("SELECT * FROM account_details WHERE accountNo = ? AND password = ?");
	            statement.setLong(1, userId);
	            statement.setString(2, password);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                // Successful login, redirect to a welcome page or perform necessary actions.
	                response.sendRedirect("welcome.jsp");
	            } else {
	                // Invalid credentials, redirect back to the login page with a message.
	                response.sendRedirect("login.jsp");
	            }

	            resultSet.close();
	            statement.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
