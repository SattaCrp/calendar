package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.JdbcSQLiteConnection;
import view.View;

public class DeleteAc implements ActionListener{
	View view;

	public DeleteAc(View view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JdbcSQLiteConnection.deleteItem(Integer.toString((int) view.getComboBoxDay().getSelectedItem())
					, (String) view.getComboBoxMonth().getSelectedItem(), (String) view.getComboBoxYear().getSelectedItem());
		view.getAreaMemo().setText("");
	}

}
