import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO {

	public boolean registerUser(RegistrationData registrationData) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// Obtain a database connection
			connection = YourDatabaseConnectionManager.getConnection();
			// Prepare the SQL statement
			String sql = "INSERT INTO users (username, password, id, email) VALUES (?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, registrationData.getUsername());
			statement.setString(2, registrationData.getPassword());
			statement.setString(3, registrationData.getId());
			statement.setString(4, registrationData.getEmail());

			// Execute the SQL statement
			int rowsAffected = statement.executeUpdate();

			// Check if the registration was successful
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			// Close the statement and connection
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
