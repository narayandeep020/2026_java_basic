package repository.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.BookTransactionDTO;
import util.DbConnectUtil;

public class BookTransactionRepo {

	public static void main(String[] args) throws Exception {

		BookTransactionDTO transdto = new BookTransactionDTO();
		transdto.setBookId(3005);
		transdto.setStudentId(5007);
		transdto.setIssueAdmin(4005);
		transdto.setFineAmount(20);

		BookTransactionRepo transrepo = new BookTransactionRepo();
		BookTransactionDTO bookdto = transrepo.addBookTransaction(transdto);
		System.out.println("Saved Book Transaction " + bookdto);
	}

	private static Connection con;

	private BookTransactionDTO addBookTransaction(BookTransactionDTO transdto) throws Exception {
		BookTransactionDTO bookdto = null;
		Statement stm = null;
		try {
			con = DbConnectUtil.getConnection();
			stm = con.createStatement();
			String insertQuery = "insert into book_issue_transactions(book_id, student_id, issued_by_admin, fine_amount) "
					+ "values (" + transdto.getBookId() + "," + transdto.getStudentId() + "," + transdto.getIssueAdmin()
					+ "," + transdto.getFineAmount() + ")";

			int rowAffected = stm.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

			if (rowAffected > 0) {
				ResultSet result = stm.getGeneratedKeys();
				if (result.next()) {
					transdto.setBookIssueId(result.getInt(1));
					bookdto = getBookTransactionById(transdto.getBookIssueId());
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stm.close();
			DbConnectUtil.closeConnection(con);
		}

		return bookdto;
	}

	private BookTransactionDTO getBookTransactionById(int bookIssueId) throws Exception {

		Statement st = null;
		BookTransactionDTO btd = new BookTransactionDTO();
		try {
			con = DbConnectUtil.getConnection();
			st = con.createStatement();
			String fetchQuery = "select * from book_issue_transactions";
			ResultSet rs = st.executeQuery(fetchQuery);

			while (rs.next()) {
				btd.setBookIssueId(rs.getInt("book_issue_id"));
				btd.setBookId(rs.getInt("book_id"));
				btd.setStudentId(rs.getInt("student_id"));
				btd.setIssueAdmin(rs.getInt("issued_by_admin"));
				btd.setIssueDate(rs.getDate("issue_date"));
				btd.setDueDate(rs.getDate("due_date"));
				btd.setReturnDate(rs.getDate("return_date"));
				btd.setFineAmount(rs.getFloat("fine_amount"));
				btd.setIssueStatus(rs.getString("issue_status"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			st.close();
			DbConnectUtil.closeConnection(con);
		}
		return btd;
	}

}
