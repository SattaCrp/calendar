package controller;

import java.util.ArrayList;


import model.Memo;
import view.View;

public class MainController {
	private View view;
	private ArrayList<Memo> memoList;

	public void startApplication() {
//		JOptionPane.showMessageDialog(null, "Calendar Memo \n step 1: chose month and year \n step 2: press ShowDays button"+ "\n step 3: chose days and press ShowMemo button \n step 4: Write a note \n step 5: press Sumbit button");
		view = new View();
		memoList = new ArrayList<>();
		
		view.initFream();
		view.getBtnShow().addActionListener(new ShowActionlistener(view));
		view.getBtnSub().addActionListener(new SubmitAc(view, memoList));
		view.getBtnEnter().addActionListener(new ShowMemoAc(view, memoList));
	}
}
