package propertiesdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBConnectUsingRB {

	public static Connection getConn() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		ResourceBundle rb = ResourceBundle.getBundle("system");

		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("user");
		String password = rb.getString("pass");

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();

			rs = st.executeQuery("select * from student_details");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "    " + rs.getString(2) + "    " + rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {
		
		DBConnectUsingRB.getConn();
	}

}


