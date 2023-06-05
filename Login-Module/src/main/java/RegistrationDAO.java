import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Mikunakano123";

	public boolean registerUser(User user) {
		try {
			try {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			    e.printStackTrace();
			}

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "Mikunakano123");
			String query = "INSERT INTO users (name, id_number, email, password) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getId());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			int rowsAffected = preparedStatement.executeUpdate();
			conn.close();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
