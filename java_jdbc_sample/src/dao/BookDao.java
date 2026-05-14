package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dto.BookDTO;
import util.AppConstants;
import util.DateUtility;
import util.DbConnectUtil;

public class BookDao {

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

	public ProcedureResult callBookCrudProcedure(int bookId, String bookTitle, String isbn, int authorId,
			int publisherId, Date publicationDate, float price, String genre, int pages, String language,
			int createAdmin, int updateAdmin, Date createDate, Date updateDate, String isDeleted,
			String operationType) {
		conn = null;
		cstmt = null;

		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_book_detail(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, bookId);
			cstmt.setString(2, bookTitle);
			cstmt.setString(3, isbn);
			cstmt.setInt(4, authorId);
			cstmt.setInt(5, publisherId);
			cstmt.setDate(6, DateUtility.convertUtilToSqlDate(publicationDate));
			cstmt.setFloat(7, price);
			cstmt.setString(8, genre);
			cstmt.setInt(9, pages);
			cstmt.setString(10, language);
			cstmt.setInt(11, createAdmin);
			cstmt.setInt(12, updateAdmin);
			cstmt.setDate(13, DateUtility.convertUtilToSqlDate(createDate));
			cstmt.setDate(14, DateUtility.convertUtilToSqlDate(updateDate));
			cstmt.setString(15, isDeleted);
			cstmt.setString(16, operationType);

			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			int count = cstmt.getInt(17);
			return new ProcedureResult(count);

		} catch (Exception e) {
			System.err.println("Error calling proc_book_detail");
			return new ProcedureResult(-1);
		} finally {
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public BookDTO getBookById(int bookId) {
		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_book_detail(?, null, null, 0, 0, null, 0, null, 0, null, 0, 0, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, bookId);
			cstmt.setString(2, AppConstants.READ);
			cstmt.setInt(3, Types.INTEGER);
			rs = cstmt.executeQuery();
			
			BookDTO book = null;
			if (rs.next()) {
				book = new BookDTO(rs.getInt("book_id"), rs.getString("book_title"), rs.getString("isbn"),
						rs.getInt("author_id"), rs.getInt("publisher_id"), rs.getDate("publication_date"),
						rs.getFloat("price"), rs.getString("genre"), rs.getInt("pages"), rs.getString("language"),
						rs.getInt("created_by_admin"), rs.getInt("updated_by_admin"), rs.getDate("created_date"),
						rs.getDate("updated_date"), AppConstants.NOT_DELETED);
			}
			return book;
		} catch (Exception e) {
			System.err.println("Error getting book by Id: " + e.getMessage());
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

	public List<BookDTO> getAllBooks() {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			conn = DbConnectUtil.getConnection();
			String getQuery = "{call proc_book_detail(0, null, null, 0, 0, null, 0, null, 0, null, 0, 0, null, null,null, ?, ?)}";
			cstmt = conn.prepareCall(getQuery);

			cstmt.setString(1, AppConstants.READ_ALL);
			cstmt.setInt(2, Types.INTEGER);

			rs = cstmt.executeQuery();

			List<BookDTO> books = new ArrayList<>();
			while (rs.next()) {
				BookDTO book = new BookDTO(rs.getInt("book_id"), rs.getString("book_title"), rs.getString("isbn"),
						rs.getInt("author_id"), rs.getInt("publisher_id"), rs.getDate("publication_date"),
						rs.getFloat("price"), rs.getString("genre"), rs.getInt("pages"), rs.getString("language"),
						rs.getInt("created_by_admin"), rs.getInt("updated_by_admin"), rs.getDate("created_date"),
						rs.getDate("updated_date"), AppConstants.NOT_DELETED);
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			System.out.println("Error getting all Books: " + e.getMessage());
			return new ArrayList<>();
		} finally {
			try {
				if(rs != null)rs.close();
				if(cstmt != null)cstmt.close();

			} catch (SQLException e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public ProcedureResult createBook(BookDTO book) {
		return callBookCrudProcedure(book.getBookId(), book.getBookTitle(), book.getIsbn(), book.getAuthorId(),
				book.getPublisherId(), book.getPublicationDate(), book.getPrice(), book.getGenre(), book.getPages(),
				book.getLanguage(), book.getCreateAdmin(), book.getUpdateAdmin(), book.getCreateDate(),
				book.getUpdateDate(), AppConstants.NOT_DELETED, AppConstants.INSERT);
	}

	public ProcedureResult updateBook(BookDTO book) {
		return callBookCrudProcedure(book.getBookId(), book.getBookTitle(), book.getIsbn(), book.getAuthorId(),
				book.getPublisherId(), book.getPublicationDate(), book.getPrice(), book.getGenre(), book.getPages(),
				book.getLanguage(), book.getCreateAdmin(), book.getUpdateAdmin(), book.getCreateDate(),
				book.getUpdateDate(), AppConstants.NOT_DELETED, AppConstants.UPDATE);
	}

	public ProcedureResult deleteBook(int bookid) {
		return callBookCrudProcedure(bookid, null, null, 0, 0, null, 0, null, 0, null, 0, 0, null, null,
				AppConstants.NOT_DELETED, AppConstants.DELETE);
	}

	public List<BookDTO> searchBook(String bookTitle) {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			conn = DbConnectUtil.getConnection();
			String searchQuery = "{call proc_book_detail(0, ?, null, 0, 0, null, 0, null, 0, null, 0, 0, null, null, null, ?, ?)}";
			cstmt = conn.prepareCall(searchQuery);

			cstmt.setString(1, bookTitle);
			cstmt.setString(2, AppConstants.SEARCH);
			cstmt.setInt(3, Types.INTEGER);

			rs = cstmt.executeQuery();
			List<BookDTO> books = new ArrayList<>();
			while (rs.next()) {
				BookDTO book = new BookDTO(rs.getInt("book_id"), rs.getString("book_title"), rs.getString("isbn"),
						rs.getInt("author_id"), rs.getInt("publisher_id"), rs.getDate("publication_date"),
						rs.getFloat("price"), rs.getString("genre"), rs.getInt("pages"), rs.getString("language"),
						rs.getInt("created_by_admin"), rs.getInt("updated_by_admin"), rs.getDate("created_date"),
						rs.getDate("updated_date"), AppConstants.NOT_DELETED);
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			System.err.println("Error searching books: " + e.getMessage());
			e.printStackTrace();
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.err.println("Error closing statement: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public static void main(String[] args) {

		BookDao bookDao = new BookDao();
		BookDTO bookDto = new BookDTO();

		bookDto.setBookTitle("Jungle Safari");
		bookDto.setIsbn("987-6543-21-09");
		bookDto.setAuthorId(1007);
		bookDto.setPublisherId(2005);
		bookDto.setPublicationDate(DateUtility.getDateFromCustomString("1789-03-12"));
		bookDto.setPrice(55);
		bookDto.setGenre("Story");
		bookDto.setPages(134);
		bookDto.setLanguage("Hindi");
		bookDto.setCreateAdmin(4003);

//		ProcedureResult createBook = bookDao.createBook(bookDto);
//		System.out.println("New Book Inserted: " + createBook);

		List<BookDTO> allBook = bookDao.getAllBooks();
		System.out.println("Get All Books: " + allBook);
		allBook.forEach(System.out::println);

		List<BookDTO> searchBook = bookDao.searchBook("The Shining");
		System.out.println("Search Book Result: " + searchBook);
		searchBook.forEach(System.out::println);

		BookDTO book = bookDao.getBookById(3009);
		if (book != null)
			System.out.println("Book Found by Id: " + book);

//		ProcedureResult deleteBook = bookDao.deleteBook(3013);
//		System.out.println("Deleted Book: " + deleteBook);

	}

}
