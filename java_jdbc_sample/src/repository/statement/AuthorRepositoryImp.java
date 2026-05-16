package repository.statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.AuthorDTO;
import util.DbConnectUtil;

public class AuthorRepositoryImp extends AuthorRepositry {

	public static Connection con;

	public AuthorDTO addAuthor(AuthorDTO authordto) {
		try {
			con = DbConnectUtil.getConnection();
			String insertQuery = "INSERT INTO author_detail(author_name, author_code, author_address, author_dob, author_email, author_education, author_university)"
					+ "VALUES(?,?,?,?,?,?,?)";
			System.out.println("Insert Query: " + insertQuery);

			PreparedStatement prest = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			prest.setString(1, authordto.getAuthorName());
			prest.setString(2, authordto.getAuthorCode());
			prest.setString(3, authordto.getAuthorAddress());
			prest.setDate(4, (Date) authordto.getAuthorDob());
			prest.setString(5, authordto.getAuthorEmail());
			prest.setString(6, authordto.getAuthorEducation());
			prest.setString(7, authordto.getAuthorUniversity());

			int rowaffect = prest.executeUpdate();
			System.out.println("Row Affected: " + rowaffect);

			if (rowaffect > 0) {
				ResultSet set = prest.getGeneratedKeys();
				if (set.next()) {
					int generateAuthorId = set.getInt(1);
					authordto.setAuthorId(generateAuthorId);
					authordto.setIsDeleted("N");

					return getAuthorById(generateAuthorId);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return authordto;
	}

	public AuthorDTO updateAuthor(AuthorDTO authordto) {
		try {
			con = DbConnectUtil.getConnection();
			String updateQuery = "UPDATE author_detail SET author_name = '" + authordto.getAuthorName()
					+ "', author_code = '" + authordto.getAuthorCode() + "', author_address = '"
					+ authordto.getAuthorAddress() + "', author_dob = '" + authordto.getAuthorDob()
					+ "', author_email = '" + authordto.getAuthorEmail() + "', author_education = '"
					+ authordto.getAuthorEducation() + "', author_university = '" + authordto.getAuthorUniversity()
					+ "', WHERE is_deleted = " + authordto.getAuthorId() + ",AND is_deleted = 'N'";
			System.out.println("updateQuery: " + updateQuery);

			Statement st = con.createStatement();
			int rowAffected = st.executeUpdate(updateQuery);
			System.out.println("Rows Affected: " + rowAffected);

			if (rowAffected > 0) {
				return getAuthorById(authordto.getAuthorId());
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
	}

	public String deleteAuthor(int authorId) {
		try {
			con = DbConnectUtil.getConnection();
			String updatesql = "UPDATE author_detail SET is_deleted = 'Y' WHERE author_id = " + authorId;
			System.out.println("Update Sql: " + updatesql);

			Statement st = con.createStatement();
			int rowAffected = st.executeUpdate(updatesql);
			System.out.println("Rows Affected: " + rowAffected);

			if (rowAffected > 0) {
				return "Author with Id " + authorId + " has been soft deleted successfully";
			} else {
				return "Author with Id " + authorId + " not found or already deleted";
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
	}

	public List<AuthorDTO> getAllAuthor() {
		List<AuthorDTO> authorlist = new ArrayList<>();

		try {
			con = DbConnectUtil.getConnection();
			String selectQuery = "SELECT author_id, author_name, author_code, author_address, author_dob, author_email, author_education, author_university, is_deleted FROM author_detail WHERE is_deleted = 'N'";
			System.out.println("Select Query: " + selectQuery);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			System.out.println("Result Set: " + rs);

			while (rs.next()) {
				AuthorDTO adto = new AuthorDTO();
				adto.setAuthorId(rs.getInt("authro_id"));
				adto.setAuthorName(rs.getString("author_name"));
				adto.setAuthorCode(rs.getString("author_code"));
				adto.setAuthorAddress(rs.getString("author_address"));
				adto.setAuthorDob(rs.getDate("author_dob"));
				adto.setAuthorEmail(rs.getString("author_email"));
				adto.setAuthorEducation(rs.getString("author_education"));
				adto.setAuthorUniversity(rs.getString("author_university"));
				adto.setIsDeleted(rs.getString("is_deleted"));
				authorlist.add(adto);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return authorlist;
	}

	public AuthorDTO getAuthorById(int authorId) {
		AuthorDTO adto = new AuthorDTO();
		try {
			con = DbConnectUtil.getConnection();
			String selectById = "SELECT author_id, author_name, author_code, author_address, author_dob, author_email, author_education, author_university, is_deleted FROM author_detail WHERE author_id ="
					+ authorId + "and is_deleted = 'N'";
			System.out.println("Select Query: " + selectById);

			Statement st = con.prepareStatement(selectById);
			ResultSet rs = st.executeQuery(selectById);
			System.out.println("Result Set: " + rs);

			while (rs.next()) {
				adto.setAuthorId(rs.getInt("author_id"));
				adto.setAuthorName(rs.getString("author_name"));
				adto.setAuthorCode(rs.getString("author_code"));
				adto.setAuthorAddress(rs.getString("author_address"));
				adto.setAuthorDob(rs.getDate("author_dob"));
				adto.setAuthorEmail(rs.getString("author_email"));
				adto.setAuthorEducation(rs.getString("author_education"));
				adto.setAuthorUniversity(rs.getString("author_university"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return adto;
	}

	public AuthorDTO getAuthoByCode(String authorCode) {
		AuthorDTO adto = new AuthorDTO();
		try {
			con = DbConnectUtil.getConnection();
			String selectByCode = "SELECT author_id, author_name, author_code, author_address, author_dob, author_email, author_education, author_university, is_deleted "
					+ "FROM author_detail WHERE author_code =" + authorCode + "AND is_deleted = 'N'";
			System.out.println("Select Query: " + selectByCode);

			Statement st = con.prepareStatement(selectByCode);
			ResultSet rs = st.executeQuery(selectByCode);
			System.out.println("Result Set: " + rs);

			while (rs.next()) {
				adto.setAuthorId(rs.getInt("author_id"));
				adto.setAuthorName(rs.getString("author_name"));
				adto.setAuthorCode(rs.getString("author_code"));
				adto.setAuthorAddress(rs.getString("author_address"));
				adto.setAuthorDob(rs.getDate("author_dob"));
				adto.setAuthorEmail(rs.getString("author_email"));
				adto.setAuthorEducation(rs.getString("author_education"));
				adto.setAuthorUniversity(rs.getString("author_university"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return adto;
	}

	public List<AuthorDTO> searchAuthor(String authorName, String authorCode, String authorAddress) {
		List<AuthorDTO> alist = new ArrayList<>();
		try {
			con = DbConnectUtil.getConnection();
			StringBuilder sb = new StringBuilder(
					"SELECT author_id, author_name, author_code, author_address, author_dob, author_email, author_education, author_university, is_deleted FROM author_detail WHERE is_deleted = 'N'");
			List<Object> parameter = new ArrayList<>();

			if (authorName != null && !authorName.trim().isEmpty()) {
				sb.append("AND author_name LIKE ?");
				parameter.add("%" + authorName + "%");
			}

			if (authorCode != null && !authorCode.trim().isEmpty()) {
				sb.append("AND author_code LIKE ?");
				parameter.add("%" + authorCode + "%");
			}

			if (authorAddress != null && !authorAddress.trim().isEmpty()) {
				sb.append("AND author_address LIKE");
				parameter.add("%" + authorAddress + "%");

				String select = sb.toString();
				System.out.println("Select: " + select);

				PreparedStatement pst = con.prepareStatement(select);
				for (int i = 0; i < parameter.size(); i++) {
					pst.setString(i + 1, parameter.get(i).toString());
				}
				ResultSet rs = pst.executeQuery();
				System.out.println("Result Set: " + rs);

				while (rs.next()) {
					AuthorDTO dto = new AuthorDTO();
					dto.setAuthorId(rs.getInt("author_id"));
					dto.setAuthorName(rs.getString("author_name"));
					dto.setAuthorCode(rs.getString("author_code"));
					dto.setAuthorAddress(rs.getString("author_address"));
					dto.setAuthorDob(rs.getDate("author_dob"));
					dto.setAuthorEmail(rs.getString("author_eamil"));
					dto.setAuthorEducation(rs.getString("author_education"));
					dto.setAuthorUniversity(rs.getString("author_university"));
					dto.setIsDeleted(rs.getString("is_deleted"));
					alist.add(dto);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbConnectUtil.closeConnection(con);
		}
		return alist;
	}
}
