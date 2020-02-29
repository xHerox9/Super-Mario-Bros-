import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Game extends Application {
	private int HEIGHT = 600;
	private int WIDTH = 600;
	private String GAME_TITLE = "Demo"; // temp title.
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene (root);
		Canvas canvas = new Canvas (HEIGHT,WIDTH);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		primaryStage.setTitle(GAME_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
