package ku.sci.cs.calendar;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.Memo;

public class TestMemoDate {
	
	@Test
	public void test() {
		ArrayList<Memo> memoList = new ArrayList<>();
		memoList.add(new Memo("1/January/2010", ""));
		memoList.add(new Memo("3/January/2011", ""));
		String str = "1/January/2010";

		assertEquals(memoList.get(0).getDate(), str);
	}
}
