package db.demo;

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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("partid"));
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/today", "root", "Sakthi@130901");
            System.out.println("Connection Established...");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement s = con.prepareStatement("DELETE FROM parts WHERE p_id = ?");
            s.setInt(1, pid);

            int x = s.executeUpdate();

            if (x != 0) {
                PrintWriter out = response.getWriter();
                out.println("Record Deleted...");
            } else {
                PrintWriter out = response.getWriter();
                out.println("Record not found or not deleted...");
            }

            con.close(); // Close the connection when done
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
