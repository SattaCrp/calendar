package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.JdbcSQLiteConnection;
import model.Memo;
import view.View;

public class SubmitDiary implements ActionListener {
	View view;


	public SubmitDiary(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String day = Integer.toString((int) view.getComboBoxDay().getSelectedItem());
		String[] diaryList = JdbcSQLiteConnection.selectFromDiaryList(day);
		
		if(view.getCheckmonth().isSelected()){
			if (diaryList[0] == "") {
				JdbcSQLiteConnection.insertDiary(Integer.toString((int) view.getComboBoxDay().getSelectedItem()), view.getAreaDairy().getText());
				System.out.println("insert");
			}else{
				JdbcSQLiteConnection.updateItemDiary(Integer.toString((int) view.getComboBoxDay().getSelectedItem()), view.getAreaDairy().getText());
				System.out.println("update");
			}
		}if(view.getCheckSun().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(2, view.getAreaDairy().getText());
			System.out.println("update");
		}if(view.getCheckMon().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(3, view.getAreaDairy().getText());
			System.out.println("update");
		}if(view.getCheckTue().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(4, view.getAreaDairy().getText());
			System.out.println("update");
		}if(view.getCheckWen().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(5, view.getAreaDairy().getText());
			System.out.println("update");
		}if(view.getCheckThu().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(6, view.getAreaDairy().getText());
			System.out.println("update");
		}if(view.getCheckFri().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(7, view.getAreaDairy().getText());
			System.out.println("update");
		}if(view.getCheckSat().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(1, view.getAreaDairy().getText());
			System.out.println("update");
		}if(view.getCheckDairy().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(0, view.getAreaDairy().getText());
			System.out.println("update");
		}
	}
} 