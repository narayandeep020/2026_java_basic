package librarydata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AuthorData {
	public static void main(String[] args) {
		// Database connection details
		String jdbcURL = "jdbc:mysql://localhost:3306/library_management_db"; // replace 'library' with your DB name
		String username = "******"; // replace with your DB username
		String password = "********"; // replace with your DB password

		// SQL query to read details
		String query = "select * from author_detail";

		try {
			// Step 1: Load JDBC driver (optional for newer versions)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Establish connection
			Connection con = DriverManager.getConnection(jdbcURL, username, password);

			// Step 3: Create statement
			Statement statement = con.createStatement();

			// Step 4: Execute query
			ResultSet rs = statement.executeQuery(query);

			// Step 5: Process results
			while (rs.next()) {
				int Id = rs.getInt("author_id");
				String Name = rs.getString("author_name");
				String Code = rs.getString("author_code");
				String Address = rs.getString("author_address");
				Date Dob = rs.getDate("author_dob");
				String Email = rs.getString("author_email");
				String Education = rs.getString("author_education");
				String University = rs.getString("author_university");
				String is_deleted = rs.getString("is_deleted");

				System.out.println(Id + " " + Name + " " + Code + " " + Address + " " + Dob + " " + Email + " "
						+ Education + " " + University + " " + is_deleted);
				System.out.println();
			}

			// Step 6: Close resources
			rs.close();
			statement.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
