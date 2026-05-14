package librarydata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentData {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/library_management_db";
		String username = "@@@@@@@@@";
		String password = "@@@@@@";

		String query = "select * from student_detail";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			int id = rs.getInt("student_id");
			String name = rs.getString("student_name");
			String code = rs.getString("student_code");
			String address = rs.getString("student_address");
			String email = rs.getString("student_email");
			String phone = rs.getString("student_phone");
			int credit = rs.getInt("student_credit");
			int bid = rs.getInt("book_id");
			int aid = rs.getInt("created_by_admin");
			int uid = rs.getInt("updated_by_admin");
			Date cdate = rs.getDate("created_date");
			Date udate = rs.getDate("updated_date");
			String dlt = rs.getString("is_deleted");

			System.out.println(id + " " + name + " " + code + " " + address + " " + email + " " + phone + " " + credit
					+ " " + bid + " " + aid + " " + uid + " " + cdate + " " + udate + " " + dlt);
			System.out.println();
		}
	}

}
