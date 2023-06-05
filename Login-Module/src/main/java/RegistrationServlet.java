import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String id_number = request.getParameter("id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(name, id_number, email, password);

        RegistrationDAO registrationDAO = new RegistrationDAO();
        boolean registrationResult = registrationDAO.registerUser(user);

        if (registrationResult) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
