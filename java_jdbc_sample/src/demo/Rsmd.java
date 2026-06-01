package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.DbConnectUtil;

public class Rsmd {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbConnectUtil.getConnection();
			String selectQuery = "SELECT * FROM student_detail";
			ps = conn.prepareStatement(selectQuery);

			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			System.out.println("Total Columns: " + rsmd.getColumnCount());
			System.out.println("Column Name of 1st Column: " + rsmd.getColumnName(1));
			System.out.println("Column Type Name of 1st Column: " + rsmd.getColumnTypeName(1));

			conn.close();

		} catch (Exception e) {
			System.out.println("Error of geting value: " + e.getMessage());
		}
	}

}
