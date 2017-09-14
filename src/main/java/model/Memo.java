package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Memo {
	private String date;
	private String memo;

	public Memo(String date, String memo) {
		this.date = date;
		this.memo = memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getDate() {
		return date;
	}
	public String getMemo() {
		return memo;
	}
	public static String search(String date) {
		String resultSet = JdbcSQLiteConnection.selectFromMemoList(date);
		return resultSet;
	}

}
