package repository.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.AdminDTO;

public class AdminRepositry {

	public static void main(String[] args) throws SQLException {

		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminName("Alexx Lamma");
		adminDTO.setAdminAddress("California");
		adminDTO.setAdminEmail("alexcali123@gmail.com");
		adminDTO.setAdminCode("ADM0010");

		AdminRepositry adminR = new AdminRepositry();
		AdminDTO savedAdminDTO = adminR.addAdmin(adminDTO);
		System.out.println("Saved Admin: " + savedAdminDTO);
	}

	public AdminDTO addAdmin(AdminDTO adminD) throws SQLException {
		Connection con = null;
		Statement st = null;
		AdminDTO savedAD1 = new AdminDTO();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_db", "******", "*******");
			st = con.createStatement();
			String insertQuery = "insert into admin_detail(admin_name, admin_address, admin_email, admin_code) values ('"
					+ adminD.getAdminName() + "','" + adminD.getAdminAddress() + "','" + adminD.getAdminEmail() + "','"
					+ adminD.getAdminCode() + "')";

			int rowInserted = st.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

			if (rowInserted > 0) {
				ResultSet generatedKey = st.getGeneratedKeys();
				System.out.println("Record inserted successfully");
				if (generatedKey.next()) {
					adminD.setAdminId(generatedKey.getInt(1));
					savedAD1 = getAdminById(adminD.getAdminId());
				}
			} else {
				System.out.println("Failed to insert record");
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			st.close();
			con.close();
		}
		return savedAD1;
	}

	public AdminDTO getAdminById(int adminId) throws SQLException {
		AdminDTO adminD11 = new AdminDTO();
		Connection con = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_db", "root", "Root@123");
			st = con.createStatement();
			String fetchQuery = "select admin_id, admin_name, admin_code, admin_address, admin_email from admin_detail";
			ResultSet result = st.executeQuery(fetchQuery);

			while (result.next()) {
				adminD11.setAdminId(result.getInt("admin_id"));
				adminD11.setAdminName(result.getString("admin_name"));
				adminD11.setAdminCode(result.getString("admin_code"));
				adminD11.setAdminAddress(result.getString("admin_address"));
				adminD11.setAdminEmail(result.getString("admin_email"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			st.close();
			con.close();
		}
		return adminD11;
	}

}
