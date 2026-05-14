package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dto.AdminDTO;

import java.sql.CallableStatement;

import util.AppConstants;
import util.DbConnectUtil;

public class AdminDao {

	private Connection conn;
	private CallableStatement cstmt;
	private ResultSet rs;

	public static class ProcedureResult {
		private int count;

		public ProcedureResult(int count) {
			this.count = count; 
		}

		public int getCount() {
			return count;
		}

//		public String toString() {
//			return count + " ";
//		}
	}

	public ProcedureResult callAdminCrudProcedure(int adminId, String adminName, String adminCode, String adminAddress,
			String adminEmail, String adminPhone, long adminSalary, String isDeleted, String opeationType) {
		conn = null;
		cstmt = null;

		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_admin_detail(?,?,?,?,?,?,?,?,?,?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, adminId);

			cstmt.setString(2, adminName);
			cstmt.setString(3, adminCode);
			cstmt.setString(4, adminAddress);
			cstmt.setString(5, adminEmail);
			cstmt.setString(6, adminPhone);
			cstmt.setLong(7, adminSalary);

			cstmt.setString(8, isDeleted);
			cstmt.setString(9, opeationType);

			cstmt.registerOutParameter(10, Types.INTEGER);
//			cstmt.registerOutParameter(11, Types.VARCHAR);

			cstmt.execute();
			int count1 = cstmt.getInt(10);

			return new ProcedureResult(count1);

		} catch (Exception e) {
			System.err.println("Error calling proc_admin_detail: " + e.getMessage());
			e.printStackTrace();
			return new ProcedureResult(-1);
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing CallableStatement:" + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);

		}

	}

	public AdminDTO getAdminById(int adminId) {
		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_admin_detail(?, null, null, null, null, null, 0, null, ?, ?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, adminId);
			cstmt.setString(2, AppConstants.READ);
			cstmt.registerOutParameter(3, Types.INTEGER);
			rs = cstmt.executeQuery();
			
			AdminDTO admin = null;
			if (rs.next()) {
				admin = new AdminDTO(rs.getInt("admin_id"), rs.getString("admin_name"), rs.getString("admin_code"),
						rs.getString("admin_address"), rs.getString("admin_email"), rs.getString("admin_phone"),
						rs.getLong("admin_salary"), AppConstants.NOT_DELETED);
			}
			return admin;
		} catch (Exception e) {
			System.err.println("Error getting admin by Id: " + e.getMessage());
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public List<AdminDTO> getAllAdmins() {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_admin_detail(0, null, null, null, null, null, 0, null, ?, ?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setString(1, AppConstants.READ_ALL);
			cstmt.setInt(2, Types.INTEGER);

			rs = cstmt.executeQuery();

			List<AdminDTO> admins = new ArrayList<>();
			while (rs.next()) {
				AdminDTO admin = new AdminDTO(rs.getInt("admin_id"), rs.getString("admin_name"),
						rs.getString("admin_code"), rs.getString("admin_address"), rs.getString("admin_email"),
						rs.getString("admin_phone"), rs.getLong("admin_salary"), AppConstants.NOT_DELETED);
				admins.add(admin);
			}
			return admins;
		} catch (Exception e) {
			System.err.println("Error getting all admins: " + e.getMessage());
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing resource: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public ProcedureResult createAdmin(AdminDTO admin) {

		return callAdminCrudProcedure(admin.getAdminId(), admin.getAdminName(), admin.getAdminCode(),
				admin.getAdminAddress(), admin.getAdminEmail(), admin.getAdminPhone(), admin.getAdminSalary(),
				AppConstants.NOT_DELETED, AppConstants.INSERT);
	}

	public ProcedureResult updateAdmin(AdminDTO admin) {
		return callAdminCrudProcedure(admin.getAdminId(), admin.getAdminName(), admin.getAdminCode(),
				admin.getAdminAddress(), admin.getAdminEmail(), admin.getAdminPhone(), admin.getAdminSalary(),
				AppConstants.NOT_DELETED, AppConstants.UPDATE);
	}

	public ProcedureResult deleteAdmin(int  adminId) {
		return callAdminCrudProcedure(adminId, null, null, null, null, null, 0, AppConstants.SOFT_DELETED,
				AppConstants.DELETE);
	}

	public List<AdminDTO> searchAdmins(String adminName, String adminCode) throws Exception {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_admin_detail(0, ?, ?, null, null, null, null, 0, ?, ?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setString(1, adminName);
			cstmt.setString(2, adminCode);
			cstmt.setString(3, AppConstants.SEARCH);
			cstmt.registerOutParameter(4, Types.INTEGER);

			rs = cstmt.executeQuery();
			List<AdminDTO> admins = new ArrayList<>();

			while (rs.next()) {
				AdminDTO admin = new AdminDTO(rs.getInt("admin_id"), rs.getString("admin_name"),
						rs.getString("admin_code"), rs.getString("admin_address"), rs.getString("admin_email"),
						rs.getString("admin_phone"), rs.getLong("admin_salary"), AppConstants.NOT_DELETED);
				admins.add(admin);
			}
			return admins;

		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Error searching admins: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.err.println("Error closing resources: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public static void main(String[] args) throws Exception {

		AdminDao adminDao = new AdminDao();

		AdminDTO newAdmin = new AdminDTO();
		newAdmin.setAdminName("Rivank Lodhi");
		newAdmin.setAdminCode("ADM014");
		newAdmin.setAdminAddress("123 Main St");
		newAdmin.setAdminEmail("john@example.com");
		newAdmin.setAdminPhone("555-1234");
		newAdmin.setAdminSalary(60000);

//		ProcedureResult createResult = adminDao.createAdmin(newAdmin);
//		System.out.println("Create Result: " + createResult);

		List<AdminDTO> allAdmins = adminDao.getAllAdmins();
		System.out.println("All Admins: " + allAdmins.size());
		allAdmins.forEach(System.out::println);

		List<AdminDTO> searchAdmin = adminDao.searchAdmins("Rivank", "ADM0010");
		System.out.println("Search Results: " + searchAdmin);
		searchAdmin.forEach(System.out::println);

//		AdminDTO admin = adminDao.getAdminById(4017);
//		if (admin != null) {
//			System.out.println("Found Admin: " + admin);
//
//			admin.setAdminSalary(44000);
//			admin.setAdminPhone("+1-999-99-888");
//			admin.setAdminName("Rudransh");
//			admin.setAdminCode("RUD001");
//			admin.setAdminEmail("rd12345@gmail.com");
//			ProcedureResult updateResult = adminDao.updateAdmin(admin);
//			System.out.println("Updated Result: " + updateResult);
//		}
		ProcedureResult deleteResult = adminDao.deleteAdmin(4011);
		System.out.println("Delete Result: " + deleteResult);
	}

}
