import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.MainController;
import model.JdbcSQLiteConnection;
import view.View;

public class AppRun {
	
	public static void main(String[] args) {
		
		View view = new View(900,500);
		MainController main = new MainController(view);
		main.startApplication();
		JdbcSQLiteConnection.checkConnect();
		JdbcSQLiteConnection.selectFromMemoList("");
		JdbcSQLiteConnection.selectFromDiaryList("");
	
	}
}
