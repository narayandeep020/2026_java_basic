package librarydata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookData {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/library_management_db";
		String username = "$$$$$$";
		String password = "$$$$$$$";

		String query = "select * from book_detail";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			int id = rs.getInt("book_id");
			String title = rs.getString("book_title");
			String isbn = rs.getString("isbn");
			int aid = rs.getInt("author_id");
			int pid = rs.getInt("publisher_id");
			Date date = rs.getDate("publication_date");
			float price = rs.getFloat("price");
			String genre = rs.getString("genre");
			int pages = rs.getInt("pages");
			String lang = rs.getString("language");
			int adminid = rs.getInt("created_by_admin");
			int upid = rs.getInt("updated_by_admin");
			Date cdate = rs.getDate("created_date");
			Date udate = rs.getDate("updated_date");
			String dlt = rs.getString("is_deleted");

			System.out.println(
					id + " " + title + " " + isbn + " " + aid + " " + pid + " " + date + " " + price + " " + genre + " "
							+ pages + " " + lang + " " + adminid + " " + upid + " " + cdate + " " + udate + " " + dlt);
			System.out.println();
		}
	}

}
