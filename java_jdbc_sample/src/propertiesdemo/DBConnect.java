package propertiesdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	public static Connection getConn() throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		String loadDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/library_db";
		String user = "******";
		String pass = "@@@@@@@";

		try {
			Class.forName(loadDriver);
			conn = DriverManager.getConnection(url, user, pass);
			st = conn.createStatement();

			rs = st.executeQuery("select * from student_details");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "    " + rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			conn.close();
		}
		return conn;
	}

	public static void main(String[] args) throws SQLException {

		DBConnect.getConn();
	}

}
