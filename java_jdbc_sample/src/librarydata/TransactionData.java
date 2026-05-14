package librarydata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionData {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/library_management_db";
		String username = "#####";
		String password = "@@@@@@@@@";

		String query = "select * from book_issue_transactions";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			int issueid = rs.getInt("book_issue_id");
			int bid = rs.getInt("book_id");
			int sid = rs.getInt("student_id");
			int aid = rs.getInt("issued_by_admin");
			Date idate = rs.getDate("issue_date");
			Date duedate = rs.getDate("due_date");
			Date rdate = rs.getDate("return_date");
			float amount = rs.getFloat("fine_amount");
			String status = rs.getString("issue_status");

			System.out.println(issueid + " " + bid + " " + sid + " " + aid + " " + idate + " " + duedate + " " + rdate
					+ " " + amount + " " + status);
			System.out.println();
		}
	}

}
