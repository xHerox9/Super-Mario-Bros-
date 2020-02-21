import javafx.application.Application;
import javafx.stage.Stage;

public class game_Screen extends Application{
	private int HEIGHT = 600;
	private int WIDTH = 600;
	private String GAME_TITLE = "Demo"; // temp title
	
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage stage) {
		stage.setTitle(GAME_TITLE);
		stage.setHeight(HEIGHT);
		stage.setWidth(WIDTH);
		stage.show();
	}
}
