package controller;

import java.util.ArrayList;


import model.Memo;
import view.View;

public class MainController {
	private View view;

	public void startApplication() {
		view = new View();
		view.initFream();
		view.getBtnShow().addActionListener(new ShowActionlistener(view));
		view.getBtnSub().addActionListener(new SubmitAc(view));
		view.getBtnEnter().addActionListener(new ShowMemoAc(view));
		view.getBtndel().addActionListener(new DeleteAc(view));
	}
}
