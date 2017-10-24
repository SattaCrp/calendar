package ku.sci.cs.calendar;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import controller.ShowActionlistener;
import model.Memo;
import view.View;

public class Test31Days {

	@Test
	public void test() {
		View view = new View(900,500);
		view.initFream();
		int year = Integer.parseInt(view.getComboBoxYear().getSelectedItem().toString());
		int month = view.getComboBoxMonth().getSelectedIndex();
		ShowActionlistener.showCalender(year, month,view.getComboBoxDay());
		
		assertEquals(31, view.getComboBoxDay().getItemCount());
	}

}
