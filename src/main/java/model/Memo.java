package model;

import java.util.ArrayList;

public class Memo {
	private String date;
	private String memo;

	public Memo(String date, String memo) {
		this.date = date;
		this.memo = memo;
	}

	public static Memo search(ArrayList<Memo> memoList, String date) {
		for (int i = 0; i < memoList.size(); i++) {
			if (memoList.get(i).getDate().equals(date)) {
				return memoList.get(i);
			}
		}
		return null;
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

}
