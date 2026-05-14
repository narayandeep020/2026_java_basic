package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import util.DateUtility;
import util.DbConnectUtil;

public class LibraryStockDao {

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
	}

	public ProcedureResult callLibraryCrudProcedure(int stockId, int bookId, int stockCount, Date createdDate,
			Date updatedDate, int createdAdmin, int updatedAdmin, String isDeleted, String operationType) {

		try {
			conn = DbConnectUtil.getConnection();
			String callQuery = "{call proc_library_detail(?,?,?,?,?,?,?,?,?,?}";
			cstmt = conn.prepareCall(callQuery);

			cstmt.setInt(1, stockId);
			cstmt.setInt(2, bookId);
			cstmt.setInt(3, stockCount);
			cstmt.setDate(4, DateUtility.convertUtilToSqlDate(createdDate));
			cstmt.setDate(5, DateUtility.convertUtilToSqlDate(updatedDate));
			cstmt.setInt(6, createdAdmin);
			cstmt.setInt(7, updatedAdmin);
			cstmt.setString(8, isDeleted);
			cstmt.setString(9, operationType);
			cstmt.registerOutParameter(10, Types.INTEGER);

			cstmt.execute();
			int count = cstmt.getInt(10);
			return new ProcedureResult(count);
		} catch (Exception e) {
			System.out.println("Error calling proc library detail: " + e.getMessage());
			e.printStackTrace();
			return new ProcedureResult(-1);
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
			} catch (SQLException e) {
				System.out.println("Error closing resource: " + e.getMessage());
			}
			DbConnectUtil.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
