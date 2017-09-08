import controller.MainController;
import model.JdbcSQLiteConnection;

public class AppRun {
	
	public static void main(String[] args) {
		MainController main = new MainController();
		main.startApplication();
		JdbcSQLiteConnection.checkConnect();
		JdbcSQLiteConnection.selectFrom("");
	}
}
