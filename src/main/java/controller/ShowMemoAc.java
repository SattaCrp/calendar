package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import model.JdbcSQLiteConnection;
import model.Memo;
import view.View;

public class ShowMemoAc implements ActionListener {
	View view;

	public ShowMemoAc(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String date = (String) Integer.toString((int) view.getComboBoxDay().getSelectedItem()) +  view.getComboBoxMonth().getSelectedItem() + view.getComboBoxYear().getSelectedItem();
		String resultSet = Memo.search(date);
		System.out.println(date);
		if (resultSet == "") {
			view.getAreaMemo().setText("");
			System.out.println("null");
		} else {
				view.getAreaMemo().setText(resultSet);
		}
	}

}
