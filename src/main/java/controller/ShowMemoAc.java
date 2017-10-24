package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
		
		String day = Integer.toString((int) view.getComboBoxDay().getSelectedItem());
		String[] diaryList = JdbcSQLiteConnection.selectFromDiaryList(day);
		String set = "";
		Date dateO = new Date(Integer.parseInt((String) view.getComboBoxYear().getSelectedItem()), view.getComboBoxMonth().getSelectedIndex(),(int) view.getComboBoxDay().getSelectedItem() );
		if (diaryList[0]!="") {
			set = set + diaryList[0]+"\n";
		}
		if (!diaryList[1].equals("null")) {
			set = set + diaryList[1]+"\n";
		}
		
		for(int i = 2 ; i < diaryList.length ;i++ ){
			System.out.println(diaryList[i].equals("null"));
			if(!diaryList[i].equals("null") && i==dateO.getDay()+2){
				set = set + diaryList[i]+"\n";
			}
		}
		System.out.println(set);
		view.getAreaDairy().setText(set);
		
	}

}
