package repository.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.LibraryStockDTO;
import util.DbConnectUtil;

public class LibraryStockRepository {

	public static void main(String[] args) throws SQLException {

		LibraryStockDTO lsd = new LibraryStockDTO();
		lsd.setBookId(3005);
		lsd.setStockCount(14);
		lsd.setCreatedAdmin(4003);

		LibraryStockRepository lsrepo = new LibraryStockRepository();
		lsd = lsrepo.addLibraryStock(lsd);
		System.out.println("Library data add successfully" + lsd);

		LibraryStockDTO lsdto = lsrepo.getLibraryStockId(6002);
		System.out.println("Library Stock Detail" + lsdto);

	}

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public LibraryStockDTO addLibraryStock(LibraryStockDTO lsd) throws SQLException {
		LibraryStockDTO stockdto = null;
		String insertQuery = "INSERT INTO library_stock_detail(book_id, stock_count, created_by_admin)VALUES(?,?,?)";
		try {
			conn = DbConnectUtil.getConnection();
			pstmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, lsd.getBookId());
			pstmt.setInt(2, lsd.getStockCount());
			pstmt.setInt(3, lsd.getCreatedAdmin());

			int rowAffected = pstmt.executeUpdate();
			if (rowAffected > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int lsid = rs.getInt(1);
					stockdto = getLibraryStockId(lsid);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pstmt.close();
			conn.close();
		}
		System.out.println("Record inserted successfully" + stockdto);
		return stockdto;
	}

	private LibraryStockDTO getLibraryStockId(int lsid) throws SQLException {
		LibraryStockDTO lsdto = new LibraryStockDTO();
		String selectQuery = "SELECT book_id, stock_count, created_by_admin FROM library_stock_detail WHERE stock_id =? AND is_deleted = 'N'";
		
		try {
			pstmt = DbConnectUtil.getConnection().prepareStatement(selectQuery);
			pstmt.setInt(1, lsid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("book_id"));
				System.out.println(rs.getInt("stock_count"));
				System.out.println(rs.getInt("created_by_admin"));
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			pstmt.close();
			rs.close();
			DbConnectUtil.closeConnection(conn);
		}

		return lsdto;
	}

}
