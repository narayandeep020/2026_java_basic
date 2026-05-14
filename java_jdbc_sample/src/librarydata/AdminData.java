package librarydata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminData {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/library_management_db";
		String username = "######";
		String password = "########";
		
		String query = "select * from admin_detail";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("admin_id");
			String name = rs.getString("admin_name");
			String code = rs.getString("admin_code");
			String address = rs.getString("admin_address");
			String email = rs.getString("admin_email");
			String phone = rs.getString("admin_phone");
			long sal = rs.getLong("admin_salary");
			String is_deleted = rs.getString("is_deleted");
			
			System.out.println(id+" "+name+" "+code+" "+address+" "+email+" "+phone+" "+sal+" "+is_deleted);
			System.out.println();
		}
	}

}
