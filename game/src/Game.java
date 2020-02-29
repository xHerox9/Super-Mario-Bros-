import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Game extends Application {
	private int HEIGHT = 640;
	private int WIDTH = 480;
	private String GAME_TITLE = "Demo"; // temp title.
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene (root);
		Canvas canvas = new Canvas (HEIGHT,WIDTH);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image background = new Image("Map_design.png");
		
		root.getChildren().add(canvas);
		primaryStage.setTitle(GAME_TITLE);
		primaryStage.setScene(scene);
		gc.drawImage(background, 0, 0);
		primaryStage.show();
	}
}
