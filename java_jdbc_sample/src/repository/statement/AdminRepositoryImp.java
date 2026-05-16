package repository.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.AdminDTO;
import util.DbConnectUtil;

public class AdminRepositoryImp extends AdminRepositry {

	public static Connection con;

	public AdminDTO addAdmin(AdminDTO admindto) {
		try {
			con = DbConnectUtil.getConnection();
			String insertsql = "INSERT INTO admin_detail(admin_name, admin_code, admin_address, admin_email, admin_phone, admin_salary, is_deleted)"
					+ "VALUES(?, ?, ?, ?, ?, ?, 'N')";
			System.out.println("insertsql: " + insertsql);

			PreparedStatement pres = con.prepareStatement(insertsql, Statement.RETURN_GENERATED_KEYS);
			pres.setString(1, admindto.getAdminName());
			pres.setString(2, admindto.getAdminCode());
			pres.setString(3, admindto.getAdminAddress());
			pres.setString(4, admindto.getAdminEmail());
			pres.setString(5, admindto.getAdminPhone());
			pres.setLong(6, admindto.getAdminSalary());

			int rowAffected = pres.executeUpdate();
			System.out.println("Row Affected: " + rowAffected);

			if (rowAffected > 0) {
				ResultSet result = pres.getGeneratedKeys();
				if (result.next()) {
					int generatedAdminid = result.getInt(1);
					admindto.setAdminId(generatedAdminid);
					admindto.setIsDeleted("N");

					return getAdminById(generatedAdminid);
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
	}

	public AdminDTO updateAdmin(AdminDTO admindto) {
		try {
			con = DbConnectUtil.getConnection();
			String updateQuery = "UPDATE admin_detail SET admin_name = '" + admindto.getAdminName() + "',admin_code = '"
					+ admindto.getAdminCode() + "', admin_address = '" + admindto.getAdminAddress()
					+ "', admin_email = '" + admindto.getAdminEmail() + "', admin_phone = '" + admindto.getAdminPhone()
					+ "', admin_salary = " + admindto.getAdminSalary() + ", WHERE admin_id = " + admindto.getAdminId()
					+ ", AND is_deleted = 'N'";
			System.out.println("UdateQuery: " + updateQuery);

			Statement st = con.createStatement();
			int rowAffected = st.executeUpdate(updateQuery);
			System.out.println("Rows affected: " + rowAffected);

			if (rowAffected > 0) {
				return getAdminById(admindto.getAdminId());
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
	}

	public String deleteAdmin(int adminId) {
		try {
			con = DbConnectUtil.getConnection();
			String updateQuery = "UPDATE admin_detail SET is_deleted = 'Y' WHERE admin_id = " + adminId;
			System.out.println("Updated Query: " + updateQuery);

			Statement st = con.createStatement();
			int rowAffected = st.executeUpdate(updateQuery);
			System.out.println("Rows Affected: " + rowAffected);

			if (rowAffected > 0) {
				return "Admin With Id " + adminId + " has been soft deleted successfully";
			} else {
				return "Admin With Id " + adminId + " not found or already deleted";
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
	}

	public List<AdminDTO> getAllAdmin() {
		List<AdminDTO> adminlist = new ArrayList<>();

		try {
			con = DbConnectUtil.getConnection();
			String selectQuery = "SELECT admin_id, admin_name, admin_code, admin_address, admin_email, admin_phone, admin_salary, is_deleted FROM admin_detail WHERE is_deleted = 'N'";
			System.out.println("Select Query: " + selectQuery);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(selectQuery);
			System.out.println("ResultSet: " + rs);

			while (rs.next()) {
				AdminDTO adm = new AdminDTO();
				adm.setAdminId(rs.getInt("admin_id"));
				adm.setAdminName(rs.getString("admin_name"));
				adm.setAdminCode(rs.getString("admin_code"));
				adm.setAdminAddress(rs.getString("admin_address"));
				adm.setAdminEmail(rs.getString("admin_email"));
				adm.setAdminPhone(rs.getString("admin_phone"));
				adm.setAdminSalary(rs.getLong("admin_salary"));
				adm.setIsDeleted(rs.getString("is_deleted"));
				adminlist.add(adm);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return adminlist;
	}

	public AdminDTO getAdminById(int adminId) {
		AdminDTO admindto = new AdminDTO();
		try {
			con = DbConnectUtil.getConnection();
			String selectById = "SELECT admin_id, admin_name, admin_code, admin_address, admin_email, admin_phone, admin_salary, is_deleted FROM admin_detail WHERE admin_id ="
					+ adminId + "and is_deleted = 'N'";
			System.out.println("Select Query: " + selectById);
			
			Statement st = con.prepareStatement(selectById);
			ResultSet rs = st.executeQuery(selectById);
			System.out.println("Result Set: " + rs);

			while (rs.next()) {
				admindto.setAdminId(rs.getInt("admin_id"));
				admindto.setAdminName(rs.getString("admin_name"));
				admindto.setAdminCode(rs.getString("admin_code"));
				admindto.setAdminAddress(rs.getString("admin_address"));
				admindto.setAdminEmail(rs.getString("admin_email"));
				admindto.setAdminPhone(rs.getString("admin_phone"));
				admindto.setAdminSalary(rs.getLong("admin_salary"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return admindto;
	}

	public AdminDTO getAdminByCode(String adminCode) {
		AdminDTO admindto = new AdminDTO();
		try {
			con = DbConnectUtil.getConnection();
			String selectByCode = "SELECT admin_id, admin_name, admin_code, admin_address, admin_email, admin_phone, admin_salary, is_deleted FROM admin_detail WHERE admin_code ="
					+ adminCode + "and is_deleted = 'N'";
			System.out.println("Seletc Query: " + selectByCode);

			Statement st = con.prepareStatement(selectByCode);
			ResultSet rs = st.executeQuery(selectByCode);
			System.out.println("Result Set: " + rs);

			while (rs.next()) {
				admindto.setAdminId(rs.getInt("admin_id"));
				admindto.setAdminName(rs.getString("admin_name"));
				admindto.setAdminCode(rs.getString("admin_code"));
				admindto.setAdminAddress(rs.getString("admin_address"));
				admindto.setAdminEmail(rs.getString("admin_email"));
				admindto.setAdminPhone(rs.getString("admin_phone"));
				admindto.setAdminSalary(rs.getLong("admin_salary"));
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return admindto;
	}

	public List<AdminDTO> searchAdmin(String adminName, String adminCode, String adminAddress) {
		List<AdminDTO> adminlist = new ArrayList<>();
		try {
			con = DbConnectUtil.getConnection();

			StringBuilder queryBuilder = new StringBuilder(
					"SELECT admin_id, admin_name, admin_code, admin_address, admin_email, admin_phone, admin_salary, is_deleted FROM admin_detail WHERE is_deleted = 'N'");
			List<Object> parameter = new ArrayList<>();

			if (adminName != null && !adminName.trim().isEmpty()) {
				queryBuilder.append("AND admin_name LIKE ?");
				parameter.add("%" + adminName.trim() + "%");
			}

			if (adminCode != null && !adminCode.trim().isEmpty()) {
				queryBuilder.append("AND admin_code LIKE ?");
				parameter.add("%" + adminCode.trim() + "%");
			}

			if (adminAddress != null && !adminAddress.trim().isEmpty()) {
				queryBuilder.append("AND admin_address LIKE ?");
				parameter.add("%" + adminAddress.trim() + "%");
			}
			String select = queryBuilder.toString();
			System.out.println("Select: " + select);

			PreparedStatement pst = con.prepareStatement(select);
			for (int i = 0; i < parameter.size(); i++) {
				pst.setString(i + 1, parameter.get(i).toString());
			}
			ResultSet result = pst.executeQuery();
			System.out.println("ResultSet: " + result);

			while (result.next()) {
				AdminDTO admindto = new AdminDTO();
				admindto.setAdminId(result.getInt("admin_id"));
				admindto.setAdminName(result.getString("admin_name"));
				admindto.setAdminCode(result.getString("admin_code"));
				admindto.setAdminAddress(result.getString("admin_address"));
				admindto.setAdminEmail(result.getString("admin_email"));
				admindto.setAdminPhone(result.getString("admin_phone"));
				admindto.setAdminSalary(result.getLong("admin_salary"));
				admindto.setIsDeleted(result.getString("is_deleted"));
				adminlist.add(admindto);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return adminlist;
	}
}
