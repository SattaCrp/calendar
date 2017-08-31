package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Memo;
import view.View;

public class SubmitAc implements ActionListener {
	View view;
	ArrayList<Memo> memoList;

	public SubmitAc(View view, ArrayList<Memo> memo) {
		this.view = view;
		this.memoList = memo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String date = view.getComboBoxDay().getSelectedItem() + "/" + view.getComboBoxMonth().getSelectedItem() + "/" + view.getComboBoxYear().getSelectedItem();
		Memo mem = Memo.search(memoList, date);
		if (mem == null) {
			memoList.add(new Memo(date, view.getAreaMemo().getText()));
			view.getAreaMemo().setText("");
		}else{
			System.out.println(mem.getMemo());
			mem.setMemo(view.getAreaMemo().getText());
			System.out.println(mem.getMemo() );
		}
	}

}
