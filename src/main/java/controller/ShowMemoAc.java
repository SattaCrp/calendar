package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Memo;
import view.View;

public class ShowMemoAc implements ActionListener {
	View view;
	ArrayList<Memo> memoList;

	public ShowMemoAc(View view, ArrayList<Memo> memo) {
		this.view = view;
		this.memoList = memo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String date = view.getComboBoxDay().getSelectedItem() + "/" + view.getComboBoxMonth().getSelectedItem() + "/"
				+ view.getComboBoxYear().getSelectedItem();
		Memo mem = Memo.search(memoList, date);
		if (mem == null) {
			view.getAreaMemo().setText("");
		} else {

			view.getAreaMemo().setText(mem.getMemo());
		}
	}

}
