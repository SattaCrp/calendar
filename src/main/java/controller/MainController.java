package controller;

import java.util.ArrayList;


import model.Memo;
import view.View;

public class MainController {
	private View view;
	private ArrayList<Memo> memoList;

	public void startApplication() {
		view = new View();
		memoList = new ArrayList<>();
		view.initFream();
		view.getBtnShow().addActionListener(new ShowActionlistener(view));
		view.getBtnSub().addActionListener(new SubmitAc(view, memoList));
		view.getBtnEnter().addActionListener(new ShowMemoAc(view, memoList));
	}
}
