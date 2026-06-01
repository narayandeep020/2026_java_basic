package demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import util.DbConnectUtil;

public class DatabaseMetaDataDemo {

	public static void main(String[] args) {

		Connection conn = null;

		try {
			conn = DbConnectUtil.getConnection();

			DatabaseMetaData dbmd = conn.getMetaData();

			System.out.println("=== Database MetaData Information ===" + "\n");

			System.out.println("Besic Database information:" + "\n" + "-----------------------------");

			System.out.println("Database product name: " + dbmd.getDatabaseProductName());
			System.out.println("Database product version: " + dbmd.getDatabaseProductVersion());
			System.out.println("Database major version: " + dbmd.getDatabaseMajorVersion());
			System.out.println("Database minor version; " + dbmd.getDatabaseMinorVersion() + "\n");

			System.out.println("Driver Infomation: " + "\n" + "-------------------------");

			System.out.println("Driver name: " + dbmd.getDriverName());
			System.out.println("Driver version: " + dbmd.getDriverVersion());
			System.out.println("Driver major version: " + dbmd.getDriverMajorVersion());
			System.out.println("Driver minor version: " + dbmd.getDriverMinorVersion() + "\n");

			System.out.println("Connection Infomation: " + "\n" + "---------------------------");

			System.out.println("URL: " + dbmd.getURL());
			System.out.println("UserName: " + dbmd.getUserName());
			System.out.println("Transaction Isolation: " + conn.getTransactionIsolation());
			System.out.println("Auto Commit: " + conn.getAutoCommit());
			System.out.println("Read Only: " + conn.isReadOnly() + "\n");

			System.out.println("Database Capabilities: " + "\n" + "----------------------------");

			System.out.println("Supports Transaction: " + dbmd.supportsTransactions());
			System.out.println("Supports Savepoints: " + dbmd.supportsSavepoints());
			System.out.println("Supports Batch Updates: " + dbmd.supportsBatchUpdates());
			System.out.println("Supports Named Parameters: " + dbmd.supportsNamedParameters());
			System.out.println("Supports Multiple Result Sets: " + dbmd.supportsMultipleResultSets());
			System.out.println("Supports GetGeneratedKeys: " + dbmd.supportsGetGeneratedKeys() + "\n");

			System.out.println("SQL Capabilities: " + "\n" + "-------------------------");

			System.out.println("ANSI SQL Level: " + getSQLLevel(dbmd));
			System.out.println("Supports Outer Joins: " + dbmd.supportsOuterJoins());
			System.out.println("Supports Full Outer Joins: " + dbmd.supportsFullOuterJoins());
			System.out.println("Supports Limited Outer Joins: " + dbmd.supportsLimitedOuterJoins());
			System.out.println("Supports Subqueries: " + dbmd.supportsSubqueriesInComparisons());
			System.out.println("Supports Union: " + dbmd.supportsUnion());
			System.out.println("Supports Union All: " + dbmd.supportsUnionAll());
			System.out.println("Supports Group By: " + dbmd.supportsGroupBy());
			System.out.println("Supports Group By Beyond Select: " + dbmd.supportsGroupByBeyondSelect());
			System.out.println("Supports Like Escape Clause: " + dbmd.supportsLikeEscapeClause() + "\n");

			System.out.println("Database Limits; " + "\n" + "-------------------------");

			System.out.println("Max Connections: " + dbmd.getMaxConnections());
			System.out.println("Max Statements: " + dbmd.getMaxStatements());
			System.out.println("Max Table Name Length: " + dbmd.getMaxTableNameLength());
			System.out.println("max Column Name Length: " + dbmd.getMaxColumnNameLength());
			System.out.println("Max Columns in Table: " + dbmd.getMaxColumnsInTable());
			System.out.println("Max Row Size: " + dbmd.getMaxRowSize());
			System.out.println("Max Statement Length: " + dbmd.getMaxStatementLength() + "\n");

			System.out.println("Database Tables:" + "\n" + "------------------------");

			ResultSet table = dbmd.getTables(null, null, "%", new String[] { "TABLE" });
			while (table.next()) {
				System.out.println("Catalog: " + table.getString("TABLE_CAT") + ", Schema: "
						+ table.getString("TABLE_SCHEM") + ", Table: " + table.getString("TABLE_NAME") + ", Type: "
						+ table.getString("TABLE_TYPE"));
			}
			table.close();
			System.out.println();

			System.out.println("Database Schemas: " + "\n" + "--------------------------");

			ResultSet schema = dbmd.getSchemas();
            while (schema.next()) {
                System.out.println("Schema: " + schema.getString("TABLE_SCHEM"));
            }
			schema.close();
			System.out.println();

			System.out.println(
					"Column Information for admin detail:" + "\n" + "---------------------------------------------");

			ResultSet column = dbmd.getColumns(null, null, "admin_detail", "%");
			System.out.printf("%-20s | %-15s | %-15s | %-10s | %-10s | %-10s%n", "Column Name", "Data type", "Type Name", "Size",
					"Nullable", "Default");
			System.out.println("---------------------------------------------------------------------");

			while (column.next()) {
				System.out.printf("%-20s | %-15s | %-15s | %-10s | %-10s | %-10s%n", column.getString("COLUMN_NAME"),
						column.getInt("DATA_TYPE"), column.getString("TYPE_NAME"), column.getInt("COLUMN_SIZE"),
						column.getString("IS_NULLABLE"), column.getString("COLUMN_DEF"));
			}
			column.close();
			System.out.println();

			System.out.println("Primary Key Information:" + "\n" + "----------------------------------");

			ResultSet primarykey = dbmd.getPrimaryKeys(null, null, "admin_detail");
			while (primarykey.next()) {
				System.out.println("Column: " + primarykey.getString("COLUMN_NAME") + ", Key Seq: "
						+ primarykey.getString("KEY_SEQ") + ", PK Name: " + primarykey.getString("PK_NAME"));
			}
			primarykey.close();
			System.out.println();

			System.out.println("Foreign Key Information:" + "\n" + "-----------------------------------");

			ResultSet foreignkey = dbmd.getImportedKeys(null, null, "admin_detail");
			while (foreignkey.next()) {
				System.out.println("FK Column: " + foreignkey.getString("FKCOLUMN_NAME") + ", PK Table: "
						+ foreignkey.getString("PKTABLE_NAME") + ", PK Column: " + foreignkey.getString("PKCOLUMN_NAME")
						+ ", FK Name: " + foreignkey.getString("FK_NAME"));
			}
			foreignkey.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (conn != null)
				DbConnectUtil.closeConnection(conn);
		}
	}

	private static String getSQLLevel(DatabaseMetaData dbmd) throws Exception {

		if (dbmd.supportsCoreSQLGrammar()) {
			if (dbmd.supportsExtendedSQLGrammar()) {
				if (dbmd.supportsANSI92FullSQL()) {
					return "ANSI 92 Full";
				} else if (dbmd.supportsANSI92IntermediateSQL()) {
					return "ANSI 92 Intermediate";
				} else {
					return "ANSI 92 Entry";
				}
			} else {
				return "Core SQL";
			}
		} else {
			return "Unkonwn";
		}
	}
}
