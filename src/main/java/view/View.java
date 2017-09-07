package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class View {
	private int FRAME_WIDTH = 400;
	private int FRAME_HEIGHT = 500;
	private JFrame frame;
	private JPanel contentPane;
	private JComboBox comboBoxDay;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	private JButton btnShow;
	private JButton btnEnter;
	private JButton btnSub;
	private JButton btndel;
	private JTextArea areaMemo;

	public View() {
		frame = new JFrame("Calendar.");
	}

	public void initFream() {
		frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		frame.add(contentPane);

		JPanel panel01 = new JPanel();
		contentPane.add(panel01, BorderLayout.NORTH);
		panel01.setLayout(new GridLayout(0, 4, 0, 0));

		comboBoxMonth = new JComboBox(getMonth());
		panel01.add(comboBoxMonth);

		comboBoxYear = new JComboBox(getYear());
		panel01.add(comboBoxYear);

		btnShow = new JButton("ShowDays");

		panel01.add(btnShow);

		comboBoxDay = new JComboBox();
		panel01.add(comboBoxDay);

		JPanel panel02 = new JPanel();
		contentPane.add(panel02, BorderLayout.CENTER);
		panel02.setLayout(new GridLayout(0, 1, 0, 0));

		areaMemo = new JTextArea();
		areaMemo.setText("Calendar Memo \n step 1: chose month and year \n step 2: press ShowDays button"+ "\n step 3: chose days and press ShowMemo button \n step 4: Write a note \n step 5: press Sumbit button");
		areaMemo.setBorder(new TitledBorder(null, "Memo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel02.add(areaMemo);

		JPanel panel03 = new JPanel();
		contentPane.add(panel03, BorderLayout.SOUTH);
		panel03.setLayout(new GridLayout(0, 3, 0, 0));

		btnEnter = new JButton("Show Memo");
		btnSub = new JButton("Submit");
		btndel = new JButton("Delete");
		panel03.add(btnEnter);
		panel03.add(btnSub);
		panel03.add(btndel);
		

		frame.pack();
	}
	public JButton getBtndel() {
		return btndel;
	}
	public JButton getBtnShow() {
		return btnShow;
	}

	public JComboBox getComboBoxMonth() {
		return comboBoxMonth;
	}

	public JComboBox getComboBoxYear() {
		return comboBoxYear;
	}

	public JComboBox getComboBoxDay() {
		return comboBoxDay;
	}

	public JButton getBtnEnter() {
		return btnEnter;
	}

	public JButton getBtnSub() {
		return btnSub;
	}

	public JTextArea getAreaMemo() {
		return areaMemo;
	}

	public void setBtnShow(JButton btnShow) {
		this.btnShow = btnShow;
	}

	private String[] getYear() {
		String[] str = new String[201];
		for (int i = 2010, j = 0; i <= 2040; i++, j++) {
			str[j] = String.valueOf(i);
		}
		return str;
	}

	private String[] getMonth() {
		String[] str = { "January", "Febryary", "Match", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		return str;
	}

}
