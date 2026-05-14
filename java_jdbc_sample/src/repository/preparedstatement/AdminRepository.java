package repository.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.AdminDTO;
import util.DbConnectUtil;

public class AdminRepository {

	public static void main(String[] args) throws SQLException {

		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminName("Jennifer");
		adminDTO.setAdminCode("JNF011");
		adminDTO.setAdminAddress("Awantha Kingdom");
		adminDTO.setAdminEmail("jenni444@gmail.com");
		adminDTO.setAdminPhone("+1-234-4567-890");
		adminDTO.setAdminSalary(53000);

		AdminRepository adminRepo = new AdminRepository();
		adminDTO = adminRepo.addAdmin(adminDTO);
		System.out.println("Admin added successfully" + adminDTO);

		AdminDTO adto = adminRepo.getAdminById(0);
		System.out.println("Admin Detail " + adto);
	}

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private AdminDTO addAdmin(AdminDTO adminDTO) throws SQLException {
		AdminDTO savedAdmin = null;
		String insertQ = "INSERT INTO admin_detail(admin_name, admin_code, admin_address, admin_email, admin_phone, admin_salary)VALUES(?,?,?,?,?,?)";
		try {
			conn = DbConnectUtil.getConnection();
			pstmt = conn.prepareStatement(insertQ, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, adminDTO.getAdminName());
			pstmt.setString(2, adminDTO.getAdminCode());
			pstmt.setString(3, adminDTO.getAdminAddress());
			pstmt.setString(4, adminDTO.getAdminEmail());
			pstmt.setString(5, adminDTO.getAdminPhone());
			pstmt.setLong(6, adminDTO.getAdminSalary());

			int rowAffect = pstmt.executeUpdate();
			if (rowAffect > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int adminId = rs.getInt(1);
					savedAdmin = getAdminById(adminId);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			conn.close();
		}
		System.out.println("Record inserted successfully " + savedAdmin);
		return savedAdmin;
	}

	private AdminDTO getAdminById(int adminId) throws SQLException {
		AdminDTO admindto = new AdminDTO();
		String selectQ = "SELECT admin_id, admin_name, admin_code, admin_address, admin_email, admin_phone, admin_salary, is_deleted "
				+ "FROM admin_detail WHERE admin_id = ? AND is_deleted = 'N'";
		try {
			pstmt = DbConnectUtil.getConnection().prepareStatement(selectQ);
			pstmt.setInt(1, adminId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("admin_id"));
				System.out.println(rs.getString("admin_name"));
				System.out.println(rs.getString("admin_code"));
				System.out.println(rs.getString("admin_address"));
				System.out.println(rs.getString("admin_email"));
				System.out.println(rs.getString("admin_phone"));
				System.out.println(rs.getLong("admin_salary"));
				System.out.println(rs.getString("is_deleted"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			rs.close();
			DbConnectUtil.closeConnection(conn);
		}
		return admindto;
	}

}
