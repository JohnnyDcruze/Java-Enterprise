package bankTest;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
* Servlet implementation class demo_16
*/
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int UserId=Integer.parseInt(request.getParameter("userId"));
		String Username=request.getParameter("userName");
		String Password=request.getParameter("password"); 
		Connection con=null;
				try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
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
 
			PreparedStatement s=con.prepareStatement("insert into account_details(accountNo,username,password,balance) values(?,?,?,?)");
			s.setInt(1, UserId); 
			s.setString(2, Username);
			s.setString(3,Password);
			s.setDouble(4,0.0);
 
			int x=s.executeUpdate();
			if(x!=0) {
 			PrintWriter out=response.getWriter();
			out.println("Record Inserted..."); 
			}
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
 
		
 
	}
	}