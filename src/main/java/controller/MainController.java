package controller;

import java.util.ArrayList;
import model.Memo;
import view.View;

public class MainController {
	private View view;
	
	public MainController(View view){
		this.view = view;
	}

	public void startApplication() {
		view.initFream();
		
		int year = Integer.parseInt(view.getComboBoxYear().getSelectedItem().toString());
		int month = view.getComboBoxMonth().getSelectedIndex();
		ShowActionlistener.showCalender(year, month,view.getComboBoxDay());
		view.getBtnDiaryDel().addActionListener(new DeleteDiary(view));
		view.getComboBoxMonth().addActionListener(new ShowActionlistener(view));
		view.getComboBoxYear().addActionListener(new ShowActionlistener(view));
		view.getBtnSub().addActionListener(new SubmitAc(view));
		view.getBtnEnter().addActionListener(new ShowMemoAc(view));
		view.getBtndel().addActionListener(new DeleteAc(view));
		view.getBtnDiarySub().addActionListener(new SubmitDiary(view));
		
	}
}
