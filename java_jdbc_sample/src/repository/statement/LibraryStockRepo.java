package repository.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.LibraryStockDTO;
import util.DbConnectUtil;

public class LibraryStockRepo {

	public static void main(String[] args) throws Exception {

		LibraryStockDTO stockdto = new LibraryStockDTO();
		stockdto.setBookId(3009);
		stockdto.setStockCount(22);
		stockdto.setCreatedAdmin(4001);

		LibraryStockRepo lsr = new LibraryStockRepo();
		LibraryStockDTO lsd2 = lsr.addLibraryStock(stockdto);
		System.out.println("Saved Library Stock " + lsd2);
	}

	private static Connection con;

	private LibraryStockDTO addLibraryStock(LibraryStockDTO stockdto) throws Exception {
		LibraryStockDTO lsd2 = null;
		Statement stm = null;
		try {
			con = DbConnectUtil.getConnection();
			stm = con.createStatement();
			String insertQuery = "insert into library_stock_detail(book_id, stock_count, created_by_admin)" + "values("
					+ stockdto.getBookId() + "," + stockdto.getStockCount() + "," + stockdto.getCreatedAdmin() + ")";
			int rowAffected = stm.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
			if (rowAffected > 0) {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next()) {
					stockdto.setStockId(rs.getInt(1));
					lsd2 = getLibraryStockById(stockdto.getStockId());
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stm.close();
			DbConnectUtil.closeConnection(con);
		}
		return lsd2;
	}

	private LibraryStockDTO getLibraryStockById(int stockId) throws Exception {
		LibraryStockDTO libdto = new LibraryStockDTO();
		Statement st = null;
		try {
			con = DbConnectUtil.getConnection();
			st = con.createStatement();
			String fetchQuery = "select * from library_stock_detail";
			ResultSet rs = st.executeQuery(fetchQuery);

			while (rs.next()) {
				libdto.setStockId(rs.getInt("stock_id"));
				libdto.setBookId(rs.getInt("book_id"));
				libdto.setStockCount(rs.getInt("stock_count"));
				libdto.setCreatedDate(rs.getDate("created_date"));
				libdto.setUpdatedDate(rs.getDate("updated_date"));
				libdto.setCreatedAdmin(rs.getInt("created_by_admin"));
				libdto.setUpdatedAdmin(rs.getInt("updated_by_admin"));
				libdto.setIsDeleted(rs.getString("is_deleted"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			st.close();
			DbConnectUtil.closeConnection(con);
		}

		return libdto;
	}

}
