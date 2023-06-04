import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class MyServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null && action.equals("register")) {
			// Process registration form submission
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String id = request.getParameter("id");
			String email = request.getParameter("email");

			// Validate and handle registration data
			if (username != null && password != null && id != null && email != null) {
				RegistrationData registrationData = new RegistrationData(username, password, id, email);

				// Call the DAO to register the user
				RegistrationDAO registrationDAO = new RegistrationDAO();
				boolean registrationSuccessful = registrationDAO.registerUser(registrationData);

				if (registrationSuccessful) {
					// Registration successful
					request.setAttribute("message", "Registration successful. Please log in.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				} else {
					// Registration failed
					request.setAttribute("message", "Registration failed. Please try again.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				// Invalid registration data
				request.setAttribute("message", "Invalid registration data. Please try again.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
			}
		} else if (action != null && action.equals("login")) {
			// Process login form submission
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			// Validate and handle login data
			if (username != null && password != null) {
				LoginData loginData = new LoginData(username, password);

				// Call the DAO to validate the user
				LoginDAO loginDAO = new LoginDAO();
				boolean loginSuccessful = loginDAO.validateUser(loginData);

				if (loginSuccessful) {
					// Login successful
					request.setAttribute("message", "Login successful. Welcome, " + username + "!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
					dispatcher.forward(request, response);
				} else {
					// Login failed
					request.setAttribute("message", "Invalid username or password. Please try again.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				// Invalid login data
				request.setAttribute("message", "Invalid login data. Please try again.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
