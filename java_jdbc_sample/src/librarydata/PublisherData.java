package librarydata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PublisherData {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/library_management_db";
		String username = "#######";
		String password = "#######";

		String query = "select * from publisher_detail";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			int id = rs.getInt("publisher_id");
			String name = rs.getString("publisher_name");
			String code = rs.getString("publisher_code");
			String address = rs.getString("publisher_address");
			String email = rs.getString("publisher_email");
			String phone = rs.getString("publisher_phone");
			int cadmin = rs.getInt("created_by_admin");
			int uadmin = rs.getInt("updated_by_admin");
			Date cdate = rs.getDate("created_date");
			Date udate = rs.getDate("updated_date");
			String dlt = rs.getString("is_deleted");

			System.out.println(id + " " + name + " " + code + " " + address + " " + email + " " + phone + " " + cadmin
					+ " " + uadmin + " " + cdate + " " + udate + " " + dlt);
			System.out.println();
		}
	}

}
