package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.JdbcSQLiteConnection;
import view.View;

public class DeleteDiary implements ActionListener {
	View view;

	public DeleteDiary(View view) {
		this.view = view;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (view.getCheckmonth().isSelected()) {System.out.println("sdasdsadasdasdsadasdasdasdasfsdaghedrfhd");
			JdbcSQLiteConnection.deleteItemDiary((Integer.toString((int) view.getComboBoxDay().getSelectedItem())));
		}
		if (view.getCheckSun().isSelected()) {
			JdbcSQLiteConnection.updateItemForEvery(2,null);
			System.out.println("update");
		}if(view.getCheckMon().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(3,null);
			System.out.println("update");
		}if(view.getCheckTue().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(4,null);
			System.out.println("update");
		}if(view.getCheckWen().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(5,null);
			System.out.println("update");
		}if(view.getCheckThu().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(6,null);
			System.out.println("update");
		}if(view.getCheckFri().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(7,null);
			System.out.println("update");
		}if(view.getCheckSat().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(1,null);
			System.out.println("update");
		}if(view.getCheckDairy().isSelected()){
			JdbcSQLiteConnection.updateItemForEvery(0,null);
			System.out.println("update");
		}
		view.getAreaDairy().setText("");
	} 

}
