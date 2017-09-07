package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
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
		ShowActionlistener.showCalender(year, month,view.getComboBoxDay());
	}
	

//calculate date --------------------------------------------------------
	public static void showCalender(int yearSelect, int monthSelect , JComboBox comboBoxDay ) {
		int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int year = 1900;
		int month = 0;
		int day = 2;
		while (check(yearSelect, monthSelect, year, month)) {
			if (month == 1 && leapYear(year)) {
				day = day + 29;
			} else {
				day = day + monthDay[month];
			}
			month++;
			if (month == 12) {
				month = 0;
				year++;
			}
			day = day % 7;
		}

		int lastValue = monthDay[monthSelect];
		if (monthSelect == 1 && leapYear(yearSelect)) {
			lastValue++;
		}
		updateDay(lastValue,comboBoxDay);

	}

	private static void updateDay(int lastday, JComboBox comboBoxDay) {
		for (int i = 1; i < lastday + 1; i++) {
			comboBoxDay.addItem(i);
		}
	}

	private static boolean leapYear(int year) {
		boolean ans = false;
		if (year % 4 == 0) {
			ans = true;
			if (year % 100 == 0) {
				ans = false;

			}
			if (year % 400 == 0) {
				ans = true;
			}
		}
		return false;
	}

	private static boolean check(int comboBoxYear, int comboBoxMonth, int year, int month) {
		if (comboBoxYear == year && comboBoxMonth == month) {
			return false;
		}
		return true;
	}



}
