package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.AuthorDTO;
import util.AppConstants;
import util.DateUtility;
import util.DbConnectUtil;

public class AuthorDao {
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

		public String toString() {
			return count + " ";
		}
	}

	public ProcedureResult callAuthorCrudProcedure(int authorId, String authorName, String authorCode,
			String authorAddress, Date authorDob, String authorEmail, String authorEducation, String authorUniversity,
			String isDeleted, String operationType) {

		conn = null;
		cstmt = null;
		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_author_detail(?,?,?,?,?,?,?,?,?,?,?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, authorId);
			cstmt.setString(2, authorName);
			cstmt.setString(3, authorCode);
			cstmt.setString(4, authorAddress);
			cstmt.setDate(5, DateUtility.convertUtilToSqlDate(authorDob));
			cstmt.setString(6, authorEmail);
			cstmt.setString(7, authorEducation);
			cstmt.setString(8, authorUniversity);
			cstmt.setString(9, isDeleted);
			cstmt.setString(10, operationType);
			cstmt.registerOutParameter(11, Types.INTEGER);

			cstmt.execute();
			int out = cstmt.getInt(11);
			return new ProcedureResult(out);

		} catch (Exception e) {
			System.out.println("Error calling proc_author_detail: " + e.getMessage());
			e.printStackTrace();
			return new ProcedureResult(-1);
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing callable statement: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public AuthorDTO getAuthorById(int adminId) {
		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_author_detail(?, null, null, null, null, null, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, adminId);
			cstmt.setString(2, AppConstants.READ);
			cstmt.registerOutParameter(3, Types.INTEGER);
			rs = cstmt.executeQuery();

			AuthorDTO author = null;
			if (rs.next()) {
				author = new AuthorDTO(rs.getInt("author_id"), rs.getString("author_name"), rs.getString("author_code"),
						rs.getString("author_address"), rs.getDate("author_dob"), rs.getString("author_email"),
						rs.getString("author_education"), rs.getString("author_university"), AppConstants.NOT_DELETED);
			}
			return author;
		} catch (Exception e) {
			System.err.println("Error getting author by id: " + e.getMessage());
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing resource:" + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public List<AuthorDTO> getAllAuthor() {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			conn = DbConnectUtil.getConnection();
			String getQuery = "{call proc_author_detail(0, null, null, null, null, null, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(getQuery);

			cstmt.setString(1, AppConstants.READ_ALL);
			cstmt.setInt(2, Types.INTEGER);
			rs = cstmt.executeQuery();

			List<AuthorDTO> authors = new ArrayList<>();
			while (rs.next()) {
				AuthorDTO author = new AuthorDTO(rs.getInt("author_id"), rs.getString("author_name"),
						rs.getString("author_code"), rs.getString("author_address"), rs.getDate("author_dob"),
						rs.getString("author_email"), rs.getString("author_education"),
						rs.getString("author_university"), AppConstants.NOT_DELETED);
				authors.add(author);
			}
			return authors;
		} catch (Exception e) {
			System.err.println("Error getting all authors: " + e.getMessage());
			return new ArrayList<>();
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

	public ProcedureResult createAuthor(AuthorDTO author) {
		return callAuthorCrudProcedure(author.getAuthorId(), author.getAuthorName(), author.getAuthorCode(),
				author.getAuthorAddress(), author.getAuthorDob(), author.getAuthorEmail(), author.getAuthorEducation(),
				author.getAuthorUniversity(), AppConstants.NOT_DELETED, AppConstants.INSERT);
	}

	public ProcedureResult updateAuthor(AuthorDTO author) {
		return callAuthorCrudProcedure(author.getAuthorId(), author.getAuthorName(), author.getAuthorCode(),
				author.getAuthorAddress(), author.getAuthorDob(), author.getAuthorEmail(), author.getAuthorEducation(),
				author.getAuthorUniversity(), AppConstants.NOT_DELETED, AppConstants.UPDATE);

	}

	public ProcedureResult deleteAuthor(int authorId) {
		return callAuthorCrudProcedure(authorId, null, null, null, null, null, null, null, AppConstants.SOFT_DELETED,
				AppConstants.DELETE);
	}

	public List<AuthorDTO> searchAuthor(String authorName, String authorCode) {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			conn = DbConnectUtil.getConnection();
			String searchQuery = "{call proc_author_detail(0, ?, ?, null, null, null, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(searchQuery);

			cstmt.setString(1, authorName);
			cstmt.setString(2, authorCode);
			cstmt.setString(3, AppConstants.SEARCH);
			cstmt.registerOutParameter(4, Types.INTEGER);

			rs = cstmt.executeQuery();
			List<AuthorDTO> authors = new ArrayList<>();
			while (rs.next()) {
				AuthorDTO author = new AuthorDTO(rs.getInt("author_id"), rs.getString("author_name"),
						rs.getString("author_code"), rs.getString("author_address"), rs.getDate("author_dob"),
						rs.getString("author_email"), rs.getString("author_education"),
						rs.getString("author_university"), AppConstants.NOT_DELETED);
				authors.add(author);
			}
			return authors;
		} catch (Exception e) {
			System.err.println("Error searching author: " + e.getMessage());
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public static void main(String[] args) {

		AuthorDao authorDao = new AuthorDao();

		AuthorDTO newAuthor = new AuthorDTO();
		newAuthor.setAuthorName("Parshawan");
		newAuthor.setAuthorCode("HOV005");
		newAuthor.setAuthorAddress("Lodhiyana, Panjab");
		newAuthor.setAuthorDob(DateUtility.getDateFromCustomString("1885-08-14"));
		newAuthor.setAuthorEmail("panjabi@gmail.com");
		newAuthor.setAuthorEducation("B.A. in hindi");
		newAuthor.setAuthorUniversity("Panjab University");

//		ProcedureResult create = authorDao.createAuthor(newAuthor);
//		System.out.println("Create Result: " + create);

		List<AuthorDTO> allAuthor = authorDao.getAllAuthor();
		System.out.println("All Authors: " + allAuthor.size());
		allAuthor.forEach(System.out::println);

//		List<AuthorDTO> search = authorDao.searchAuthor("Allen", "1010");
//		System.out.println("Search Author: " + search);
//		search.forEach(System.out::println);

		AuthorDTO author = authorDao.getAuthorById(1020);
		author.setAuthorName("Vishnu-prabhkar");
		author.setAuthorCode("ARH008");
		author.setAuthorAddress("New Delhi");
		author.setAuthorDob( DateUtility.getDateFromCustomString("1976-11-12"));
		author.setAuthorEmail("vishnu@gmail.com");
		author.setAuthorEducation("M.A. in hindi");
		author.setAuthorUniversity("Delhi University");
		ProcedureResult update = authorDao.updateAuthor(author);
		System.out.println("Update Result: " + update);

		ProcedureResult delete = authorDao.deleteAuthor(1024);
		System.out.println("Delete Result: " + delete);
	}

}
