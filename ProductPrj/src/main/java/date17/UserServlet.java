package date17;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // Set the content type to HTML
        PrintWriter out = response.getWriter(); // Get the PrintWriter to write to the webpage

        out.println("<html><head>");
        out.println("<style>");
        out.println("table {");
        out.println("    border-collapse: collapse;");
        out.println("    width: 50%;");
        out.println("}");

        out.println("th, td {");
        out.println("    border: 1px solid black;");
        out.println("    padding: 8px;");
        out.println("    text-align: left;");
        out.println("}");

        out.println("th {");
        out.println("    background-color: #f2f2f2;");
        out.println("}");

        out.println("</style>");
        out.println("</head><body>");
        out.println("<h1>Data from the Database</h1>");

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<p>Error: Class not found</p>");
            return;
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/today", "root", "Sakthi@130901");
            out.println("<p>Connection Established...</p>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error: Unable to connect to the database</p>");
            return;
        }

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM parts");
            out.println("<table>");
            out.println("<tr><th>ID</th><th>Name</th><th>Color</th></tr>");

            while (rs.next()) {
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                String color = rs.getString("color");

                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + color + "</td></tr>");
            }

            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error: Unable to execute the query</p>");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<p>Error: Unable to close the connection</p>");
            }
        }

        out.println("</body></html>");
        out.close();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add POST request handling logic if needed.
    }
}