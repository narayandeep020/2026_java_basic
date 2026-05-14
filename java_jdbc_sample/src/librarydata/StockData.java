package librarydata;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StockData {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/library_management_db";
		String user = "OOOOOO";
		String pass = "OOOOO";

		String query = "select * from library_stock_detail";
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			int sid = rs.getInt("stock_id");
			int bid = rs.getInt("book_id");
			int count = rs.getInt("stock_count");
			Date cdate = rs.getDate("created_date");
			Date udate = rs.getDate("updated_date");
			int aid = rs.getInt("created_by_admin");
			int aid2 = rs.getInt("updated_by_admin");
			String delete = rs.getString("is_deleted");

			System.out.println(
					sid + " " + bid + " " + count + " " + cdate + " " + udate + " " + aid + " " + aid2 + " " + delete);
			System.out.println();
		}
	}

}
