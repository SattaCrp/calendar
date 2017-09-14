package ku.sci.cs.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

import model.JdbcSQLiteConnection;

public class Testdelete {
	@Test
	public void test() {
		JdbcSQLiteConnection.insertInto("4", "May", "2000", "No game");
		JdbcSQLiteConnection.deleteItem("4", "May", "2000");
		assertEquals(JdbcSQLiteConnection.selectFromMemoList("4May2000"),null);
	}
}
