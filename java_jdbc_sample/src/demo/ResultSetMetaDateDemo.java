package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbConnectUtil;

public class ResultSetMetaDateDemo {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbConnectUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM student_detail";
			rs = stmt.executeQuery(sql);

			ResultSetMetaData metaData = rs.getMetaData();

			printTableInformation(metaData);
			printColumnDetails(metaData);
			printActualData(rs, metaData);
			printAdditionalMetadata(metaData);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					DbConnectUtil.closeConnection(conn);
			} catch (SQLException e) {
				System.out.println("Error closing resourc" + e.getMessage());
			}
		}
	}

	public static void printTableInformation(ResultSetMetaData metaData) throws SQLException {
		System.out.println("=== ResultSet MetaDate for admin_detail table ===" + "\n");
		System.out.println("Table Information:");

		System.out.println("Table Name: " + metaData.getTableName(1));
		System.out.println("Schema Name: " + metaData.getSchemaName(1));
		System.out.println("Catalog Name: " + metaData.getCatalogName(1));
		System.out.println();

		int columnCount = metaData.getColumnCount();
		System.out.println("Total Column: " + columnCount + "\n");
	}

	private static void printColumnDetails(ResultSetMetaData metaData) throws SQLException {
		int columnCount = metaData.getColumnCount();

		System.out.println("Column Details: ");
		System.out.println(
				"------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s%n", "S.N.", "Column Name", "Data Type",
				"Type Name", "Size", "Nullable", "Auto Inc");
		System.out.println(
				"------------------------------------------------------------------------------------------------");

		for (int i = 1; i <= columnCount; i++) {
			String columnName = metaData.getColumnName(i);
			int dataType = metaData.getColumnType(i);
			String typeName = metaData.getColumnTypeName(i);
			int columnSize = metaData.getColumnDisplaySize(i);
			boolean nullable = metaData.isNullable(i) == ResultSetMetaData.columnNullable;
			boolean autoInc = metaData.isAutoIncrement(i);

			System.out.printf("%-5s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s%n", i, columnName, dataType,
					typeName, columnSize, nullable ? "YES" : "NO", autoInc ? "YES" : "NO");
		}
		System.out.println(
				"---------------------------------------------------------------------------------------" + "\n");
	}

	private static void printActualData(ResultSet rs, ResultSetMetaData metaData) throws SQLException {
		int columnCount = metaData.getColumnCount();

		System.out.println("Actual Data from admin detail table" + "\n");

		for (int i = 1; i <= columnCount; i++) {
			System.out.printf(metaData.getColumnName(i) + "\n");
		}
		System.out.println("------------------------"+"\n"+"------------------------");

//		for (int i = 1; i <= columnCount; i++) {
//			System.out.printf("%-20s", "--------------------" + "\n");
//		}

		int rowCount = 0;
		while (rs.next()) {
			rowCount++;
			for (int i = 1; i <= columnCount; i++) {
				Object value = rs.getObject(i);
				System.out.printf("%-20s", value != null ? value.toString() : "NULL");
			}
			System.out.println();
		}
		System.out.println("--------------------------------");
		System.out.println("Total Rows: " + rowCount);
	}

	private static void printAdditionalMetadata(ResultSetMetaData metaData) throws SQLException {
		int columnCount = metaData.getColumnCount();

		System.out.println("Additional MetaData Information:");
		System.out.println("----------------------------------");

		for (int i = 1; i <= columnCount; i++) {
			System.out.println("Column " + i + " :" + metaData.getColumnName(i));
			System.out.println(" - Precision: " + metaData.getPrecision(i));
			System.out.println(" - Scale: " + metaData.getScale(i));
			System.out.println(" - Case Sensitive:" + metaData.isCaseSensitive(i));
			System.out.println(" -Searchable:" + metaData.isSearchable(i));
			System.out.println(" - Currency:" + metaData.isCurrency(i));
			System.out.println(" - Singed:" + metaData.isSigned(i));
			System.out.println(" - Read Only:" + metaData.isReadOnly(i));
			System.out.println(" - Writable:" + metaData.isWritable(i));
			System.out.println(" - Definitely Writable:" + metaData.isDefinitelyWritable(i));

		}
	}
}
