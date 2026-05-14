package repository.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.AuthorDTO;
import util.DateUtility;
import util.DbConnectUtil;

public class AuthorRepository {

	public static void main(String[] args) throws SQLException {

		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setAuthorName("James Allen");
		authorDTO.setAuthorCode("JMA012");
		authorDTO.setAuthorAddress("Esteven, America");
		authorDTO.setAuthorDob(DateUtility.getDateFromCustomString("1985-09-12"));
		authorDTO.setAuthorEmail("jemes43221@gmail.com");
		authorDTO.setAuthorEducation("B.A. in English");
		authorDTO.setAuthorUniversity("Oxford university USA");

		AuthorRepository authorRepo = new AuthorRepository();
		authorDTO = authorRepo.addAuthor(authorDTO);
		System.out.println("Author added successfully " + authorDTO);

		AuthorDTO adto = authorRepo.getAuthorById(0);
		System.out.println("Author Detail" + adto);
	}

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public AuthorDTO addAuthor(AuthorDTO authorDTO) throws SQLException {
		AuthorDTO savedAuthor = null;
		String insertQ = "INSERT INTO author_detail(author_name, author_code, author_address, author_dob, author_email, author_education, author_university)"
				+ "VALUES(?,?,?,?,?,?,?)";

		try {
			conn = DbConnectUtil.getConnection();
			pstmt = conn.prepareStatement(insertQ, Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, authorDTO.getAuthorName());
			pstmt.setString(2, authorDTO.getAuthorCode());
			pstmt.setString(3, authorDTO.getAuthorAddress());
			pstmt.setDate(4, new java.sql.Date(authorDTO.getAuthorDob().getTime()));
			pstmt.setString(5, authorDTO.getAuthorEmail());
			pstmt.setString(6, authorDTO.getAuthorEducation());
			pstmt.setString(7, authorDTO.getAuthorUniversity());

			int rowAffect = pstmt.executeUpdate();
			if (rowAffect > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int authorId = rs.getInt(1);
					savedAuthor = getAuthorById(authorId);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			conn.close();
		}
		System.out.println("Record inserted successfully " + savedAuthor);
		return savedAuthor;
	}

	public AuthorDTO getAuthorById(int authorId) throws SQLException {
		AuthorDTO authorD = new AuthorDTO();
		String selectQ = "SELECT author_id, author_name, author_code, author_address, author_dob, author_email, author_education, author_university, is_deleted FROM author_detail WHERE author_id = ? AND is_deleted = 'N'";
		try {
			pstmt = DbConnectUtil.getConnection().prepareStatement(selectQ);
			pstmt.setInt(1, authorId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("author_id"));
				System.out.println(rs.getString("author_name"));
				System.out.println(rs.getString("author_code"));
				System.out.println(rs.getString("author_address"));
				System.out.println(rs.getDate("author_dob"));
				System.out.println(rs.getString("author_email"));
				System.out.println(rs.getString("author_education"));
				System.out.println(rs.getString("author_university"));
				System.out.println(rs.getString("is_deleted"));

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			rs.close();
			DbConnectUtil.closeConnection(conn);
		}
		return authorD;
	}

}
