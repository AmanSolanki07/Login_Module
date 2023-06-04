import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private Connection connection;

	public LoginDAO() {
		// Obtain a database connection
		connection = YourDatabaseConnectionManager.getConnection();
	}

	public boolean validateUser(LoginData loginData) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			// Prepare the SQL statement
			String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, loginData.getUsername());
			statement.setString(2, loginData.getPassword());

			// Execute the SQL statement
			resultSet = statement.executeQuery();

			// Check if a matching user was found
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			// Close the result set, statement, and connection
			try {
				if (resultSet != null) {
					resultSet.close();
				}
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
