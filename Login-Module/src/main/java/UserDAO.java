import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase";
    private final String dbUsername = "root";
    private final String dbPassword = "Mikunakano123";

    public boolean validateUser(String username, String password) {
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    	    e.printStackTrace();
    	}

        try  (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Mikunakano123")) {
            String query = "SELECT * FROM users WHERE name = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
