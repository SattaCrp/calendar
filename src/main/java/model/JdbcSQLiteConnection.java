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

	public static String selectFromMemoList(String date) {
		String dbURL = "jdbc:sqlite:memolist.db";
		// execute SQL statements
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "select * from memolist";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("---------+" + date +"+-----"+resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3)+"---------");
			if (date.equals(resultSet.getString(1)+resultSet.getString(2)+resultSet.getString(3))){
				String result = resultSet.getString(4);
				conn.close();
				System.out.println(conn.isClosed());
				return result;
			}
		}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Connection conn = DriverManager.getConnection(dbURL);
				String query = "create table memolist ( day text, month text, year text, memo text);";
				Statement statement = conn.createStatement();
				statement.execute(query);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	public static String[] selectFromDiaryList(String date ) {
		String dbURL = "jdbc:sqlite:memolist.db";
		String[] resultList = {"","","","","","","","",""}; 
		// execute SQL statements
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "select * from diarylist";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("---------/" + date +"/-----"+resultSet.getString(1));
			if (date.equals(resultSet.getString(1))){
				resultList[0] = resultSet.getString(2);
			}
			for(int i = 0;i < 8;i++){
				if(resultSet.getInt(3)==(i)){
					resultList[i+1] = resultSet.getString(2);
					System.out.println(resultSet.getString(2)+i);
				}
			}
			
			
		}
			conn.close();
			System.out.println(conn.isClosed());
			return resultList;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Connection conn = DriverManager.getConnection(dbURL);
				String query = "create table diarylist ( day text , memo text ,diary integer);";
				Statement statement = conn.createStatement();
				statement.execute(query);
				for(int i =0 ; i < 8;i++){
				query = "insert into diarylist (memo,diary) values ('', " + i +")";
				statement.execute(query);
				}
				conn.close();
				System.out.println(conn.isClosed());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	
	public static void insertDiary( String day, String memo) {
		String dbURL = "jdbc:sqlite:memolist.db";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "insert into diarylist (day,memo,diary) values ('" + day + "','" + memo + "','" + 99 +"')";
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
	
	public static void updateItemDiary(String day, String memo) {
		String dbURL = "jdbc:sqlite:memolist.db";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "UPDATE diarylist SET memo = '" + memo + "' WHERE day='" + day + "';";
			Statement statement = conn.createStatement();
			statement.execute(query);
			conn.close();
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateItemForEvery(int day, String memo) {
		String dbURL = "jdbc:sqlite:memolist.db";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "UPDATE diarylist SET memo = '" + memo + "' WHERE diary=" + day + ";";
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
	
	public static void deleteItemDiary(String day) {
		String dbURL = "jdbc:sqlite:memolist.db";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String query = "DELETE FROM diarylist WHERE day='" + day + "';";
			Statement statement = conn.createStatement();
			statement.execute(query);
			conn.close();
			System.out.println(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}