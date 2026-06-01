package demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import util.DbConnectUtil;

public class DbMd {

	public static void main(String[] args) {

		Connection conn = null;

		try {
			conn = DbConnectUtil.getConnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("---------------------------------");

			System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("User Name: " + dbmd.getUserName());
			System.out.println("User Max Name Length: " + dbmd.getMaxUserNameLength() + "\n");

			System.out.println("Table in the database: " + "\n" + "----------------------------");

			ResultSet table = dbmd.getTables(null, null, "%", new String[] { "TABLE" });
			while (table.next()) {
				System.out.println(
						"Name: " + table.getString("TABLE_NAME") + ", Table Type: " + table.getString("TABLE_TYPE"));
			}
			table.close();
			System.out.println();

			System.out.println("Cloumns in book table:" + "\n" + "-----------------------------");

			ResultSet column = dbmd.getColumns(null, null, "book_detail", "%");
			while (column.next()) {
				System.out.println(
						"Name: " + column.getString("COLUMN_NAME") + ", Type Name: " + column.getString("TYPE_NAME"));
			}
			column.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
