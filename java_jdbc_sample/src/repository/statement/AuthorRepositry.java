package repository.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import dto.AuthorDTO;
import util.DateUtility;
import util.DbConnectUtil;

public class AuthorRepositry {

	public static void main(String[] args) throws Exception {


		AuthorDTO authordto = new AuthorDTO();
		authordto.setAuthorName("Maithligupt");
		authordto.setAuthorCode("AUTOO12");
		authordto.setAuthorAddress("Chirgaon,Jhansi");
		authordto.setAuthorDob(DateUtility.getDateFromCustomString("1785-09-12"));
		authordto.setAuthorEmail("mathligupt@gmail.com");
		authordto.setAuthorEducation("BA Hindi");
		authordto.setAuthorUniversity("Banaras Hindu University");

		AuthorRepositry authorpst = new AuthorRepositry();
		AuthorDTO savedauthordto = authorpst.addAuthor(authordto);
		System.out.println("Saved Author" + savedauthordto);
	}

	private static Connection con;

	public AuthorDTO addAuthor(AuthorDTO authordto) throws Exception {
		AuthorDTO savedauthordto = null;
		Date dobDate = new Date(authordto.getAuthorDob().getTime());
		Statement stm = null;
		try {
			con = DbConnectUtil.getConnection();
			stm = con.createStatement();
			String insertQuery = "insert into author_detail(author_name, author_code, author_address, author_dob, author_email, author_education, author_university)"
					+ "values('" + authordto.getAuthorName() + "','" + authordto.getAuthorCode() + "','"
					+ authordto.getAuthorAddress() + "','" + dobDate + "','"
					+ authordto.getAuthorEmail() + "','" + authordto.getAuthorEducation() + "','"
					+ authordto.getAuthorUniversity() + "')";
			int rowAffected = stm.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

			if (rowAffected > 0) {
				ResultSet resultset = stm.getGeneratedKeys();
				if (resultset.next()) {
					authordto.setAuthorId(resultset.getInt(1));
					savedauthordto = getAuthorById(authordto.getAuthorId());
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (stm != null) {
				stm.close();
			}
			DbConnectUtil.closeConnection(con);
		}
		return savedauthordto;
	}

	private AuthorDTO getAuthorById(int authorId) throws Exception {
		Statement st = null;
		AuthorDTO authorD = new AuthorDTO();
		try {
			con = DbConnectUtil.getConnection();
			st = con.createStatement();
			String fetchQuery = "select * from author_detail";
			ResultSet result = st.executeQuery(fetchQuery);

			while (result.next()) {
				authorD.setAuthorId(result.getInt("author_id"));
				authorD.setAuthorName(result.getString("author_name"));
				authorD.setAuthorCode(result.getString("author_code"));
				authorD.setAuthorAddress(result.getString("author_address"));
				authorD.setAuthorDob(result.getDate("author_dob"));
				authorD.setAuthorEmail(result.getString("author_email"));
				authorD.setAuthorEducation(result.getString("author_education"));
				authorD.setAuthorUniversity(result.getString("author_university"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {

			if (st != null) {
				st.close();
			}
			DbConnectUtil.closeConnection(con);
		}
		return authorD;
	}

}
