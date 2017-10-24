package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class View {
	private int FRAME_WIDTH;
	private int FRAME_HEIGHT;
	private JFrame frame;
	private JPanel contentPane;
	private JComboBox comboBoxDay;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	private JButton btnEnter;
	private JButton btnSub;
	private JButton btndel;
	private JTextArea areaMemo;
	private JTextArea areaDairy;
	private JCheckBox checkDairy;
	private JCheckBox checkMon;
	private JCheckBox checkSun;
	private JCheckBox checkTue;
	private JCheckBox checkWen;
	private JCheckBox checkThu;
	private JCheckBox checkFri;
	private JCheckBox checkSat;
	private JCheckBox checkmonth;
	private JButton btnDiarySub;
	private JButton btnDiaryDel;

	public View(int width , int height) {
		FRAME_HEIGHT = height;
		FRAME_WIDTH = width;
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
		panel01.setLayout(new GridLayout(0, 3, 0, 0));

		comboBoxMonth = new JComboBox(getMonth());
		panel01.add(comboBoxMonth);

		comboBoxYear = new JComboBox(getYear());
		panel01.add(comboBoxYear);

		comboBoxDay = new JComboBox();
		panel01.add(comboBoxDay);

		JPanel panel02 = new JPanel();
		contentPane.add(panel02, BorderLayout.CENTER);
		panel02.setLayout(new GridLayout(2, 0, 0, 0));

		areaMemo = new JTextArea();
		areaMemo.setText("Calendar Memo \n step 1: chose month and year \n step 2: press ShowDays button"+ "\n step 3: chose days and press ShowMemo button \n step 4: Write a note \n step 5: press Sumbit button");
		areaMemo.setBorder(new TitledBorder(null, "Memo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel02.add(areaMemo);
		
		areaDairy = new JTextArea();
		areaDairy.setText("!!!! you should check a only one box !!!!");
		areaDairy.setBorder(new TitledBorder(null, "Diary", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel02.add(areaDairy);
		
		JPanel panel03 = new JPanel();
		panel03.setLayout(new GridLayout(0, 3, 0, 0));

		btnEnter = new JButton("Show Memo");
		btnSub = new JButton("Submit");
		btndel = new JButton("Delete");
		panel03.add(btnEnter);
		panel03.add(btnSub);
		panel03.add(btndel);
		
		JPanel panel04 = new JPanel();
		checkDairy = new JCheckBox("Every Day");
		checkSun = new JCheckBox("Every Sun");
		checkMon = new JCheckBox("Every Mon");
		checkTue = new JCheckBox("Every Tue");
		checkWen = new JCheckBox("Every wen");
		checkThu = new JCheckBox("Every Thu");
		checkFri = new JCheckBox("Every Fri");
		checkSat = new JCheckBox("Every Sat");
		checkmonth = new JCheckBox("Every Month");
		panel04.add(checkDairy);
		panel04.add(checkSun);
		panel04.add(checkMon);
		panel04.add(checkTue);
		panel04.add(checkWen);
		panel04.add(checkThu);
		panel04.add(checkFri);
		panel04.add(checkSat);
		panel04.add(checkmonth);
		panel04.setLayout(new GridLayout(2, 5));
		
		JPanel panel05 = new JPanel();
		panel05.setLayout(new GridLayout(2, 0, 0, 0));
		panel05.add(panel03);
		panel05.add(panel04);
		contentPane.add(panel05, BorderLayout.SOUTH);
		
		JPanel panel06 = new JPanel();
		btnDiarySub = new JButton("Submit");
		btnDiaryDel = new JButton("Delete");
		panel06.add(btnDiarySub);
		panel06.add(btnDiaryDel);
		panel04.add(panel06);
		
		frame.setResizable(false);
		frame.pack();
	}
	
	public int getFRAME_WIDTH() {
		return FRAME_WIDTH;
	}

	public int getFRAME_HEIGHT() {
		return FRAME_HEIGHT;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextArea getAreaDairy() {
		return areaDairy;
	}

	public JCheckBox getCheckDairy() {
		return checkDairy;
	}

	public JCheckBox getCheckMon() {
		return checkMon;
	}

	public JCheckBox getCheckSun() {
		return checkSun;
	}

	public JCheckBox getCheckTue() {
		return checkTue;
	}

	public JCheckBox getCheckWen() {
		return checkWen;
	}

	public JCheckBox getCheckThu() {
		return checkThu;
	}

	public JCheckBox getCheckFri() {
		return checkFri;
	}

	public JCheckBox getCheckSat() {
		return checkSat;
	}

	public JCheckBox getCheckmonth() {
		return checkmonth;
	}

	public JButton getBtnDiarySub() {
		return btnDiarySub;
	}

	public JButton getBtnDiaryDel() {
		return btnDiaryDel;
	}

	public JButton getBtndel() {
		return btndel;
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

	private String[] getYear() {
		String[] str = new String[201];
		for (int i = 2010, j = 0; i <= 2020; i++, j++) {
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
