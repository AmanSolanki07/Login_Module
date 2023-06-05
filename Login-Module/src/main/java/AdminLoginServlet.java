import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String adminName = request.getParameter("adminName");
		String password = request.getParameter("password");

		if (adminName.equals("admin123") && password.equals("password123")) {
			// Admin login successful
			response.sendRedirect("AdminSuccess.jsp"); // Replace with your admin success page
		} else {
			// Admin login failed
			response.sendRedirect("AdminError.jsp"); // Replace with your admin error page
		}
	}
}
