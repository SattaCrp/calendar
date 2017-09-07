package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSQLiteConnection {

	public static void checkConnect() {
		String dbURL = "jdbc:sqlite:memolist.db";
		try {
			// setup
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected to the database....");
			}
			conn.close();
			System.out.println(conn.isClosed());
		} catch (Exception e) {
		}
	}

	public static void datatInform() {
		String dbURL = "jdbc:sqlite:memolist.db";
		// display database information
		try {
			Connection conn = DriverManager.getConnection(dbURL);

			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Product name: " + dm.getDatabaseProductName());

			conn.close();
			System.out.println(conn.isClosed());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String selectFrom(String date) {
		String dbURL = "jdbc:sqlite:memolist.db";
		// execute SQL statements
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "select * from memolist";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
			if (date.equals(resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3))){
				String result = resultSet.getString(4);
				conn.close();
				System.out.println(conn.isClosed());
				return result;
			}
			conn.close();
			System.out.println(conn.isClosed());
			return null;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static void insertInto(String day, String month, String year, String memo) {
		String dbURL = "jdbc:sqlite:memolist.db";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "insert into memolist (day,month,year,memo) values ('" + day + "','" + month + "','" + year
					+ "','" + memo + "')";
			Statement statement = conn.createStatement();
			statement.execute(query);
			conn.close();
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateItem(String day, String month, String year, String memo) {
		String dbURL = "jdbc:sqlite:memolist.db";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "UPDATE memolist	SET memo = '" + memo + "' WHERE day='" + day + "' and month = '" + month
					+ "' and year = '" + year + "';";
			Statement statement = conn.createStatement();
			statement.execute(query);
			conn.close();
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteItem(String day, String month, String year) {
		String dbURL = "jdbc:sqlite:memolist.db";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "DELETE FROM memolist WHERE day='" + day + "' and month = '" + month + "' and year = '"
					+ year + "';";
			Statement statement = conn.createStatement();
			statement.execute(query);
			conn.close();
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}