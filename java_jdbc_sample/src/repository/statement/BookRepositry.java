package repository.statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.BookDTO;
import util.DateUtility;
import util.DbConnectUtil;

public class BookRepositry {

	public static void main(String[] args) throws Exception {
		
		BookDTO  bookdto = new BookDTO();
		bookdto.setBookTitle("The Marthon");
		bookdto.setIsbn("968-0-449-70718-9");
		bookdto.setAuthorId(1010);
		bookdto.setPublisherId(2010);
		bookdto.setPublicationDate(DateUtility.getDateFromCustomString("1985-09-10"));
		bookdto.setPrice(190);
		bookdto.setGenre("Stories");
		bookdto.setPages(233);
		bookdto.setLanguage("English");

		     BookRepositry bookrepo = new BookRepositry();
		     BookDTO savedbook = bookrepo.addBook(bookdto);
		     System.out.println("Saved Author: " + savedbook);

	}
	
	private static Connection con;

	private BookDTO addBook(BookDTO bookdto) throws Exception {

		BookDTO saveddto = null;
		Date publicationdate = new Date(bookdto.getPublicationDate().getTime());
		Statement stm = null;
		try {
			 con = DbConnectUtil.getConnection();
			stm = con.createStatement();
			String insertQuery = "insert into book_detail(book_title, isbn, author_id, publisher_id, publication_date, price, genre, pages, language)"
					+ "values('" + bookdto.getBookTitle() + "','" + bookdto.getIsbn() + "',"
					+ bookdto.getAuthorId() + "," + bookdto.getPublisherId() + ",'"
					+ publicationdate + "'," + bookdto.getPrice() + ",'"
					+ bookdto.getGenre() + "',"+bookdto.getPages()+",'"+bookdto.getLanguage()+"')";
			
			System.out.println(insertQuery);
			
			int rowAffected = stm.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
			
			if (rowAffected > 0) {
				ResultSet resultset = stm.getGeneratedKeys();
				if (resultset.next()) {
					bookdto.setBookId(resultset.getInt(1));
					saveddto = getBookById(bookdto.getBookId());
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
		return saveddto;
	}

	private BookDTO getBookById(int authorId) throws Exception {
		Statement st = null;
		BookDTO bookdto = new BookDTO();
		try {
			con = DbConnectUtil.getConnection();
			st = con.createStatement();
			String fetch = "select * from book_detail";
			ResultSet result = st.executeQuery(fetch);
			
			while(result.next()) {
				
				bookdto.setBookId(result.getInt("book_id"));
				bookdto.setBookTitle(result.getString("book_title"));
				bookdto.setIsbn(result.getString("isbn"));
				bookdto.setAuthorId(result.getInt("author_id"));
				bookdto.setPublisherId(result.getInt("publisher_id"));
				bookdto.setPublicationDate(result.getDate("publication_date"));
				bookdto.setPrice(result.getFloat("price"));
				bookdto.setGenre(result.getString("genre"));
				bookdto.setPages(result.getInt("pages"));
				bookdto.setLanguage(result.getString("language"));
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			st.close();
			DbConnectUtil.closeConnection(con);
		}
		
		return bookdto;
	}

}
