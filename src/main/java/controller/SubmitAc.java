package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.JdbcSQLiteConnection;
import model.Memo;
import view.View;

public class SubmitAc implements ActionListener {
	View view;


	public SubmitAc(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String date = (String) Integer.toString((int) view.getComboBoxDay().getSelectedItem()) +  view.getComboBoxMonth().getSelectedItem() + view.getComboBoxYear().getSelectedItem();
		String resultSet = Memo.search(date);
		System.out.println(resultSet);
		if (resultSet == null) {
			JdbcSQLiteConnection.insertInto(Integer.toString((int) view.getComboBoxDay().getSelectedItem())
					, (String) view.getComboBoxMonth().getSelectedItem(), (String) view.getComboBoxYear().getSelectedItem()
					, view.getAreaMemo().getText());
			System.out.println("insert");
		}else{
			JdbcSQLiteConnection.updateItem(Integer.toString((int) view.getComboBoxDay().getSelectedItem())
					, (String) view.getComboBoxMonth().getSelectedItem(), (String) view.getComboBoxYear().getSelectedItem()
					, view.getAreaMemo().getText());
			System.out.println("update");
		}
	}
	
	

}
