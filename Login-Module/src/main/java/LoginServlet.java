import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Establish database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String dbUsername = "root";
        String dbPassword = "Mikunakano123";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

            // Prepare and execute SQL query
            String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Login successful
                response.sendRedirect("Success.jsp");
            } else {
                // Login failed
                response.sendRedirect("Error.jsp");
            }

            // Close database connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any database errors
        }
    }
}
