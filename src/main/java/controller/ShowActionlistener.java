package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Date;
import view.View;

public class ShowActionlistener implements ActionListener{
	View view;
	
	public ShowActionlistener(View view) {
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		view.getComboBoxDay().removeAllItems();
		int year = Integer.parseInt(view.getComboBoxYear().getSelectedItem().toString());
		int month = view.getComboBoxMonth().getSelectedIndex();
		Date.showCalender(year, month,view.getComboBoxDay());
	}
}
